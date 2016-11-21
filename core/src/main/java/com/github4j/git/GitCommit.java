package com.github4j.git;

import org.joda.time.LocalDateTime;

import java.util.List;

/**
 * A Git commit.
 * <p>
 * URL format:
 * <pre>
 *     https://api.github.com/repos/:owner/:repo/git/commits/:sha
 * </pre>
 */
public class GitCommit {
    private String sha;
    private Author author;
    private Author committer;
    private String message;
    private Tree tree;
    private List<Tree> parents;
    private int commentCount;
    private Verification verification;

    /* Getters and Setters */
    public String getSha() { return sha; }
    public void setSha(String sha) { this.sha = sha; }
    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }
    public Author getCommitter() { return committer; }
    public void setCommitter(Author committer) { this.committer = committer; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public Tree getTree() { return tree; }
    public void setTree(Tree tree) { this.tree = tree; }
    public List<Tree> getParents() { return parents; }
    public void setParents(List<Tree> parents) { this.parents = parents; }
    public int getCommentCount() { return commentCount; }
    public void setCommentCount(int commentCount) { this.commentCount = commentCount; }
    public Verification getVerification() { return verification; }
    public void setVerification(Verification verification) { this.verification = verification; }

    public static class Tree {
        private String sha;

        public String getSha() { return sha; }
        public void setSha(String sha) { this.sha = sha; }
    }

    public static class Author {
        private String name;
        private String email;
        private LocalDateTime date;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public LocalDateTime getDate() { return date; }
        public void setDate(LocalDateTime date) { this.date = date; }
    }

    public static class Verification {
        private boolean verified;
        private String reason;
        private String signature;
        private String payload;

        public String getReason() { return reason; }
        public void setReason(String reason) { this.reason = reason; }
        public String getSignature() { return signature; }
        public void setSignature(String signature) { this.signature = signature; }
        public String getPayload() { return payload; }
        public void setPayload(String payload) { this.payload = payload; }
        public boolean isVerified() { return verified; }
        public void setVerified(boolean verified) { this.verified = verified; }
    }
}
