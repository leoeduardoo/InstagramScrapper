package com.instascrapper.InstagramScrapper.service.seleniumbrowserservice;

import com.instascrapper.InstagramScrapper.model.profile.ProfileDTO;
import com.instascrapper.InstagramScrapper.utils.InstagramXPaths;
import com.instascrapper.InstagramScrapper.utils.SeleniumBrowser;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * This class is supposed to use browser to comment on a post
 */
public class SeleniumCommentService extends SeleniumBrowser {

    public static void comment(ProfileDTO profileDTO, String postUrl) throws InterruptedException {

        SeleniumBrowser driver = new SeleniumBrowser();
        waitInSeconds(3);

        driver.getDriver().get(postUrl);
        waitInSeconds(3);

        List<String> unverifiedFollowingUsernameWithoutPostOwnerUsernameList = removePostOwnerUsernameFromList(profileDTO, driver);

        comment(unverifiedFollowingUsernameWithoutPostOwnerUsernameList, driver);

    }

    private static List<String> removePostOwnerUsernameFromList(ProfileDTO profileDTO, SeleniumBrowser driver) {
        WebElement postOwnerUsername = driver.getDriver().findElement(InstagramXPaths.getPostOwnerUsernameXPath());
        return profileDTO.getUnverifiedFollowingUsernameList().stream().filter(username -> !username.contains(postOwnerUsername.getText())).collect(Collectors.toList());
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

            waitIntervalRandomlyInSeconds(70, 80);
        }
    }

    private static void waitInSeconds(Integer milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds * 1000);
    }

    private static void waitIntervalRandomlyInSeconds(Integer minMilliseconds, Integer maxMilliseconds) throws InterruptedException {
        Integer milliseconds = new Random().nextInt(maxMilliseconds - minMilliseconds + 1) + minMilliseconds;
        Thread.sleep(milliseconds * 1000);
    }

}