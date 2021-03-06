package com.instascrapper.InstagramScrapper.mapper;

import com.instascrapper.InstagramScrapper.entity.ProfileEntity;
import com.instascrapper.InstagramScrapper.model.profile.ProfileDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);

    ProfileDTO mapToDTO(ProfileEntity profileEntity);

}