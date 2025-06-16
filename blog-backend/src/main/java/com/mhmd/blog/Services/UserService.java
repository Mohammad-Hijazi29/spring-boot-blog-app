package com.mhmd.blog.Services;

import com.mhmd.blog.domain.entities.User;

import java.util.UUID;

public interface UserService {

    User getUserById(UUID id);
}
