package com.instascrapper.InstagramScrapper.service;

import com.instascrapper.InstagramScrapper.common.SeleniumBrowser;
import com.instascrapper.InstagramScrapper.model.Pair;
import com.instascrapper.InstagramScrapper.utils.Console;
import com.instascrapper.InstagramScrapper.utils.InstagramXPaths;
import org.openqa.selenium.WebElement;

/**
 * This class is supposed to get credentials and log in
 */
public class Access extends SeleniumBrowser {

    private static String username;
    private static String password;
    private static String profileUrl;
    private static String loginUrl;

    public static void login() throws InterruptedException {

        SeleniumBrowser driver = new SeleniumBrowser();

        driver.minimizeBrowser();
        getAndUpdateVariablesValuesAndUrls();
        driver.maximizeBrowser();

        driver.getDriver().get(profileUrl);
        waitSeconds(2);
        driver.getDriver().get(loginUrl);

        waitSeconds(2);
        WebElement usernameField = driver.getDriver().findElement(InstagramXPaths.getUsernameFieldXPath());
        usernameField.sendKeys(username);

        waitSeconds(2);
        WebElement passwordField = driver.getDriver().findElement(InstagramXPaths.getPasswordFieldXPath());
        passwordField.sendKeys(password);

        WebElement loginButton = driver.getDriver().findElement(InstagramXPaths.getLoginButtonXPath());
        loginButton.click();

        waitSeconds(5);

        driver.getDriver().get(profileUrl);
        waitSeconds(2);

        Profile.getProfileInfo();

    }

    private static void waitSeconds(Integer seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    private static void getAndUpdateVariablesValuesAndUrls() {
//      Pair<String, String> credentials = new Pair<>("", "");
        Pair<String, String> credentials = Console.getCredentials();
        username = credentials.getFirst();
        password = credentials.getSecond();
        profileUrl = "https://www.instagram.com/" + username;
        loginUrl = "https://www.instagram.com/accounts/login/?next=%2F" + username + "%2F&source=desktop_nav";
    }

}