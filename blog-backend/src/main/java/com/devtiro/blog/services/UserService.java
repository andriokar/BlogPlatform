package com.devtiro.blog.services;

import com.devtiro.blog.domain.entities.User;

import java.util.UUID;

public interface UserService {

    User getUserById(UUID userId);
}
