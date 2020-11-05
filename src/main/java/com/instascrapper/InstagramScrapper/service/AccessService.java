package com.instascrapper.InstagramScrapper.service;

import com.instascrapper.InstagramScrapper.entity.AccessEntity;
import com.instascrapper.InstagramScrapper.exception.DuplicatedRegisterException;
import com.instascrapper.InstagramScrapper.exception.InvalidObjectException;
import com.instascrapper.InstagramScrapper.mapper.AccessMapper;
import com.instascrapper.InstagramScrapper.model.access.AccessDTO;
import com.instascrapper.InstagramScrapper.repository.AccessRepository;
import com.instascrapper.InstagramScrapper.service.seleniumbrowserservice.SeleniumAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class is supposed to sign in
 */
@Service
public class AccessService {

    @Autowired
    AccessRepository accessRepository;

    public AccessDTO access(String username) throws Exception {

        validate(username);

        SeleniumAccessService.login(username);

        verifyDuplicated(username);

        AccessEntity accessEntity = new AccessEntity();
        accessEntity.setUsername(username);

        accessEntity = save(accessEntity);

        return AccessMapper.INSTANCE.mapToDTO(accessEntity);
    }

    private void verifyDuplicated(String username) {
        if (findRegisterByUsername(username) != null) {
            throw new DuplicatedRegisterException(username);
        }
    }

    protected AccessEntity save(AccessEntity accessEntity) {
        return accessRepository.save(accessEntity);
    }

    private void validate(String username) {

        if (username == null || username.trim().isEmpty()) {
            throw new InvalidObjectException();
        }

    }

    protected AccessEntity findRegisterByUsername(String username) {
        return accessRepository.findByUsername(username).orElse(null);
    }

}