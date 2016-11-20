package com.github4j;

import org.joda.time.LocalDateTime;

import java.util.List;

public class Commit {
    private String sha;
    private String url;
    private Author author;
    private Author committer;
    private String message;
    private Tree tree;
    private List<Tree> parents;

    /* Getters and Setters */
    public String getSha() { return sha; }
    public void setSha(String sha) { this.sha = sha; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
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

    public static class Tree {
        private String sha;
        private String url;

        public String getSha() { return sha; }
        public void setSha(String sha) { this.sha = sha; }
        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
    }

    public static class Author extends GitUser {
        private LocalDateTime date;

        public LocalDateTime getDate() { return date; }
        public void setDate(LocalDateTime date) { this.date = date; }
    }
}
