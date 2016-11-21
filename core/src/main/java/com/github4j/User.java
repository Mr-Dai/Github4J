package com.github4j;

import org.joda.time.LocalDateTime;

public class User {
    private int id;
    private String login;
    private String avatarUrl;
    private String gravatarId;
    private Type type;
    private boolean siteAdmin;
    private String name;
    private String company;
    private String blog;
    private String location;
    private String email;
    private String hireable;
    private String bio;
    private int publicRepos;
    private int publicGists;
    private int followers;
    private int following;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /* Getters and Setters */
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getAvatarUrl() { return avatarUrl; }
    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }
    public String getGravatarId() { return gravatarId; }
    public void setGravatarId(String gravatarId) { this.gravatarId = gravatarId; }
    public Type getType() { return type; }
    public void setType(Type type) { this.type = type; }
    public boolean isSiteAdmin() { return siteAdmin; }
    public void setSiteAdmin(boolean siteAdmin) { this.siteAdmin = siteAdmin; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    public String getBlog() { return blog; }
    public void setBlog(String blog) { this.blog = blog; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getHireable() { return hireable; }
    public void setHireable(String hireable) { this.hireable = hireable; }
    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }
    public int getPublicRepos() { return publicRepos; }
    public void setPublicRepos(int publicRepos) { this.publicRepos = publicRepos; }
    public int getPublicGists() { return publicGists; }
    public void setPublicGists(int publicGists) { this.publicGists = publicGists; }
    public int getFollowers() { return followers; }
    public void setFollowers(int followers) { this.followers = followers; }
    public int getFollowing() { return following; }
    public void setFollowing(int following) { this.following = following; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public enum Type {
        User, Organization
    }
}
