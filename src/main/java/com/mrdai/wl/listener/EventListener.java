package com.mrdai.wl.listener;

import com.github4j.event.GithubEvent;

public interface EventListener<T extends GithubEvent> {
    void handle(T event);
}
