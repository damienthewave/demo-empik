package com.example.gh.demo.service.impl;

import com.example.gh.demo.external.GithubApiUser;
import com.example.gh.demo.service.GithubApiService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GithubApiServiceImpl implements GithubApiService {

    @Override
    public Optional<GithubApiUser> fetchGithubUser(String login) {
        return Optional.empty();
    }
}
