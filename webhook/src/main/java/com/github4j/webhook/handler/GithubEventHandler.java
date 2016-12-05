package com.github4j.webhook.handler;

import com.github4j.event.GithubEvent;
import com.github4j.event.PingEvent;
import com.github4j.event.PushEvent;
import com.github4j.event.StatusEvent;
import com.github4j.json.GithubGson;
import com.github4j.webhook.listener.EventListener;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class GithubEventHandler extends AbstractHandler {
    private static final Logger LOG = LoggerFactory.getLogger(GithubEventHandler.class);

    private static final String HOST_HEADER = "Host";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String JSON_MEDIA_TYPE = "application/json";
    private static final String FORM_MEDIA_TYPE = "application/x-www-form-urlencoded";
    private static final String SIGNATURE_HEADER = "X-Hub-Signature";
    private static final String EVENT_HEADER = "X-GitHub-Event";

    private final Map<String, Class<? extends GithubEvent>> nameToEventClass;
    private final Gson gson = GithubGson.singleton();

    private final String host;
    private final String path;
    private final String secret;
    private final Map<Class<? extends GithubEvent>, List<EventListener>> listeners;

    public GithubEventHandler(String host, String path, String secret,
                              Map<Class<? extends GithubEvent>, List<EventListener>> listeners) {
        this.host = isBlank(host) ? "" : host;
        this.path = isBlank(path) ? "" : path;
        this.secret = isBlank(secret) ? "" : secret;
        this.listeners = listeners;

        Map<String, Class<? extends GithubEvent>> map = new HashMap<>();
        map.put("ping", PingEvent.class);
        map.put("push", PushEvent.class);
        map.put("status", StatusEvent.class);

        nameToEventClass = Collections.unmodifiableMap(map);
    }

    @Override
    public void handle(String target, Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        // Examine target and path
        if (!host.isEmpty() && !request.getHeader(HOST_HEADER).equalsIgnoreCase(host)) {
            LOG.info("Host mismatched. Sending 404 Not Found...");
            sendMessage(response, HttpServletResponse.SC_NOT_FOUND, "");
            baseRequest.setHandled(true);
            return;
        }

        // Examine target path
        if (!path.isEmpty() && !target.equals(path)) {
            LOG.info("Path mismatched. Sending 404 Not Found...");
            sendMessage(response, HttpServletResponse.SC_NOT_FOUND, "");
            baseRequest.setHandled(true);
            return;
        }

        // Extract payload
        String payload;
        String receviedContentType = request.getHeader(CONTENT_TYPE_HEADER);
        if (JSON_MEDIA_TYPE.equalsIgnoreCase(receviedContentType))
            payload = IOUtils.toString(request.getReader());
        else if (FORM_MEDIA_TYPE.equalsIgnoreCase(receviedContentType)) {
            String actualBody = IOUtils.toString(request.getReader());
            if (actualBody.startsWith("payload="))
                payload = actualBody.substring(8);
            else {
                LOG.info("Received invalid form date. Sending 406 Not Acceptable...");
                sendMessage(response, HttpServletResponse.SC_NOT_ACCEPTABLE,
                        "The received form payload is in invalid format.");
                baseRequest.setHandled(true);
                return;
            }
        } else {
            LOG.info("Received invalid content type `{}`. Sending 406 Not Acceptable...", receviedContentType);
            sendMessage(response, HttpServletResponse.SC_NOT_ACCEPTABLE,
                    "The received content type `" + request.getHeader(CONTENT_TYPE_HEADER) + "` is not acceptable.");
            baseRequest.setHandled(true);
            return;
        }
        LOG.info("Received payload:\n{}", payload);

        // Examine HMAC
        String receivedHmac = request.getHeader(SIGNATURE_HEADER);
        if (!secret.isEmpty() && !isBlank(receivedHmac) && receivedHmac.startsWith("sha1=")) {
            receivedHmac = receivedHmac.substring(5);
            LOG.info("Received HMAC {}.", receivedHmac);
            String computedHmac;
            try {
                computedHmac = HmacUtils.hmacSha1Hex(secret, payload);
            } catch (Exception e) {
                LOG.warn("Exception occurred when trying to compute HMAC for the received payload: ", e);
                sendMessage(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                        "Exception occurred when trying to compute HMAC for the received payload:\n" +
                                ExceptionUtils.getStackTrace(e));
                baseRequest.setHandled(true);
                return;
            }

            if (!receivedHmac.equalsIgnoreCase(computedHmac)) {
                LOG.info("HMAC mismatched. Received HMAC={}, Actual HMAC={}. Sending 401 Unauthorized...", receivedHmac, computedHmac);
                sendMessage(response, HttpServletResponse.SC_UNAUTHORIZED,
                        "The given HMAC is incorrect!");
                baseRequest.setHandled(true);
                return;
            }
        }

        // Parse the event
        String eventTypeStr = request.getHeader(EVENT_HEADER);
        if (!nameToEventClass.containsKey(eventTypeStr)) {
            LOG.info("Received unsupported event type `{}`. Sending 406 Not Acceptable...", eventTypeStr);
            sendMessage(response, HttpServletResponse.SC_NOT_ACCEPTABLE,
                    "The given event type `" + eventTypeStr + "` is not supported.");
            baseRequest.setHandled(true);
            return;
        }
        Class eventType = nameToEventClass.get(eventTypeStr);
        if (!listeners.containsKey(eventType) || listeners.get(eventType).isEmpty()) {
            LOG.info("No registered listener could be found for event type `{}`. Sending 204 No Content...", eventType.getName());
            sendMessage(response, HttpServletResponse.SC_NO_CONTENT,
                    "The event is received and recorded, but there is no registered listener for this event.");
            baseRequest.setHandled(true);
            return;
        }

        final GithubEvent event;
        try {
            event = gson.fromJson(payload, nameToEventClass.get(eventTypeStr));
        } catch (JsonSyntaxException e) {
            LOG.warn("Exception occurred when trying to parse the received payload: ", e);
            sendMessage(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "Exception occurred when trying to parse the received payload:\n" +
                            ExceptionUtils.getStackTrace(e));
            baseRequest.setHandled(true);
            return;
        }

        final List<EventListener> matchedListeners = listeners.get(eventType);
        if (matchedListeners != null && !matchedListeners.isEmpty()) {
            new Thread(new Runnable() {
                @Override
                @SuppressWarnings("unchecked")
                public void run() {
                    for (EventListener listener : matchedListeners)
                        listener.handle(event);
                }
            }).start();
            LOG.info("Listener triggered for event type `{}`. Sending 202 Accepted...", eventType.getName());
            sendMessage(response, HttpServletResponse.SC_ACCEPTED,
                    "The event is received. Registered listener for this event is found and is handling the event.");
        } else {
            LOG.info("No listener can be found for event type `{}`. Sending 204 No Content...", eventType.getName());
            sendMessage(response, HttpServletResponse.SC_NO_CONTENT,
                    "The event is received, but no registered listener for be found for this type of event.");
        }

        baseRequest.setHandled(true);
    }

    private void sendMessage(HttpServletResponse response, int statusCode, String message) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        response.setStatus(statusCode);
        PrintWriter out = response.getWriter();
        out.print(message);
    }
}
