package com.instascrapper.InstagramScrapper.repository;

import com.instascrapper.InstagramScrapper.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
    Optional<ProfileEntity> findByIdRegister(Long idRegister);
}