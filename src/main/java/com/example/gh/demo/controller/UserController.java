package com.example.gh.demo.controller;

import com.example.gh.demo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * An interface specifying the REST operations on /users endpoint.
 */
@RequestMapping("/users")
public interface UserController {

    /**
     * @param login the unique username of a GitHub's user
     * @return GitHub's user with calculations present
     */
    @GetMapping("/{login}")
    User getUser(@PathVariable String login);
}
