package com.instascrapper.InstagramScrapper.mapper;

import com.instascrapper.InstagramScrapper.entity.RegisterEntity;
import com.instascrapper.InstagramScrapper.model.access.AccessDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccessMapper {

    AccessMapper INSTANCE = Mappers.getMapper(AccessMapper.class);

    AccessDTO mapToDTO(RegisterEntity registerEntity);

}