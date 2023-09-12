package com.example.gh.demo.controller.impl;

import com.example.gh.demo.controller.UserController;
import com.example.gh.demo.model.User;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {

    @Override
    public User getUser(String login) {
        return null;
    }
}
