package com.example.gh.demo.service;

import com.example.gh.demo.external.GithubApiUser;
import com.example.gh.demo.model.User;
import org.springframework.stereotype.Service;

/**
 * This service is responsible for the calculating "calculation" field and converting a GitHubApiUser to a User with
 * a calculated value.
 */
@Service
public class UserCalculationService {

    public User calculateUserStats(GithubApiUser githubApiUser) {
        double calculations = 6.0 / githubApiUser.followers() * (2 + githubApiUser.public_repos());
        return User.builder()
                .id(githubApiUser.id())
                .login(githubApiUser.login())
                .type(githubApiUser.type())
                .name(githubApiUser.name())
                .avatarUrl(githubApiUser.avatar_url())
                .createdAt(githubApiUser.created_at())
                .calculations(calculations)
                .build();
    }
}
