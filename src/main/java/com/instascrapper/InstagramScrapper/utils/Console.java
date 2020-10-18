package com.instascrapper.InstagramScrapper.utils;

import com.instascrapper.InstagramScrapper.model.Pair;

public class Console {

    private static final java.io.Console console = System.console();

    /**
     * So you can't instantiate
     */
    public Console() {
    }

    private static String getUsername() {

        if (console == null) {
            System.out.println("Couldn't open console. Exiting.");
            System.exit(0);
        }

        char[] usernameArray = console.readPassword("Enter your username: ");

        return String.valueOf(usernameArray);
    }

    private static String getPassword() {

        if (console == null) {
            System.out.println("Couldn't open console. Exiting.");
            System.exit(0);
        }

        char[] passwordArray = console.readPassword("Enter your secret password: ");

        return String.valueOf(passwordArray);
    }

    public static Pair<String, String> getCredentials() {
        return new Pair<>(getUsername(), getPassword());
    }

}
