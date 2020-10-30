package com.instascrapper.InstagramScrapper.exception;

public class DuplicatedRegisterException extends RuntimeException {
    public DuplicatedRegisterException(String username) {
        super("There is already a register matching the username {" + username + "}.");
    }

}