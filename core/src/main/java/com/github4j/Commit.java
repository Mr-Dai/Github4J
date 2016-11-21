package com.github4j;

import com.github4j.git.GitCommit;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * A Github commit, which is not the same as a {@link com.github4j.git.GitCommit GitCommit}.
 * <p>
 * URL format:
 * <pre>
 *     https://api.github.com/repos/:owner/:repo/commits/:sha
 * </pre>
 */
public class Commit {
    private String sha;
    @SerializedName("commit") private GitCommit gitCommit;
    private User author;
    private User committer;
    private List<Parent> parents;
    private Stats stats;
    private List<File> files;

    public String getSha() { return sha; }
    public void setSha(String sha) { this.sha = sha; }
    public GitCommit getGitCommit() { return gitCommit; }
    public void setGitCommit(GitCommit gitCommit) { this.gitCommit = gitCommit; }
    public User getAuthor() { return author; }
    public void setAuthor(User author) { this.author = author; }
    public User getCommitter() { return committer; }
    public void setCommitter(User committer) { this.committer = committer; }
    public List<Parent> getParents() { return parents; }
    public void setParents(List<Parent> parents) { this.parents = parents; }
    public Stats getStats() { return stats; }
    public void setStats(Stats stats) { this.stats = stats; }
    public List<File> getFiles() { return files; }
    public void setFiles(List<File> files) { this.files = files; }

    public static class Parent {
        private String sha;
    }

    public static class Stats {
        private int additions;
        private int deletions;
        private int total;

        public int getAdditions() { return additions; }
        public void setAdditions(int additions) { this.additions = additions; }
        public int getDeletions() { return deletions; }
        public void setDeletions(int deletions) { this.deletions = deletions; }
        public int getTotal() { return total; }
        public void setTotal(int total) { this.total = total; }
    }

    public static class File {
        private String filename;
        private int additions;
        private int deletions;
        private int changes;
        private String status;
        private String patch;

        public String getFilename() { return filename; }
        public void setFilename(String filename) { this.filename = filename; }
        public int getAdditions() { return additions; }
        public void setAdditions(int additions) { this.additions = additions; }
        public int getDeletions() { return deletions; }
        public void setDeletions(int deletions) { this.deletions = deletions; }
        public int getChanges() { return changes; }
        public void setChanges(int changes) { this.changes = changes; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
        public String getPatch() { return patch; }
        public void setPatch(String patch) { this.patch = patch; }
    }
}
