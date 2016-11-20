package com.github4j;

public class User {
    private int id;
    private String login;
    private String avatarUrl;
    private String gravatarId;
    private boolean siteAdmin;

    /* Getters and Setters */
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getAvatarUrl() { return avatarUrl; }
    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }
    public String getGravatarId() { return gravatarId; }
    public void setGravatarId(String gravatarId) { this.gravatarId = gravatarId; }
    public boolean isSiteAdmin() { return siteAdmin; }
    public void setSiteAdmin(boolean siteAdmin) { this.siteAdmin = siteAdmin; }
}
