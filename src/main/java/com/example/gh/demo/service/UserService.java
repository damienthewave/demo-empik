package com.example.gh.demo.service;

import com.example.gh.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * A service for delivering a User class from
 */
@Service
public interface UserService {

    /**
     * @param login GitHub's user login
     * @return Optional with user or empty Optional if not found
     */
    Optional<User> getUser(String login);
}
