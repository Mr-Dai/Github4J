package com.github4j;

import com.github4j.event.GithubEvent;
import com.github4j.handler.GithubEventHandler;
import com.github4j.handler.HelloHandler;
import com.github4j.handler.LogHandler;
import com.github4j.listener.EventListener;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;

import java.util.*;

public class WebHookListener {
    private String host;
    private int port;
    private String path;
    private Map<Class<? extends GithubEvent>, List<EventListener>> listeners = new HashMap<>();

    private Server server;

    public WebHookListener(String host) {
        this(host, 4567, "/");
    }

    public WebHookListener(String host, int port, String path) {
        this.host = host;
        this.port = port;
        this.path = path;
    }

    public void start() throws Exception {
        server = new Server(port);
        HandlerCollection handlers = new HandlerCollection();
        handlers.addHandler(new LogHandler());
        Map<Class<? extends GithubEvent>, List<EventListener>> newListeners = new HashMap<>();
        for (Map.Entry<Class<? extends GithubEvent>, List<EventListener>> entry : listeners.entrySet())
            newListeners.put(entry.getKey(), Collections.unmodifiableList(entry.getValue()));
        handlers.addHandler(new GithubEventHandler(host, path, Collections.unmodifiableMap(newListeners)));
        handlers.addHandler(new HelloHandler("Message received!"));
        server.setHandler(handlers);

        server.start();
    }

    public void stop() throws Exception {
        server.stop();
    }

    public <T extends GithubEvent> WebHookListener addListener(Class<T> eventType, EventListener<? super T> listener) {
        if (!listeners.containsKey(eventType)) {
            List<EventListener> newList = new LinkedList<>();
            newList.add(listener);
            listeners.put(eventType, newList);
        } else
            listeners.get(eventType).add(listener);
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

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getPath() {
        return path;
    }
}
