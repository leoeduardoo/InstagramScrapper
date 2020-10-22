package com.instascrapper.InstagramScrapper.service;

import com.instascrapper.InstagramScrapper.common.SeleniumBrowser;
import com.instascrapper.InstagramScrapper.model.ProfileInfo;
import com.instascrapper.InstagramScrapper.utils.Console;
import com.instascrapper.InstagramScrapper.utils.InstagramXPaths;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * This class is supposed to comment following username by following username on a post
 */
public class CommentService extends SeleniumBrowser {

    public static void comment(ProfileInfo profileInfo) throws InterruptedException {

        SeleniumBrowser driver = new SeleniumBrowser();

        waitInSeconds(1);
        driver.minimizeBrowser();
//      String postUrl = "";
        String postUrl = getAndReturnPostUrl();
        driver.maximizeBrowser();

        driver.getDriver().get(postUrl);
        waitInSeconds(1);

        List<String> unverifiedFollowingUsernameWithoutPostOwnerUsernameList = removePostOwnerUsernameFromList(profileInfo, driver);

        comment(unverifiedFollowingUsernameWithoutPostOwnerUsernameList, driver);

    }

    private static List<String> removePostOwnerUsernameFromList(ProfileInfo profileInfo, SeleniumBrowser driver) {
        WebElement postOwnerUsername = driver.getDriver().findElement(InstagramXPaths.getPostOwnerUsernameXPath());
        return profileInfo.getUnverifiedFollowingUsernameList().stream().filter(username -> !username.contains(postOwnerUsername.getText())).collect(Collectors.toList());
    }

    private static void comment(List<String> unverifiedFollowingUsernameWithoutPostOwnerUsernameList, SeleniumBrowser driver) throws InterruptedException {

        WebElement commentTextArea;
        WebElement commentButton = driver.getDriver().findElement(InstagramXPaths.getCommentButtonXPath());

        for (String unverifiedFollowingUsername : unverifiedFollowingUsernameWithoutPostOwnerUsernameList) {

            commentTextArea = driver.getDriver().findElement(InstagramXPaths.getCommentTextAreaXPath());
            commentTextArea.click();

            commentTextArea = driver.getDriver().findElement(InstagramXPaths.getCommentTextAreaXPath());
            commentTextArea.sendKeys(unverifiedFollowingUsername);
            commentButton.click();

            waitIntervalRandomlyInSeconds(5, 10);
        }
    }

    private static String getAndReturnPostUrl() {
        return Console.getPostUrl();
    }

    private static void waitInSeconds(Integer milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds * 1000);
    }

    private static void waitIntervalRandomlyInSeconds(Integer minMilliseconds, Integer maxMilliseconds) throws InterruptedException {
        Integer milliseconds = new Random().nextInt(maxMilliseconds - minMilliseconds + 1) + minMilliseconds;
        Thread.sleep(milliseconds * 1000);
    }

}