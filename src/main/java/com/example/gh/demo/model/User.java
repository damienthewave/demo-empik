package com.example.gh.demo.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


/**
 * A user class with present calculations field.
 */
@Getter
@Builder
public class User {

    private Integer id;

    private String login;

    private String name;

    private String type;

    private String avatarUrl;

    private LocalDateTime createdAt;

    private Double calculations;

}
