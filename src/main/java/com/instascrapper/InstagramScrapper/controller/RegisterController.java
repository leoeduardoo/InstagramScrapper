package com.instascrapper.InstagramScrapper.controller;

import com.instascrapper.InstagramScrapper.mapper.AccessMapper;
import com.instascrapper.InstagramScrapper.model.MessageResponse;
import com.instascrapper.InstagramScrapper.model.register.RegisterDTO;
import com.instascrapper.InstagramScrapper.model.register.RegisterRequest;
import com.instascrapper.InstagramScrapper.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "instagramscrapper", produces = "application/json")
public class RegisterController {

    private final AccessService accessService;
    private final AccessMapper accessMapper;

    @Autowired
    public RegisterController(AccessService accessService, AccessMapper accessMapper) {
        this.accessService = accessService;
        this.accessMapper = accessMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest newRegisterRequest) throws Exception {

        RegisterDTO newRegisterDTORequest = accessMapper.mapToDTO(newRegisterRequest);

        accessService.register(newRegisterDTORequest);

        return new ResponseEntity(new MessageResponse("Registered successfully."), HttpStatus.CREATED);
    }

}