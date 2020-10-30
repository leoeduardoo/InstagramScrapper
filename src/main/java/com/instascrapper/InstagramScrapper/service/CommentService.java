package com.instascrapper.InstagramScrapper.service;

import com.instascrapper.InstagramScrapper.entity.ProfileEntity;
import com.instascrapper.InstagramScrapper.entity.RegisterEntity;
import com.instascrapper.InstagramScrapper.mapper.ProfileMapper;
import com.instascrapper.InstagramScrapper.model.comment.CommentDTO;
import com.instascrapper.InstagramScrapper.model.profile.ProfileDTO;
import com.instascrapper.InstagramScrapper.service.seleniumbrowserservice.SeleniumCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class is supposed to comment on a post
 */
@Service
public class CommentService {

    @Autowired
    private AccessService accessService;

    @Autowired
    private ProfileService profileService;

    public void comment(CommentDTO commentDTO) throws InterruptedException {

        RegisterEntity registerEntity = accessService.findRegisterByUsername(commentDTO.getUsername());
        ProfileEntity profileEntity = profileService.findProfileByIdRegister(registerEntity.getId());
        ProfileDTO profileDTO = ProfileMapper.INSTANCE.mapToDTO(profileEntity);

        SeleniumCommentService.comment(profileDTO, commentDTO.getPostUrl());

    }

}