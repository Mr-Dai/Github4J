package com.github4j.event;

import com.github4j.Repository;
import com.github4j.User;

/**
 * Represents a
 * <a href="https://developer.github.com/v3/git/refs/#delete-a-reference">deleted branch or tag</a>.
 */
public class DeleteEvent {
    private String ref;
    private RefType refType;
    private String pusherType;
    private Repository repository;
    private User sender;

    public String getRef() { return ref; }
    public void setRef(String ref) { this.ref = ref; }
    public RefType getRefType() { return refType; }
    public void setRefType(RefType refType) { this.refType = refType; }
    public String getPusherType() { return pusherType; }
    public void setPusherType(String pusherType) { this.pusherType = pusherType; }
    public Repository getRepository() { return repository; }
    public void setRepository(Repository repository) { this.repository = repository; }
    public User getSender() { return sender; }
    public void setSender(User sender) { this.sender = sender; }
}
