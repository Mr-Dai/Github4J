package com.github4j.handler;

import com.github4j.event.GithubEvent;
import com.github4j.listener.EventListener;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GithubEventHandler extends AbstractHandler {
    private static final Logger LOG = LoggerFactory.getLogger(GithubEventHandler.class);

    private final String host;
    private final String path;
    private final Map<Class<? extends GithubEvent>, List<EventListener>> listeners;

    public GithubEventHandler(String host, String path,
                              Map<Class<? extends GithubEvent>, List<EventListener>> listeners) {
        this.host = host;
        this.path = path;
        this.listeners = listeners;
    }

    @Override
    public void handle(String target, Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {

    }
}
