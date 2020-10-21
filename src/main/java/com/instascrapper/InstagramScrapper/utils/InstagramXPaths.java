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
    private static By followingListBoxOpenXPath;
    private static By followingListBoxXPath;
    private static String userDataFromFollowingListXPathString;

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

    public static By getFollowingListBoxOpenXPath() {
        return followingListBoxOpenXPath;
    }

    public static By getFollowingListBoxXPath() {
        return followingListBoxXPath;
    }

    public static By getIndexedUserDataFromFollowingListXPath(int i) {
        String xPathUpdatedWithIndex = userDataFromFollowingListXPathString.replace("$", String.valueOf(i));
        return By.xpath(xPathUpdatedWithIndex);
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

    @Value("${instagram.xpath.followingListBoxOpen}")
    public void setFollowingListBoxOpenXPath(String followingListBoxOpenXPath) {
        InstagramXPaths.followingListBoxOpenXPath = By.xpath(followingListBoxOpenXPath);
    }

    @Value("${instagram.xpath.followingListBox}")
    public void setFollowingListBoxXPath(String followingListBoxXPath) {
        InstagramXPaths.followingListBoxXPath = By.xpath(followingListBoxXPath);
    }

    @Value("${instagram.xpath.userDataFromFollowingListXPath}")
    public void setUserDataFromFollowingListXPathString(String userDataFromFollowingListXPath) {
        InstagramXPaths.userDataFromFollowingListXPathString = userDataFromFollowingListXPath;
    }

}