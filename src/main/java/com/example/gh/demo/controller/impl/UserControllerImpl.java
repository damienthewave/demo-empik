package com.example.gh.demo.controller.impl;

import com.example.gh.demo.controller.UserController;
import com.example.gh.demo.model.User;
import com.example.gh.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@AllArgsConstructor
@RestController
public class UserControllerImpl implements UserController {

    private UserService userService;

    @Override
    public ResponseEntity<User> getUser(String login) {
        Optional<User> user = userService.getUser(login);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
