package com.github4j;

import com.github4j.git.GitCommit;
import com.google.gson.annotations.SerializedName;

public class Branch {
    private String name;
    private Commit commit;
    @SerializedName("protected") private boolean _protected;

    /* Getters and Setters */
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Commit getCommit() { return commit; }
    public void setCommit(Commit commit) { this.commit = commit; }
    public boolean isProtected() { return _protected; }
    public void setProtected(boolean _protected) { this._protected = _protected; }
}
