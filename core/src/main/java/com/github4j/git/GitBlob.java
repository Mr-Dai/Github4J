package com.github4j.git;

/**
 * A Git blob.
 * <p>
 * URL format:
 * <pre>
 *     https://api.github.com/repos/:owner/:repo/git/blobs/:sha
 * </pre>
 */
public class GitBlob {
    private String sha;
    private String content;
    private String encoding;
    private int size;

    /* Getters and Setters */
    public String getSha() { return sha; }
    public void setSha(String sha) { this.sha = sha; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getEncoding() { return encoding; }
    public void setEncoding(String encoding) { this.encoding = encoding; }
    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }
}
