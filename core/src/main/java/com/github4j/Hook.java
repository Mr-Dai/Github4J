package com.github4j;

import org.joda.time.LocalDateTime;

import java.util.List;

public class Hook {
    private int id;
    private String url;
    private String name;
    private boolean active;
    private Config config;
    private List<String> events;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /* Getters and Setters */
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Config getConfig() { return config; }
    public void setConfig(Config config) { this.config = config; }
    public List<String> getEvents() { return events; }
    public void setEvents(List<String> events) { this.events = events; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public static class Config {
        private String url;
        private String contentType;

        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
        public String getContentType() { return contentType; }
        public void setContentType(String contentType) { this.contentType = contentType; }
    }
}
