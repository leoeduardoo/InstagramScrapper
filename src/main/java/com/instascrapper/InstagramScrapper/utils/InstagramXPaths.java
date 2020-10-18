package com.instascrapper.InstagramScrapper.utils;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InstagramXPaths {

    private static By usernameFieldXPath;
    private static By passwordFieldXPath;
    private static By loginButtonXPath;
    private static By usernameXPath;
    private static By followingXPath;
    private static By followersXPath;

    /**
     * So you can't instantiate
     */
    private InstagramXPaths() {
    }

    public static By getUsernameFieldXPath() {
        return usernameFieldXPath;
    }

    public static By getPasswordFieldXPath() {
        return passwordFieldXPath;
    }

    public static By getLoginButtonXPath() {
        return loginButtonXPath;
    }

    public static By getUsernameXPath() {
        return usernameXPath;
    }

    public static By getFollowingXPath() {
        return followingXPath;
    }

    public static By getFollowersXPath() {
        return followersXPath;
    }

    @Value("${instagram.xpath.usernameField}")
    public void setUsernameFieldXPath(String usernameFieldXPath) {
        InstagramXPaths.usernameFieldXPath = By.xpath(usernameFieldXPath);
    }

    @Value("${instagram.xpath.passwordField}")
    public void setPasswordFieldXPath(String passwordFieldXPath) {
        InstagramXPaths.passwordFieldXPath = By.xpath(passwordFieldXPath);
    }

    @Value("${instagram.xpath.loginButton}")
    public void setLoginButtonXPath(String loginButtonXPath) {
        InstagramXPaths.loginButtonXPath = By.xpath(loginButtonXPath);
    }

    @Value("${instagram.xpath.username}")
    public void setUsernameXPath(String usernameXPath) {
        InstagramXPaths.usernameXPath = By.xpath(usernameXPath);
    }

    @Value("${instagram.xpath.following}")
    public void setFollowingXPath(String followingXPath) {
        InstagramXPaths.followingXPath = By.xpath(followingXPath);
    }

    @Value("${instagram.xpath.followers}")
    public void setFollowersXPath(String followersXPath) {
        InstagramXPaths.followersXPath = By.xpath(followersXPath);
    }

}