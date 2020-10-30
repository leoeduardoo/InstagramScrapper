package com.instascrapper.InstagramScrapper.service;

import com.instascrapper.InstagramScrapper.entity.RegisterEntity;
import com.instascrapper.InstagramScrapper.exception.DuplicatedRegisterException;
import com.instascrapper.InstagramScrapper.exception.InvalidObjectException;
import com.instascrapper.InstagramScrapper.mapper.AccessMapper;
import com.instascrapper.InstagramScrapper.model.register.RegisterDTO;
import com.instascrapper.InstagramScrapper.repository.RegisterRepository;
import com.instascrapper.InstagramScrapper.service.seleniumbrowserservice.SeleniumAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class is supposed to get credentials
 */
@Service
public class AccessService {

    @Autowired
    RegisterRepository registerRepository;

    public RegisterDTO register(RegisterDTO registerDTO) throws Exception {

        validate(registerDTO);

        verifyDuplicated(registerDTO);

        SeleniumAccessService.login(registerDTO);

        RegisterEntity registerEntity = AccessMapper.INSTANCE.mapToEntity(registerDTO);

        registerEntity = save(registerEntity);

        return AccessMapper.INSTANCE.mapToDTO(registerEntity);
    }

    private void verifyDuplicated(RegisterDTO registerDTO) {
        if (findRegisterByUsername(registerDTO.getUsername()) != null) {
            throw new DuplicatedRegisterException(registerDTO.getUsername());
        }
    }

    protected RegisterEntity save(RegisterEntity registerEntity) {
        return registerRepository.save(registerEntity);
    }

    private void validate(RegisterDTO registerDTO) {
        String username = registerDTO.getUsername();
        String password = registerDTO.getPassword();

        if (username == null || password == null || username.trim().isEmpty() || password.trim().isEmpty()) {
            throw new InvalidObjectException();
        }

    }

    protected RegisterEntity findRegisterByUsername(String username) {
        return registerRepository.findByUsername(username).orElse(null);
    }

}