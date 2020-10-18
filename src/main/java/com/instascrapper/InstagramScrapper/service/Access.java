package com.instascrapper.InstagramScrapper.service;

import com.instascrapper.InstagramScrapper.utils.Console;
import com.instascrapper.InstagramScrapper.utils.InstagramXPaths;
import com.instascrapper.InstagramScrapper.utils.Pair;
import com.instascrapper.InstagramScrapper.utils.SeleniumBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Access {

    private static String username;
    private static String password;
    private static String profileUrl;
    private static String loginUrl;

    public static void login() throws InterruptedException {

        WebDriver driver = SeleniumBrowser.configureAndReturnChromeBrowserWebDriver();

        SeleniumBrowser.minimize(driver);
        getAndUpdateVariablesValuesAndUrls();
        SeleniumBrowser.maximize(driver);

        driver.get(profileUrl);
        waitSeconds(2);
        driver.get(loginUrl);

        waitSeconds(2);
        WebElement usernameField = driver.findElement(InstagramXPaths.getUsernameFieldXPath());
        usernameField.sendKeys(username);

        waitSeconds(2);
        WebElement passwordField = driver.findElement(InstagramXPaths.getPasswordFieldXPath());
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(InstagramXPaths.getLoginButtonXPath());
        loginButton.click();

        waitSeconds(5);
        driver.close();

    }

    private static void waitSeconds(Integer seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    private static void getAndUpdateVariablesValuesAndUrls() {
        Pair<String, String> credentials = Console.getCredentials();
        username = credentials.getFirst();
        password = credentials.getSecond();
        profileUrl = "https://www.instagram.com/" + username;
        loginUrl = "https://www.instagram.com/accounts/login/?next=%2F" + username + "%2F&source=desktop_nav";
    }

}
