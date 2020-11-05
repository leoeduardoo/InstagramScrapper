package com.instascrapper.InstagramScrapper.service.seleniumbrowserservice;

import com.instascrapper.InstagramScrapper.exception.NotSameUsername;
import com.instascrapper.InstagramScrapper.utils.InstagramXPaths;
import com.instascrapper.InstagramScrapper.utils.SeleniumBrowser;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * This class is supposed to use browser to sign in
 */
public class SeleniumAccessService {

    private static String profileUrl;
    private static String loginUrl;

    public static void login(String username) throws InterruptedException {

        SeleniumBrowser driver = new SeleniumBrowser();

        updateVariablesAndUrl(username);

        driver.getDriver().get(profileUrl);
        waitInSeconds(3);

        checkIfAlreadyLogged(driver);

        WebElement usernameField = driver.getDriver().findElement(InstagramXPaths.getUsernameFieldXPath());
        usernameField.sendKeys(username);

        checkLoginButtonClicked(driver);
        waitInSeconds(3);

        checkIfLoggedUserIsTheProvided(username, driver);

        driver.getDriver().get(profileUrl);
        waitInSeconds(3);

    }

    private static void checkIfLoggedUserIsTheProvided(String username, SeleniumBrowser driver) {

        driver.getDriver().findElement(InstagramXPaths.getProfileIconXPath()).click();
        driver.getDriver().findElement(InstagramXPaths.getProfileIconProfileButtonXPath()).click();

        if (!driver.getDriver().getCurrentUrl().contains(username)) {
            throw new NotSameUsername();
        }
    }

    private static void checkIfAlreadyLogged(SeleniumBrowser driver) throws InterruptedException {

        try {
            driver.getDriver().findElement(InstagramXPaths.getProfileIconXPath()).click();
            driver.getDriver().findElement(InstagramXPaths.getProfileIconExitButtonXPath()).click();
            waitInSeconds(3);
        } catch (NoSuchElementException e) {
            driver.getDriver().get(loginUrl);
            waitInSeconds(3);
        }
    }

    private static void checkLoginButtonClicked(SeleniumBrowser driver) {

        boolean loggedIn = false;

        while (!loggedIn) {
            try {
                driver.getDriver().findElement(InstagramXPaths.getLoginButtonXPath());
            } catch (NoSuchElementException ex) {
                loggedIn = true;
            }
        }
    }

    private static void waitInSeconds(Integer milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds * 1000);
    }

    private static void updateVariablesAndUrl(String username) {
        profileUrl = "https://www.instagram.com/" + username;
        loginUrl = "https://www.instagram.com/accounts/login/?next=%2F" + username + "%2F&source=desktop_nav";
    }

}