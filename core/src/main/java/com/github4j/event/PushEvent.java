package com.github4j.event;

import com.github4j.Organization;
import com.github4j.Repository;
import com.github4j.User;
import com.github4j.git.GitUser;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Triggered when a repository branch is pushed to.
 * In addition to branch pushes, webhook push events are also triggered when repository tags are pushed.
 */
public class PushEvent extends GithubEvent {
    private String ref;
    private String before;
    private String after;
    private boolean created;
    private boolean deleted;
    private boolean forced;
    private String baseRef;
    private String compare;
    private List<Commit> commits;
    private Commit headCommit;
    private Repository repository;
    private GitUser pusher;
    private Organization organization;
    private User sender;

    /* Getters and Setters */
    public String getRef() { return ref; }
    public void setRef(String ref) { this.ref = ref; }
    public String getBefore() { return before; }
    public void setBefore(String before) { this.before = before; }
    public String getAfter() { return after; }
    public void setAfter(String after) { this.after = after; }
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
    public Organization getOrganization() { return organization; }
    public void setOrganization(Organization organization) { this.organization = organization; }
    public void setCreated(boolean created) { this.created = created; }
    public void setDeleted(boolean deleted) { this.deleted = deleted; }
    public void setForced(boolean forced) { this.forced = forced; }
    public boolean isCreated() { return created; }
    public boolean isDeleted() { return deleted; }
    public boolean isForced() { return forced; }

    public static class Commit {
        private String id;
        private String treeId;
        private boolean distinct;
        private String message;
        private DateTime timestamp;
        private GitUser author;
        private GitUser committer;
        private List<String> added;
        private List<String> removed;
        private List<String> modified;

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getTreeId() { return treeId; }
        public void setTreeId(String treeId) { this.treeId = treeId; }
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        public DateTime getTimestamp() { return timestamp; }
        public void setTimestamp(DateTime timestamp) { this.timestamp = timestamp; }
        public GitUser getAuthor() { return author; }
        public void setAuthor(GitUser author) { this.author = author; }
        public GitUser getCommitter() { return committer; }
        public void setCommitter(GitUser committer) { this.committer = committer; }
        public List<String> getAdded() { return added; }
        public void setAdded(List<String> added) { this.added = added; }
        public List<String> getRemoved() { return removed; }
        public void setRemoved(List<String> removed) { this.removed = removed; }
        public List<String> getModified() { return modified; }
        public void setModified(List<String> modified) { this.modified = modified; }
        public boolean isDistinct() { return distinct; }
        public void setDistinct(boolean distinct) { this.distinct = distinct; }
    }
}
