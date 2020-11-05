package com.instascrapper.InstagramScrapper.service;

import com.instascrapper.InstagramScrapper.entity.AccessEntity;
import com.instascrapper.InstagramScrapper.entity.ProfileEntity;
import com.instascrapper.InstagramScrapper.exception.DuplicatedProfileException;
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

        AccessEntity accessEntity = accessService.findRegisterByUsername(username);

        if (accessEntity == null) {
            throw new ObjectNotFoundException(username);
        }

        verifyDuplicated(accessEntity.getId());

        ProfileInfo profileInfo = SeleniumProfileService.getProfileInfo(username);

        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setUnverifiedFollowingUsernameList(profileInfo.getUnverifiedFollowingUsernameList());
        profileEntity.setFollowers(profileInfo.getFollowers());
        profileEntity.setFollowing(profileInfo.getFollowing());
        profileEntity.setIdRegister(accessEntity.getId());

        profileEntity = save(profileEntity);

        return ProfileMapper.INSTANCE.mapToDTO(profileEntity);
    }

    private void verifyDuplicated(Long idRegister) {
        if (findProfileByIdRegister(idRegister) != null) {
            throw new DuplicatedProfileException();
        }
    }

    private ProfileEntity save(ProfileEntity profileEntity) {
        return profileRepository.save(profileEntity);
    }

    protected ProfileEntity findProfileByIdRegister(Long idRegister) {
        return profileRepository.findByIdRegister(idRegister).orElse(null);
    }

}