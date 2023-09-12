package com.example.gh.demo.controller.impl;

import com.example.gh.demo.controller.UserController;
import com.example.gh.demo.model.User;
import com.example.gh.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserControllerImpl implements UserController {

    private UserService userService;

    @Override
    public ResponseEntity<User> getUser(String login) {
        return null;
    }

}
