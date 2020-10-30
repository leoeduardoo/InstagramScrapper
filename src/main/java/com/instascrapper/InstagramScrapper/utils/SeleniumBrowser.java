package com.instascrapper.InstagramScrapper.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SeleniumBrowser {

    @Value("${selenium.browserDriver}")
    private String browserDriver;
    @Value("${selenium.browserPath}")
    private String browserPath;

    private static WebDriver driver;

    public SeleniumBrowser() {
    }

    @PostConstruct
    private void configureSystemPropertiesAndBrowserDriver() {
        System.setProperty(browserDriver, browserPath);
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

}