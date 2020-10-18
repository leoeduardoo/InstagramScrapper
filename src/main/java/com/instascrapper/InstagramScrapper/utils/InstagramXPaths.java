package com.instascrapper.InstagramScrapper.utils;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InstagramXPaths {

    /**
     * So you can't instantiate
     */
    private InstagramXPaths() {
    }

    private static By usernameFieldXPath;
    private static By passwordFieldXPath;
    private static By loginButtonXPath;

    public static By getUsernameFieldXPath() {
        return usernameFieldXPath;
    }

    public static By getPasswordFieldXPath() {
        return passwordFieldXPath;
    }

    public static By getLoginButtonXPath() {
        return loginButtonXPath;
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

}
