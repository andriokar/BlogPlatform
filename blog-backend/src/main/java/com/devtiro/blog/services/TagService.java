package com.devtiro.blog.services;

import com.devtiro.blog.domain.entities.Tag;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface TagService {

    List<Tag> getAllTags();

    List<Tag> createTags(Set<String> tagNames);

    void deleteTag(UUID id);
}
