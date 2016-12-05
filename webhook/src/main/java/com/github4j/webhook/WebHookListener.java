package com.github4j.webhook;

import com.github4j.event.GithubEvent;
import com.github4j.webhook.listener.EventListener;
import com.github4j.webhook.handler.GithubEventHandler;
import com.github4j.webhook.handler.LogHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class WebHookListener {
    private static final Logger LOG = LoggerFactory.getLogger(WebHookListener.class);

    private String host;
    private int port;
    private String path;
    private String secret;
    private boolean verboseLogEnabled;
    private Map<Class<? extends GithubEvent>, List<com.github4j.webhook.listener.EventListener>> listeners = new HashMap<>();

    private Server server;

    public WebHookListener() {
        this("");
    }

    public WebHookListener(String host) {
        this(host, 4567, "/", "");
    }

    public WebHookListener(String host, int port, String path, String secret) {
        this(host, port, path, secret, false);
    }

    public WebHookListener(String host, int port, String path, String secret, boolean verboseLogEnabled) {
        this.host = host;
        this.port = port;
        this.path = path;
        this.secret = secret;
        this.verboseLogEnabled = verboseLogEnabled;
    }

    public void start() throws Exception {
        if (isBlank(secret))
            LOG.warn("Starting webhook listener without any secret key, which is highly unrecommended.");

        server = new Server(port);
        HandlerCollection handlers = new HandlerCollection();
        if (verboseLogEnabled)
            handlers.addHandler(new LogHandler());
        Map<Class<? extends GithubEvent>, List<EventListener>> newListeners = new HashMap<>();
        for (Map.Entry<Class<? extends GithubEvent>, List<EventListener>> entry : listeners.entrySet())
            newListeners.put(entry.getKey(), Collections.unmodifiableList(entry.getValue()));
        handlers.addHandler(new GithubEventHandler(host, path, secret, Collections.unmodifiableMap(newListeners)));
        server.setHandler(handlers);

        server.start();
    }

    public void stop() throws Exception {
        server.stop();
    }

    public <T extends GithubEvent> WebHookListener addListener(EventListener<? super T> listener) {
        List<Class<? extends GithubEvent>> supportedEvents = listener.getSupportedEvents();
        if (supportedEvents == null || supportedEvents.isEmpty())
            throw new IllegalArgumentException("Result of `#getSupportedEvents()` of the given listener cannot be null or empty.");
        for (Class<? extends GithubEvent> eventType : supportedEvents) {
            if (!listeners.containsKey(eventType)) {
                List<EventListener> newList = new LinkedList<>();
                newList.add(listener);
                listeners.put(eventType, newList);
            } else
                listeners.get(eventType).add(listener);
        }
        return this;
    }

    public WebHookListener setHost(String host) {
        this.host = host;
        return this;
    }

    public WebHookListener setPort(int port) {
        this.port = port;
        return this;
    }

    public WebHookListener setPath(String path) {
        this.path = path;
        return this;
    }

    public WebHookListener setSecret(String secret) {
        this.secret = secret;
        return this;
    }

    public WebHookListener setVerboseLogEnabled(boolean verboseLogEnabled) {
        this.verboseLogEnabled = verboseLogEnabled;
        return this;
    }

    public String getHost() { return host; }
    public int getPort() { return port; }
    public String getPath() { return path; }
    public String getSecret() { return secret; }
    public boolean isVerboseLogEnabled() { return verboseLogEnabled; }
}
