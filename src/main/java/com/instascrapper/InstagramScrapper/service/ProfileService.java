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
public class ProfileService extends SeleniumBrowser {

    static String scrollScript =
            "if(arguments[0].scrollTop != (arguments[0].scrollHeight - arguments[0].offsetHeight)) { " +
                    "arguments[0].scrollTop = arguments[0].scrollTop + arguments[0].offsetHeight;" +
                    "return false;" +
                    "}else{" +
                    "return true;" +
                    "}";

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

        driver.getDriver().findElement(InstagramXPaths.getFollowingListBoxOpenXPath()).click();

        waitSeconds(1);

        WebElement followingListBox = driver.getDriver().findElement(InstagramXPaths.getFollowingListBoxXPath());

        waitSeconds(1);

        List<String> unverifiedFollowingUsernameList = getUnverifiedFollowingUsernameList(driver, followingListBox);

        //TODO store in a database
        ProfileInfo profileInfo = new ProfileInfo(username, Integer.parseInt(followers), Integer.parseInt(following), unverifiedFollowingUsernameList);

        waitSeconds(2);

    }

    private static List<String> getUnverifiedFollowingUsernameList(SeleniumBrowser driver, WebElement followingListBox) {

        List<String> unverifiedFollowingUsernameList = new ArrayList<>();
        Boolean stopFlag = false;
        int i = 1;

        while (!stopFlag) {
            try {

                WebElement followingUserData = driver.getDriver().findElement(InstagramXPaths.getIndexedUserDataFromFollowingListXPath(i));
                checkUnverifiedAndAdd(unverifiedFollowingUsernameList, followingUserData);
                scrollPageElement(driver, followingListBox);
                i++;

            } catch (Exception e) {
                e.printStackTrace();
                stopFlag = true;
            }
        }

        return unverifiedFollowingUsernameList;
    }

    private static void checkUnverifiedAndAdd(List<String> unverifiedFollowingUsernameList, WebElement followingData) {
        if (!followingData.getText().contains("Verificado")) {
            unverifiedFollowingUsernameList.add(followingData.getText().substring(0, followingData.getText().indexOf("\n")));
        }
    }

    private static void scrollPageElement(SeleniumBrowser driver, WebElement followingListBox) throws InterruptedException {
        //TODO check if scroll is at bottom so don't scroll anymore
        Boolean stop = (boolean) ((JavascriptExecutor) driver.getDriver()).executeScript(scrollScript, followingListBox);
        if(!stop){
            waitMilliseconds(200);
        }
    }

    private static void waitSeconds(Integer seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    private static void waitMilliseconds(Integer milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

}