package com.example.gh.demo.external;

public record GithubApiUser(
        Integer id,
        String login,
        String name,
        String type,
        String avatarUrl,
        String createdAt,
        Integer followers,
        Integer public_repos
) {}
