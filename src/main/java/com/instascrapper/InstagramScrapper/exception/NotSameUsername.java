package com.instascrapper.InstagramScrapper.exception;

public class NotSameUsername extends RuntimeException {
    public NotSameUsername() {
        super("The username you signed in is not the same you provided.");
    }

}