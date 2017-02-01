package com.github4j.webhook;

import com.github4j.event.GithubEvent;
import com.github4j.webhook.handler.GithubEventHandler;
import com.github4j.webhook.handler.LogHandler;
import com.github4j.webhook.listener.EventListener;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class StandaloneWebHookListener extends WebHookListener {
    private static final Logger LOG = LoggerFactory.getLogger(StandaloneWebHookListener.class);

    private Path listenerPath;

    public StandaloneWebHookListener(String host, int port, String path, String secret, boolean verboseLogEnabled,
                                     Path listenerPath) {
        super(host, port, path, secret, verboseLogEnabled);
        this.listenerPath = listenerPath;
    }

    @Override
    public void start() throws Exception {
        if (isBlank(getSecret()))
            LOG.warn("Starting webhook listener without any secret key, which is highly unrecommended.");

        Server server = new Server(getPort());
        HandlerCollection handlers = new HandlerCollection();
        if (isVerboseLogEnabled())
            handlers.addHandler(new LogHandler());
        handlers.addHandler(new GithubEventHandler(getHost(), getPath(), getSecret(), new ChangeAwareListenerMap(listenerPath)));
        server.setHandler(handlers);

        server.start();
    }

    @Override
    public <T extends GithubEvent> WebHookListener addListener(EventListener<? super T> listener) {
        throw new UnsupportedOperationException("Standalone WebHook Listener does not support adding listener programmatically.");
    }

    public Path getListenerPath() { return listenerPath; }
    public void setListenerPath(Path listenerPath) { this.listenerPath = listenerPath; }
}
