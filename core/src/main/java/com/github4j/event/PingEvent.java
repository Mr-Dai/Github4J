package com.github4j.event;

import com.github4j.Hook;
import com.github4j.Repository;
import com.github4j.User;

public class PingEvent extends GithubEvent {
    private String zen;
    private int hookId;
    private Hook hook;
    private Repository repository;
    private User sender;

    /* Getters and Setters */
    public String getZen() { return zen; }
    public void setZen(String zen) { this.zen = zen; }
    public int getHookId() { return hookId; }
    public void setHookId(int hookId) { this.hookId = hookId; }
    public Hook getHook() { return hook; }
    public void setHook(Hook hook) { this.hook = hook; }
    public Repository getRepository() { return repository; }
    public void setRepository(Repository repository) { this.repository = repository; }
    public User getSender() { return sender; }
    public void setSender(User sender) { this.sender = sender; }
}
