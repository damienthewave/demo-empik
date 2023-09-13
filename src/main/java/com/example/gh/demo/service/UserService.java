package com.example.gh.demo.service;

import com.example.gh.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * A service for delivering a User objects.
 */
@Service
public interface UserService {

    /**
     * The method is delivering a User class based on the data fetched from the GitHub's API.
     * Note that the method also increments a database counter.
     *
     * @param login GitHub's user login
     * @return Optional with user or empty Optional if not found
     */
    Optional<User> getUser(String login);
}
