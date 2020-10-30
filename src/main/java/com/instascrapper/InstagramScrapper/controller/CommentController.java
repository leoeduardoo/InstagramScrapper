package com.instascrapper.InstagramScrapper.controller;

import com.instascrapper.InstagramScrapper.mapper.CommentMapper;
import com.instascrapper.InstagramScrapper.model.MessageResponse;
import com.instascrapper.InstagramScrapper.model.comment.CommentDTO;
import com.instascrapper.InstagramScrapper.model.comment.CommentRequest;
import com.instascrapper.InstagramScrapper.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "instagramscrapper", produces = "application/json")
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper commentMapper;

    @Autowired
    public CommentController(CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    @GetMapping("/comment")
    public ResponseEntity<String> comment(@RequestBody CommentRequest newCommentRequest) throws Exception {

        CommentDTO newCommentDTORequest = commentMapper.mapToDTO(newCommentRequest);

        commentService.comment(newCommentDTORequest);

        return new ResponseEntity(new MessageResponse("Post was commented successfully."), HttpStatus.OK);
    }

}