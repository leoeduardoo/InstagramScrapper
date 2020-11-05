package com.instascrapper.InstagramScrapper.controller;

import com.instascrapper.InstagramScrapper.model.MessageResponse;
import com.instascrapper.InstagramScrapper.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "instagramscrapper", produces = "application/json")
public class AccessController {

    private final AccessService accessService;

    @Autowired
    public AccessController(AccessService accessService) {
        this.accessService = accessService;
    }

    @GetMapping("/access")
    public ResponseEntity<String> access(@RequestParam String username) throws Exception {

        accessService.access(username);

        return new ResponseEntity(new MessageResponse("Registered successfully."), HttpStatus.CREATED);
    }

}