package com.devtiro.blog.services.impl;

import com.devtiro.blog.domain.entities.Tag;
import com.devtiro.blog.repositories.TagRepository;
import com.devtiro.blog.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAllWithPostCount();
    }
}
