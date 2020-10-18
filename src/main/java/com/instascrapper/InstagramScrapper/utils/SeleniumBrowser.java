package com.instascrapper.InstagramScrapper.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SeleniumBrowser {

    private static String browser;
    private static String browserPath;

    /**
     * So you can't instantiate
     */
    private SeleniumBrowser() {
    }

    public static String getBrowser() {
        return browser;
    }

    public static String getBrowserPath() {
        return browserPath;
    }

    @Value("${selenium.browser}")
    public void setBrowser(String browser) {
        this.browser = browser;
    }

    @Value("${selenium.browserPath}")
    public void setBrowserPath(String browserPath) {
        this.browserPath = browserPath;
    }

    public static WebDriver configureAndReturnChromeBrowserWebDriver() {
        System.setProperty(getBrowser(), getBrowserPath());
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static void minimize(WebDriver driver) {
        Point p = driver.manage().window().getPosition();
        Dimension d = driver.manage().window().getSize();
        driver.manage().window().setPosition(new Point((d.getHeight() - p.getX()), (d.getWidth() - p.getY())));
    }

    public static void maximize(WebDriver driver) {
        driver.manage().window().maximize();
    }
}
