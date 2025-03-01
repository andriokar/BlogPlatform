package com.devtiro.blog.controllers;

import com.devtiro.blog.domain.dtos.PostDto;
import com.devtiro.blog.domain.entities.Post;
import com.devtiro.blog.mappers.PostMapper;
import com.devtiro.blog.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    private final PostMapper postMapper;

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(
            @RequestParam(required = false) UUID categoryId,
            @RequestParam(required = false) UUID tagId
    ) {
        List<Post> posts = postService.getAllPosts(categoryId, tagId);
        List<PostDto> postDtos = posts.stream().map(postMapper::toPostDto).toList();

        return ResponseEntity.ok(postDtos);
    }
}
