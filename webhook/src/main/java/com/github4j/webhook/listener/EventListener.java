package com.github4j.webhook.listener;

import com.github4j.event.GithubEvent;

import java.util.List;

public interface EventListener<T extends GithubEvent> {
    List<Class<? extends GithubEvent>> getSupportedEvents();

    void handle(T event);
}
