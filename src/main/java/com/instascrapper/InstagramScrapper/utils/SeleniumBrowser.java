package com.instascrapper.InstagramScrapper.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SeleniumBrowser {

    /**
     * So you can't instantiate
     */
    private SeleniumBrowser() {
    }

    private static String browser;
    private static String browserPath;

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
}
