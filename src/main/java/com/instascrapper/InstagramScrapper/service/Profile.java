package com.instascrapper.InstagramScrapper.service;

import com.instascrapper.InstagramScrapper.common.SeleniumBrowser;
import com.instascrapper.InstagramScrapper.model.ProfileInfo;
import com.instascrapper.InstagramScrapper.utils.InstagramXPaths;
import org.openqa.selenium.WebElement;

/**
 * This class is supposed to access profile page and populate ProfileInfo model
 */
public class Profile extends SeleniumBrowser {

    private static String profileUrl;

    public static void getProfileInfo() throws InterruptedException {

        SeleniumBrowser driver = new SeleniumBrowser();

        waitSeconds(2);
        WebElement usernameWebElement = driver.getDriver().findElement(InstagramXPaths.getUsernameXPath());
        String username = usernameWebElement.getText();

        waitSeconds(2);
        WebElement followersWebElement = driver.getDriver().findElement(InstagramXPaths.getFollowersXPath());
        String followers = followersWebElement.getText().replaceAll("\\D+", "");

        waitSeconds(2);
        WebElement followingWebElement = driver.getDriver().findElement(InstagramXPaths.getFollowingXPath());
        String following = followingWebElement.getText().replaceAll("\\D+", "");

        ProfileInfo profileInfo = new ProfileInfo(username, Integer.parseInt(followers), Integer.parseInt(following));

        System.out.println("username = " + profileInfo.getUsername());
        System.out.println("followers = " + profileInfo.getFollowers());
        System.out.println("following = " + profileInfo.getFollowing());

    }

    private static void waitSeconds(Integer seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

}