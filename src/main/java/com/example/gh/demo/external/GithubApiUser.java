package com.example.gh.demo.external;

import java.time.LocalDateTime;

public record GithubApiUser(
        Integer id,
        String login,
        String name,
        String type,
        String avatar_url,
        LocalDateTime created_at,
        Integer followers,
        Integer public_repos
) {}
