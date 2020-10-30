package com.instascrapper.InstagramScrapper.repository;

import com.instascrapper.InstagramScrapper.entity.RegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisterRepository extends JpaRepository<RegisterEntity, Long> {
    Optional<RegisterEntity> findByUsername(String username);
}