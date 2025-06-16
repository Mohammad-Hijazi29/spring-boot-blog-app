package com.mhmd.blog.Services.impl;


import com.mhmd.blog.Services.UserService;
import com.mhmd.blog.domain.entities.User;
import com.mhmd.blog.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserById(UUID id) {
       return userRepository.findById(id).orElseThrow( ()->
                new EntityNotFoundException("User not found with id"+ id)

        );
    }
}
