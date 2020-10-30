package com.instascrapper.InstagramScrapper.mapper;

import com.instascrapper.InstagramScrapper.entity.RegisterEntity;
import com.instascrapper.InstagramScrapper.model.register.RegisterDTO;
import com.instascrapper.InstagramScrapper.model.register.RegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccessMapper {

    AccessMapper INSTANCE = Mappers.getMapper(AccessMapper.class);

    RegisterEntity mapToEntity(RegisterDTO registerDTO);

    RegisterDTO mapToDTO(RegisterRequest registerRequest);

    RegisterDTO mapToDTO(RegisterEntity registerEntity);

}