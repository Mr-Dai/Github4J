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
    private String htmlUrl;
    private String archiveUrl;
    private String assigneesUrl;
    private String blobsUrl;
    private String branchesUrl;
    private String cloneUrl;
    private String collaboratorsUrl;
    private String commentsUrl;
    private String commitsUrl;
    private String compareUrl;
    private String contentsUrl;
    private String contributorsUrl;
    private String deploymentsUrl;
    private String downloadsUrl;
    private String eventsUrl;
    private String forksUrl;
    private String gitCommitsUrl;
    private String gitRefsUrl;
    private String gitTagsUrl;
    private String gitUrl;
    private String hooksUrl;
    private String issueCommentUrl;
    private String issueEventsUrl;
    private String issuesUrl;
    private String keysUrl;
    private String labelsUrl;
    private String languagesUrl;
    private String mergesUrl;
    private String milestonesUrl;
    private String mirrorUrl;
    private String notificationsUrl;
    private String pullsUrl;
    private String releasesUrl;
    private String sshUrl;
    private String stargazersUrl;
    private String statusesUrl;
    private String subscribersUrl;
    private String subscriptionUrl;
    private String svnUrl;
    private String tagsUrl;
    private String teamsUrl;
    private String treesUrl;
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
    public String getHtmlUrl() { return htmlUrl; }
    public void setHtmlUrl(String htmlUrl) { this.htmlUrl = htmlUrl; }
    public String getArchiveUrl() { return archiveUrl; }
    public void setArchiveUrl(String archiveUrl) { this.archiveUrl = archiveUrl; }
    public String getAssigneesUrl() { return assigneesUrl; }
    public void setAssigneesUrl(String assigneesUrl) { this.assigneesUrl = assigneesUrl; }
    public String getBlobsUrl() { return blobsUrl; }
    public void setBlobsUrl(String blobsUrl) { this.blobsUrl = blobsUrl; }
    public String getBranchesUrl() { return branchesUrl; }
    public void setBranchesUrl(String branchesUrl) { this.branchesUrl = branchesUrl; }
    public String getCloneUrl() { return cloneUrl; }
    public void setCloneUrl(String cloneUrl) { this.cloneUrl = cloneUrl; }
    public String getCollaboratorsUrl() { return collaboratorsUrl; }
    public void setCollaboratorsUrl(String collaboratorsUrl) { this.collaboratorsUrl = collaboratorsUrl; }
    public String getCommentsUrl() { return commentsUrl; }
    public void setCommentsUrl(String commentsUrl) { this.commentsUrl = commentsUrl; }
    public String getCommitsUrl() { return commitsUrl; }
    public void setCommitsUrl(String commitsUrl) { this.commitsUrl = commitsUrl; }
    public String getCompareUrl() { return compareUrl; }
    public void setCompareUrl(String compareUrl) { this.compareUrl = compareUrl; }
    public String getContentsUrl() { return contentsUrl; }
    public void setContentsUrl(String contentsUrl) { this.contentsUrl = contentsUrl; }
    public String getContributorsUrl() { return contributorsUrl; }
    public void setContributorsUrl(String contributorsUrl) { this.contributorsUrl = contributorsUrl; }
    public String getDeploymentsUrl() { return deploymentsUrl; }
    public void setDeploymentsUrl(String deploymentsUrl) { this.deploymentsUrl = deploymentsUrl; }
    public String getDownloadsUrl() { return downloadsUrl; }
    public void setDownloadsUrl(String downloadsUrl) { this.downloadsUrl = downloadsUrl; }
    public String getEventsUrl() { return eventsUrl; }
    public void setEventsUrl(String eventsUrl) { this.eventsUrl = eventsUrl; }
    public String getForksUrl() { return forksUrl; }
    public void setForksUrl(String forksUrl) { this.forksUrl = forksUrl; }
    public String getGitCommitsUrl() { return gitCommitsUrl; }
    public void setGitCommitsUrl(String gitCommitsUrl) { this.gitCommitsUrl = gitCommitsUrl; }
    public String getGitRefsUrl() { return gitRefsUrl; }
    public void setGitRefsUrl(String gitRefsUrl) { this.gitRefsUrl = gitRefsUrl; }
    public String getGitTagsUrl() { return gitTagsUrl; }
    public void setGitTagsUrl(String gitTagsUrl) { this.gitTagsUrl = gitTagsUrl; }
    public String getGitUrl() { return gitUrl; }
    public void setGitUrl(String gitUrl) { this.gitUrl = gitUrl; }
    public String getHooksUrl() { return hooksUrl; }
    public void setHooksUrl(String hooksUrl) { this.hooksUrl = hooksUrl; }
    public String getIssueCommentUrl() { return issueCommentUrl; }
    public void setIssueCommentUrl(String issueCommentUrl) { this.issueCommentUrl = issueCommentUrl; }
    public String getIssueEventsUrl() { return issueEventsUrl; }
    public void setIssueEventsUrl(String issueEventsUrl) { this.issueEventsUrl = issueEventsUrl; }
    public String getIssuesUrl() { return issuesUrl; }
    public void setIssuesUrl(String issuesUrl) { this.issuesUrl = issuesUrl; }
    public String getKeysUrl() { return keysUrl; }
    public void setKeysUrl(String keysUrl) { this.keysUrl = keysUrl; }
    public String getLabelsUrl() { return labelsUrl; }
    public void setLabelsUrl(String labelsUrl) { this.labelsUrl = labelsUrl; }
    public String getLanguagesUrl() { return languagesUrl; }
    public void setLanguagesUrl(String languagesUrl) { this.languagesUrl = languagesUrl; }
    public String getMergesUrl() { return mergesUrl; }
    public void setMergesUrl(String mergesUrl) { this.mergesUrl = mergesUrl; }
    public String getMilestonesUrl() { return milestonesUrl; }
    public void setMilestonesUrl(String milestonesUrl) { this.milestonesUrl = milestonesUrl; }
    public String getMirrorUrl() { return mirrorUrl; }
    public void setMirrorUrl(String mirrorUrl) { this.mirrorUrl = mirrorUrl; }
    public String getNotificationsUrl() { return notificationsUrl; }
    public void setNotificationsUrl(String notificationsUrl) { this.notificationsUrl = notificationsUrl; }
    public String getPullsUrl() { return pullsUrl; }
    public void setPullsUrl(String pullsUrl) { this.pullsUrl = pullsUrl; }
    public String getReleasesUrl() { return releasesUrl; }
    public void setReleasesUrl(String releasesUrl) { this.releasesUrl = releasesUrl; }
    public String getSshUrl() { return sshUrl; }
    public void setSshUrl(String sshUrl) { this.sshUrl = sshUrl; }
    public String getStargazersUrl() { return stargazersUrl; }
    public void setStargazersUrl(String stargazersUrl) { this.stargazersUrl = stargazersUrl; }
    public String getStatusesUrl() { return statusesUrl; }
    public void setStatusesUrl(String statusesUrl) { this.statusesUrl = statusesUrl; }
    public String getSubscribersUrl() { return subscribersUrl; }
    public void setSubscribersUrl(String subscribersUrl) { this.subscribersUrl = subscribersUrl; }
    public String getSubscriptionUrl() { return subscriptionUrl; }
    public void setSubscriptionUrl(String subscriptionUrl) { this.subscriptionUrl = subscriptionUrl; }
    public String getSvnUrl() { return svnUrl; }
    public void setSvnUrl(String svnUrl) { this.svnUrl = svnUrl; }
    public String getTagsUrl() { return tagsUrl; }
    public void setTagsUrl(String tagsUrl) { this.tagsUrl = tagsUrl; }
    public String getTeamsUrl() { return teamsUrl; }
    public void setTeamsUrl(String teamsUrl) { this.teamsUrl = teamsUrl; }
    public String getTreesUrl() { return treesUrl; }
    public void setTreesUrl(String treesUrl) { this.treesUrl = treesUrl; }
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
