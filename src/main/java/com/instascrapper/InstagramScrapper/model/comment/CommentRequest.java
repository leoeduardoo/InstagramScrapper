package com.instascrapper.InstagramScrapper.model.comment;

public class CommentRequest {
    private String username;
    private String postUrl;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

}