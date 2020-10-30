package com.instascrapper.InstagramScrapper.service.seleniumbrowserservice;

import com.instascrapper.InstagramScrapper.utils.SeleniumBrowser;
import com.instascrapper.InstagramScrapper.model.ProfileInfo;
import com.instascrapper.InstagramScrapper.utils.InstagramXPaths;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is supposed to use browser to get profile info
 */
public class SeleniumProfileService {

    private static String profileUrl;
    private static String scrollScript;

    public static ProfileInfo getProfileInfo(String username) throws InterruptedException {

        updateVariablesAndUrl(username);

        SeleniumBrowser driver = new SeleniumBrowser();
        driver.getDriver().get(profileUrl);
        waitInSeconds(3);

        WebElement followersWebElement = driver.getDriver().findElement(InstagramXPaths.getFollowersXPath());
        String followers = followersWebElement.getText().replaceAll("\\D+", "");

        WebElement followingWebElement = driver.getDriver().findElement(InstagramXPaths.getFollowingXPath());
        String following = followingWebElement.getText().replaceAll("\\D+", "");

        driver.getDriver().findElement(InstagramXPaths.getFollowingListBoxOpenXPath()).click();
        waitInSeconds(3);

        WebElement followingListBox = driver.getDriver().findElement(InstagramXPaths.getFollowingListBoxXPath());

        List<String> unverifiedFollowingUsernameList = getUnverifiedFollowingUsernameList(driver, followingListBox);

        return new ProfileInfo(Integer.parseInt(followers), Integer.parseInt(following), unverifiedFollowingUsernameList);
    }

    private static List<String> getUnverifiedFollowingUsernameList(SeleniumBrowser driver, WebElement followingListBox) {

        List<String> unverifiedFollowingUsernameList = new ArrayList<>();
        Boolean stopFlag = false;
        int i = 1;

        while (!stopFlag) {
            try {

                WebElement followingUserData = driver.getDriver().findElement(InstagramXPaths.getIndexedUserDataFromFollowingListXPath(i));
                checkIfUnverifiedAndAdd(unverifiedFollowingUsernameList, followingUserData);
                scrollPageElement(driver, followingListBox);
                i++;

            } catch (Exception e) {
                stopFlag = true;
            }
        }

        return unverifiedFollowingUsernameList;
    }

    private static void checkIfUnverifiedAndAdd(List<String> unverifiedFollowingUsernameList, WebElement followingData) {
        if (!followingData.getText().contains("Verificado")) {
            unverifiedFollowingUsernameList.add("@" + followingData.getText().substring(0, followingData.getText().indexOf("\n")));
        }
    }

    private static void scrollPageElement(SeleniumBrowser driver, WebElement followingListBox) throws InterruptedException {
        Boolean stop = (boolean) ((JavascriptExecutor) driver.getDriver()).executeScript(scrollScript, followingListBox);
        if (!stop) {
            waitInMilliseconds(200);
        }
    }

    private static void waitInSeconds(Integer milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds * 1000);
    }

    private static void waitInMilliseconds(Integer milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

    private static void updateVariablesAndUrl(String username) {
        profileUrl = "https://www.instagram.com/" + username;
        scrollScript =
                "if(arguments[0].scrollTop != (arguments[0].scrollHeight - arguments[0].offsetHeight)) { " +
                        "arguments[0].scrollTop = arguments[0].scrollTop + arguments[0].offsetHeight;" +
                        "return false;" +
                        "}else{" +
                        "return true;" +
                        "}";
    }

}