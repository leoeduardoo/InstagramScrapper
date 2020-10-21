package com.instascrapper.InstagramScrapper;

import com.instascrapper.InstagramScrapper.service.AccessService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InstagramScrapperApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(InstagramScrapperApplication.class, args);
        AccessService.login();
    }

}
