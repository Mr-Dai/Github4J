package com.github4j.event;

import com.github4j.Commit;
import com.github4j.GitUser;
import com.github4j.Repository;
import com.github4j.User;

import java.util.List;

/**
 * Triggered when a repository branch is pushed to.
 * In addition to branch pushes, webhook push events are also triggered when repository tags are pushed.
 */
public class PushEvent {
    private String ref;
    private String head;
    private String before;
    private int size;
    private int distinctSize;
    private boolean created;
    private boolean deleted;
    private boolean forced;
    private String baseRef;
    private String compare;
    private List<Commit> commits;
    private Commit headCommit;
    private Repository repository;
    private GitUser pusher;
    private User sender;

    /* Getters and Setters */
    public String getRef() { return ref; }
    public void setRef(String ref) { this.ref = ref; }
    public String getHead() { return head; }
    public void setHead(String head) { this.head = head; }
    public String getBefore() { return before; }
    public void setBefore(String before) { this.before = before; }
    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }
    public int getDistinctSize() { return distinctSize; }
    public void setDistinctSize(int distinctSize) { this.distinctSize = distinctSize; }
    public String getBaseRef() { return baseRef; }
    public void setBaseRef(String baseRef) { this.baseRef = baseRef; }
    public String getCompare() { return compare; }
    public void setCompare(String compare) { this.compare = compare; }
    public List<Commit> getCommits() { return commits; }
    public void setCommits(List<Commit> commits) { this.commits = commits; }
    public Commit getHeadCommit() { return headCommit; }
    public void setHeadCommit(Commit headCommit) { this.headCommit = headCommit; }
    public Repository getRepository() { return repository; }
    public void setRepository(Repository repository) { this.repository = repository; }
    public GitUser getPusher() { return pusher; }
    public void setPusher(GitUser pusher) { this.pusher = pusher; }
    public User getSender() { return sender; }
    public void setSender(User sender) { this.sender = sender; }
    public void setCreated(boolean created) { this.created = created; }
    public void setDeleted(boolean deleted) { this.deleted = deleted; }
    public void setForced(boolean forced) { this.forced = forced; }
    public boolean isCreated() { return created; }
    public boolean isDeleted() { return deleted; }
    public boolean isForced() { return forced; }
}
