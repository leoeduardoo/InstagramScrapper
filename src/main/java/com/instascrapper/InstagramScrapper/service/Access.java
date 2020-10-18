package com.instascrapper.InstagramScrapper.service;

import com.instascrapper.InstagramScrapper.utils.InstagramXPaths;
import com.instascrapper.InstagramScrapper.utils.Pair;
import com.instascrapper.InstagramScrapper.utils.SeleniumBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.Console;

public class Access {

    public static void login() throws InterruptedException {

        String username = getUsername();

        System.setProperty(SeleniumBrowser.getBrowser(), SeleniumBrowser.getBrowserPath());
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.instagram.com/accounts/login/?next=%2F" + username + "%2F&source=desktop_nav");

        waitSeconds(2);
        WebElement usernameField = driver.findElement(InstagramXPaths.getUsernameFieldXPath());
        usernameField.sendKeys(username);

        waitSeconds(2);
        WebElement passwordField = driver.findElement(InstagramXPaths.getPasswordFieldXPath());
        passwordField.sendKeys(getPassword());

        WebElement loginButton = driver.findElement(InstagramXPaths.getLoginButtonXPath());
        loginButton.click();

        waitSeconds(5);
        driver.close();

    }

    public static String getUsername() {

        Console console = System.console();

        if (console == null) {
            System.out.println("Couldn't open console. Exiting.");
            System.exit(0);
        }

        char[] usernameArray = console.readPassword("Enter your username: ");

        return String.valueOf(usernameArray);
    }

    private static String getPassword() {

        Console console = System.console();

        if (console == null) {
            System.out.println("Couldn't open console. Exiting.");
            System.exit(0);
        }

        char[] passwordArray = console.readPassword("Enter your secret password: ");

        return String.valueOf(passwordArray);
    }

    private static Pair<String, String> getCredentials() {

        Console console = System.console();

        if (console == null) {
            System.out.println("Couldn't open console. Exiting.");
            System.exit(0);
        }

        console.printf("Type your credentials%n");
        char[] usernameArray = console.readPassword("Enter your username: ");
        console.flush();
        char[] passwordArray = console.readPassword("Enter your secret password: ");

        return new Pair<>(String.valueOf(usernameArray), String.valueOf(passwordArray));
    }

    private static void waitSeconds(Integer seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

}
