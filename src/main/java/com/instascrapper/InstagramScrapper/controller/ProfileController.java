package com.instascrapper.InstagramScrapper.controller;

import com.instascrapper.InstagramScrapper.mapper.ProfileMapper;
import com.instascrapper.InstagramScrapper.model.MessageResponse;
import com.instascrapper.InstagramScrapper.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "instagramscrapper", produces = "application/json")
public class ProfileController {

    private final ProfileService profileService;
    private final ProfileMapper profileMapper;

    @Autowired
    public ProfileController(ProfileService profileService, ProfileMapper profileMapper) {
        this.profileService = profileService;
        this.profileMapper = profileMapper;
    }

    @GetMapping("/profile")
    public ResponseEntity<String> profile(@RequestParam String username) throws Exception {

        profileService.profile(username);

        return new ResponseEntity(new MessageResponse("Profile information obtained successfully."), HttpStatus.OK);
    }

}