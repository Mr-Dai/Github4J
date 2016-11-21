package com.github4j.event;

import com.github4j.*;
import org.joda.time.LocalDateTime;

import java.util.List;

/**
 * Triggered when the status of a Git commit changes.
 */
public class StatusEvent extends GithubEvent {
    private int id;
    private String sha;
    private String name;
    private String targetUrl;
    private String context;
    private String description;
    private State state;
    private Commit commit;
    private List<Branch> branches;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Repository repository;
    private Organization organization;
    private User sender;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getSha() { return sha; }
    public void setSha(String sha) { this.sha = sha; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getTargetUrl() { return targetUrl; }
    public void setTargetUrl(String targetUrl) { this.targetUrl = targetUrl; }
    public String getContext() { return context; }
    public void setContext(String context) { this.context = context; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public State getState() { return state; }
    public void setState(State state) { this.state = state; }
    public Commit getCommit() { return commit; }
    public void setCommit(Commit commit) { this.commit = commit; }
    public List<Branch> getBranches() { return branches; }
    public void setBranches(List<Branch> branches) { this.branches = branches; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public Repository getRepository() { return repository; }
    public void setRepository(Repository repository) { this.repository = repository; }
    public Organization getOrganization() { return organization; }
    public void setOrganization(Organization organization) { this.organization = organization; }
    public User getSender() { return sender; }
    public void setSender(User sender) { this.sender = sender; }

    public enum State {
        Pending, Success, Failure, Error
    }
}
