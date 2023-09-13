package com.example.gh.demo.service.impl;

import com.example.gh.demo.external.GithubApiUser;
import com.example.gh.demo.model.User;
import com.example.gh.demo.service.RequestCountService;
import com.example.gh.demo.service.GithubApiService;
import com.example.gh.demo.service.UserCalculationService;
import com.example.gh.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private GithubApiService githubApiService;

    private UserCalculationService userCalculationService;

    private RequestCountService counterService;

    @Override
    public Optional<User> getUser(String login) {
        counterService.updateCounter(login);
        Optional<GithubApiUser> apiUser = githubApiService.fetchGithubUser(login);
        return apiUser.map(userCalculationService::calculateUserStats);
    }
}
