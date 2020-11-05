package com.instascrapper.InstagramScrapper.service;

import com.instascrapper.InstagramScrapper.entity.RegisterEntity;
import com.instascrapper.InstagramScrapper.exception.DuplicatedRegisterException;
import com.instascrapper.InstagramScrapper.exception.InvalidObjectException;
import com.instascrapper.InstagramScrapper.mapper.AccessMapper;
import com.instascrapper.InstagramScrapper.model.access.AccessDTO;
import com.instascrapper.InstagramScrapper.repository.RegisterRepository;
import com.instascrapper.InstagramScrapper.service.seleniumbrowserservice.SeleniumAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class is supposed to sign in
 */
@Service
public class AccessService {

    @Autowired
    RegisterRepository registerRepository;

    public AccessDTO access(String username) throws Exception {

        validate(username);

        SeleniumAccessService.login(username);

        verifyDuplicated(username);

        RegisterEntity registerEntity = new RegisterEntity();
        registerEntity.setUsername(username);

        registerEntity = save(registerEntity);

        return AccessMapper.INSTANCE.mapToDTO(registerEntity);
    }

    private void verifyDuplicated(String username) {
        if (findRegisterByUsername(username) != null) {
            throw new DuplicatedRegisterException(username);
        }
    }

    protected RegisterEntity save(RegisterEntity registerEntity) {
        return registerRepository.save(registerEntity);
    }

    private void validate(String username) {

        if (username == null || username.trim().isEmpty()) {
            throw new InvalidObjectException();
        }

    }

    protected RegisterEntity findRegisterByUsername(String username) {
        return registerRepository.findByUsername(username).orElse(null);
    }

}