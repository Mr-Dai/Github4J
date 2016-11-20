package com.github4j;

import org.joda.time.LocalDateTime;

public class Comment {
    private int id;
    private String url;
    private String htmlUrl;
    private String body;
    private String path;
    private int position;
    private int line;
    private User user;
    private String commitId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /* Getters and Setters */
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getHtmlUrl() { return htmlUrl; }
    public void setHtmlUrl(String htmlUrl) { this.htmlUrl = htmlUrl; }
    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }
    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }
    public int getPosition() { return position; }
    public void setPosition(int position) { this.position = position; }
    public int getLine() { return line; }
    public void setLine(int line) { this.line = line; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getCommitId() { return commitId; }
    public void setCommitId(String commitId) { this.commitId = commitId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
