package com.instascrapper.InstagramScrapper.service;

import com.instascrapper.InstagramScrapper.common.SeleniumBrowser;
import com.instascrapper.InstagramScrapper.model.ProfileInfo;
import com.instascrapper.InstagramScrapper.utils.InstagramXPaths;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is supposed to access profile page and populate ProfileInfo model
 */
public class Profile extends SeleniumBrowser {

    public static void getProfileInfo() throws InterruptedException {

        SeleniumBrowser driver = new SeleniumBrowser();

        waitSeconds(1);
        WebElement usernameWebElement = driver.getDriver().findElement(InstagramXPaths.getUsernameXPath());
        String username = usernameWebElement.getText();

        waitSeconds(1);
        WebElement followersWebElement = driver.getDriver().findElement(InstagramXPaths.getFollowersXPath());
        String followers = followersWebElement.getText().replaceAll("\\D+", "");

        waitSeconds(1);
        WebElement followingWebElement = driver.getDriver().findElement(InstagramXPaths.getFollowingXPath());
        String following = followingWebElement.getText().replaceAll("\\D+", "");

        ProfileInfo profileInfo = new ProfileInfo(username, Integer.parseInt(followers), Integer.parseInt(following));

        //TODO store in a database
        System.out.println("username = " + profileInfo.getUsername());
        System.out.println("followers = " + profileInfo.getFollowers());
        System.out.println("following = " + profileInfo.getFollowing());

        driver
                .getDriver()
                .findElement(By.xpath("//*[@id=\"react-root\"]/section/main/div/header/section/ul/li[3]/a"))
                .click();

        waitSeconds(1);

        WebElement followingListBox = driver.getDriver().findElement(By.xpath("//div[@class='isgrP']"));

        List<WebElement> nonVerifiedFollowingList = new ArrayList<>();

        getNonVerifiedFollowingList(driver, followingListBox, nonVerifiedFollowingList);

        waitSeconds(2);

    }

    private static void getNonVerifiedFollowingList(SeleniumBrowser driver, WebElement followingListBox, List<WebElement> nonVerifiedFollowingList) {
        Boolean stopFlag = false;
        int i = 1;
        while (!stopFlag) {
            try {

                WebElement followingData = driver.getDriver().findElement(By.xpath("//div[@class='isgrP']//li[" + i + "]"));

                if (!followingData.getText().contains("Verificado")) {
                    nonVerifiedFollowingList.add(followingData);
                }

                scroll(driver, followingListBox);
                i++;
            } catch (Exception e) {
                stopFlag = true;
            }
        }
    }

    private static void scroll(SeleniumBrowser driver, WebElement followingListBox) throws InterruptedException {
        ((JavascriptExecutor) driver.getDriver()).executeScript("arguments[0].scrollTop = arguments[0].scrollTop + arguments[0].offsetHeight;", followingListBox);
        waitMilliseconds(200);
    }

    private static void waitSeconds(Integer seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    private static void waitMilliseconds(Integer milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

}