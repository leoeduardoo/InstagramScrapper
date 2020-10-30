package com.instascrapper.InstagramScrapper.mapper;

import com.instascrapper.InstagramScrapper.model.comment.CommentDTO;
import com.instascrapper.InstagramScrapper.model.comment.CommentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentDTO mapToDTO(CommentRequest commentRequest);

}