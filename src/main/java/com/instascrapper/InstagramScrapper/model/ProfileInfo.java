package com.instascrapper.InstagramScrapper.model;

public class ProfileInfo {
    private String username;
    private Integer followers;
    private Integer following;

    public ProfileInfo(String username, Integer followers, Integer following) {
        this.username = username;
        this.followers = followers;
        this.following = following;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getFollowing() {
        return following;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }

}
