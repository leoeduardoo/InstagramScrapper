package com.instascrapper.InstagramScrapper.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Profile")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "idRegister")
    Long idRegister;

    @Column(name = "followers")
    Integer followers;

    @Column(name = "following")
    Integer following;

    @ElementCollection
    @Column(name = "unverifiedFollowingUsernameList")
    List<String> unverifiedFollowingUsernameList;

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