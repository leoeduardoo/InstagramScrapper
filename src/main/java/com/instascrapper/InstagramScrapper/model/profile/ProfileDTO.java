package com.instascrapper.InstagramScrapper.model.profile;

import java.util.List;

public class ProfileDTO {
    private Long id;
    private Long idRegister;
    private Integer followers;
    private Integer following;
    private List<String> unverifiedFollowingUsernameList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdRegister() {
        return idRegister;
    }

    public void setIdRegister(Long idRegister) {
        this.idRegister = idRegister;
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