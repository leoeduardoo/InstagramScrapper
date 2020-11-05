package com.instascrapper.InstagramScrapper.repository;

import com.instascrapper.InstagramScrapper.entity.AccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccessRepository extends JpaRepository<AccessEntity, Long> {
    Optional<AccessEntity> findByUsername(String username);
}