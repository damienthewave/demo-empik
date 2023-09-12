package com.example.gh.demo.service;

import com.example.gh.demo.external.GithubApiUser;

import java.util.Optional;

/**
 * This service is responsible for fetching the Users from GitHub's API.
 */
public interface GithubApiService {

    /**
     * @param login GitHub's user login
     * @return Optional with fetched data or empty Optional
     */
    Optional<GithubApiUser> fetchGithubUser(String login);
}
