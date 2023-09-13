package com.example.gh.demo.service.impl;

import com.example.gh.demo.external.GithubApiUser;
import com.example.gh.demo.service.GithubApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GithubApiServiceImpl implements GithubApiService {

    final private RestTemplate restTemplate;

    @Value("${github.api.users.url}")
    private String githubUsersApiUrl;

    @Override
    public Optional<GithubApiUser> fetchGithubUser(String login) {
        try {
            GithubApiUser apiUser = restTemplate.getForObject(
                    githubUsersApiUrl.formatted(login),
                    GithubApiUser.class
            );
            return Optional.ofNullable(apiUser);
        } catch (HttpClientErrorException e) {
            return Optional.empty();
        }
    }
}
