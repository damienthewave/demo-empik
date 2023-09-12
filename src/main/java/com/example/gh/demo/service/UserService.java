package com.example.gh.demo.service;

import com.example.gh.demo.model.User;

import java.util.Optional;

/**
 * A service for delivering a User class from
 */
public interface UserService {

    Optional<User> getUser(String login);
}
