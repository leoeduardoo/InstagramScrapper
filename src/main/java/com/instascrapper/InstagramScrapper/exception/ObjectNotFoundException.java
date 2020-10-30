package com.instascrapper.InstagramScrapper.exception;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String username) {
        super(username + " not found.");
    }

}