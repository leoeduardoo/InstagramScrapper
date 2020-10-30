package com.instascrapper.InstagramScrapper.service;

import com.instascrapper.InstagramScrapper.entity.ProfileEntity;
import com.instascrapper.InstagramScrapper.entity.RegisterEntity;
import com.instascrapper.InstagramScrapper.exception.ObjectNotFoundException;
import com.instascrapper.InstagramScrapper.mapper.ProfileMapper;
import com.instascrapper.InstagramScrapper.model.ProfileInfo;
import com.instascrapper.InstagramScrapper.model.profile.ProfileDTO;
import com.instascrapper.InstagramScrapper.repository.ProfileRepository;
import com.instascrapper.InstagramScrapper.service.seleniumbrowserservice.SeleniumProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class is supposed to get profile info
 */
@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AccessService accessService;


    public ProfileDTO profile(String username) throws Exception {

        RegisterEntity registerEntity = accessService.findRegisterByUsername(username);

        if (registerEntity == null) {
            throw new ObjectNotFoundException(username);
        }

        ProfileInfo profileInfo = SeleniumProfileService.getProfileInfo(username);

        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setUnverifiedFollowingUsernameList(profileInfo.getUnverifiedFollowingUsernameList());
        profileEntity.setFollowers(profileInfo.getFollowers());
        profileEntity.setFollowing(profileInfo.getFollowing());
        profileEntity.setIdRegister(registerEntity.getId());

        profileEntity = profileRepository.save(profileEntity);

        return ProfileMapper.INSTANCE.mapToDTO(profileEntity);
    }

    protected ProfileEntity findProfileByIdRegister(Long idRegister) {
        return profileRepository.findByIdRegister(idRegister).orElse(null);
    }

}