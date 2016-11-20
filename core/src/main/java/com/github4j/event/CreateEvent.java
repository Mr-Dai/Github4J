package com.github4j.event;

import com.github4j.Repository;
import com.github4j.User;

/**
 * Represents a created repository, branch, or tag.
 */
public class CreateEvent extends GithubEvent {
    private String ref;
    private RefType refType;
    private String masterBranch;
    private String description;
    private String pusherType;
    private Repository repository;
    private User sender;

    /* Getters and Setters */
    public String getRef() { return ref; }
    public void setRef(String ref) { this.ref = ref; }
    public RefType getRefType() { return refType; }
    public void setRefType(RefType refType) { this.refType = refType; }
    public String getMasterBranch() { return masterBranch; }
    public void setMasterBranch(String masterBranch) { this.masterBranch = masterBranch; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getPusherType() { return pusherType; }
    public void setPusherType(String pusherType) { this.pusherType = pusherType; }
    public Repository getRepository() { return repository; }
    public void setRepository(Repository repository) { this.repository = repository; }
    public User getSender() { return sender; }
    public void setSender(User sender) { this.sender = sender; }
}
