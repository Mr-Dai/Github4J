package com.github4j;

import com.google.gson.annotations.SerializedName;
import org.joda.time.LocalDateTime;

public class Repository {
    private int id;
    private User owner;
    private String name;
    private String fullName;
    private String description;
    @SerializedName("private") private boolean _private;
    private boolean fork;
    private String url;
    private String homepage;
    private String language;
    private int forksCount;
    private int stargazersCount;
    private int watchersCount;
    private int size;
    private String defaultBranch;
    private int openIssuesCount;
    private boolean hasIssues;
    private boolean hasWiki;
    private boolean hasPages;
    private boolean hasDownloads;
    private LocalDateTime pushedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Permissions permissions;

    /* Getters and Setters */
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public boolean isPrivate() { return _private; }
    public void setPrivate(boolean _private) { this._private = _private; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public String getHomepage() { return homepage; }
    public void setHomepage(String homepage) { this.homepage = homepage; }
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
    public int getForksCount() { return forksCount; }
    public void setForksCount(int forksCount) { this.forksCount = forksCount; }
    public int getStargazersCount() { return stargazersCount; }
    public void setStargazersCount(int stargazersCount) { this.stargazersCount = stargazersCount; }
    public int getWatchersCount() { return watchersCount; }
    public void setWatchersCount(int watchersCount) { this.watchersCount = watchersCount; }
    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }
    public String getDefaultBranch() { return defaultBranch; }
    public void setDefaultBranch(String defaultBranch) { this.defaultBranch = defaultBranch; }
    public int getOpenIssuesCount() { return openIssuesCount; }
    public void setOpenIssuesCount(int openIssuesCount) { this.openIssuesCount = openIssuesCount; }
    public LocalDateTime getPushedAt() { return pushedAt; }
    public void setPushedAt(LocalDateTime pushedAt) { this.pushedAt = pushedAt; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public Permissions getPermissions() { return permissions; }
    public void setPermissions(Permissions permissions) { this.permissions = permissions; }
    public void setFork(boolean fork) { this.fork = fork; }
    public void setHasIssues(boolean hasIssues) { this.hasIssues = hasIssues; }
    public void setHasWiki(boolean hasWiki) { this.hasWiki = hasWiki; }
    public void setHasPages(boolean hasPages) { this.hasPages = hasPages; }
    public void setHasDownloads(boolean hasDownloads) { this.hasDownloads = hasDownloads; }
    public boolean isFork() { return fork; }
    public boolean isHasIssues() { return hasIssues; }
    public boolean isHasWiki() { return hasWiki; }
    public boolean isHasPages() { return hasPages; }
    public boolean isHasDownloads() { return hasDownloads; }

    public static class Permissions {
        private boolean admin;
        private boolean push;
        private boolean pull;

        /* Getters and Setters */
        public boolean isAdmin() { return admin; }
        public void setAdmin(boolean admin) { this.admin = admin; }
        public boolean isPush() { return push; }
        public void setPush(boolean push) { this.push = push; }
        public boolean isPull() { return pull; }
        public void setPull(boolean pull) { this.pull = pull; }
    }
}
