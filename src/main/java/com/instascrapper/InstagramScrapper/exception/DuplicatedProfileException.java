package com.instascrapper.InstagramScrapper.exception;

public class DuplicatedProfileException extends RuntimeException {
    public DuplicatedProfileException() {
        super("This profile is already registered.");
    }

}