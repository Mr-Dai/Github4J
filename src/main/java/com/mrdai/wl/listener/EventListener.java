package com.mrdai.wl.listener;

import com.mrdai.wl.event.GithubEvent;

public interface EventListener<T extends GithubEvent> {
    void handle(T event);
}
