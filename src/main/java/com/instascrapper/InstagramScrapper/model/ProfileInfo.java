package com.instascrapper.InstagramScrapper.model;

import java.util.List;

public class ProfileInfo {
    private String username;
    private Integer followers;
    private Integer following;
    private List<String> unverifiedFollowingUsernameList;

    public ProfileInfo(String username, Integer followers, Integer following, List<String> unverifiedFollowingUsernameList) {
        this.username = username;
        this.followers = followers;
        this.following = following;
        this.unverifiedFollowingUsernameList = unverifiedFollowingUsernameList;
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

    public List<String> getUnverifiedFollowingUsernameList() {
        return unverifiedFollowingUsernameList;
    }

    public void setUnverifiedFollowingUsernameList(List<String> unverifiedFollowingUsernameList) {
        this.unverifiedFollowingUsernameList = unverifiedFollowingUsernameList;
    }
}
