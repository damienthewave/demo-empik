package com.example.gh.demo.service.impl;

import com.example.gh.demo.model.User;
import com.example.gh.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public Optional<User> getUser(String login) {
        return Optional.empty();
    }
}
