package com.instascrapper.InstagramScrapper.common;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
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
        driver = new ChromeDriver();
    }

    public void minimizeBrowser() {
        Point p = this.driver.manage().window().getPosition();
        Dimension d = this.driver.manage().window().getSize();
        this.driver.manage().window().setPosition(new Point((d.getHeight() - p.getX()), (d.getWidth() - p.getY())));
    }

    public void maximizeBrowser() {
        this.driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

}