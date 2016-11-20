package com.github4j.event;

import com.github4j.Comment;
import com.github4j.Repository;
import com.github4j.User;

/**
 * Triggered when a
 * <a href="https://developer.github.com/v3/repos/comments/#list-commit-comments-for-a-repository">commit comment</a>
 * is created.
 */
public class CommitCommentEvent extends GithubEvent {
    private String action;
    private Comment comment;
    private User sender;
    private Repository repository;

    /* Getters and Setters */
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    public Comment getComment() { return comment; }
    public void setComment(Comment comment) { this.comment = comment; }
    public User getSender() { return sender; }
    public void setSender(User sender) { this.sender = sender; }
    public Repository getRepository() { return repository; }
    public void setRepository(Repository repository) { this.repository = repository; }
}
