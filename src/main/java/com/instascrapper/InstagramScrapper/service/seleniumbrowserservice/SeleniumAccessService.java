package com.instascrapper.InstagramScrapper.service.seleniumbrowserservice;

import com.instascrapper.InstagramScrapper.utils.SeleniumBrowser;
import com.instascrapper.InstagramScrapper.model.register.RegisterDTO;
import com.instascrapper.InstagramScrapper.utils.InstagramXPaths;
import org.openqa.selenium.WebElement;

/**
 * This class is supposed to use browser to get credentials
 */
public class SeleniumAccessService {

    private static String profileUrl;
    private static String loginUrl;

    public static void login(RegisterDTO registerDTO) throws InterruptedException {

        SeleniumBrowser driver = new SeleniumBrowser();
//        driver.maximizeBrowser();

        updateVariablesAndUrl(registerDTO.getUsername());

        driver.getDriver().get(profileUrl);
        waitInSeconds(3);
        driver.getDriver().get(loginUrl);
        waitInSeconds(3);

        WebElement usernameField = driver.getDriver().findElement(InstagramXPaths.getUsernameFieldXPath());
        usernameField.sendKeys(registerDTO.getUsername());
        WebElement passwordField = driver.getDriver().findElement(InstagramXPaths.getPasswordFieldXPath());
        passwordField.sendKeys(registerDTO.getPassword());

        WebElement loginButton = driver.getDriver().findElement(InstagramXPaths.getLoginButtonXPath());
        loginButton.click();
        waitInSeconds(3);

        driver.getDriver().get(profileUrl);
        waitInSeconds(3);

    }

    private static void waitInSeconds(Integer milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds * 1000);
    }

    private static void updateVariablesAndUrl(String username) {
        profileUrl = "https://www.instagram.com/" + username;
        loginUrl = "https://www.instagram.com/accounts/login/?next=%2F" + username + "%2F&source=desktop_nav";
    }

}