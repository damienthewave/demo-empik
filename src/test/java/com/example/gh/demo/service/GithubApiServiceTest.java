package com.example.gh.demo.service;

import com.example.gh.demo.external.GithubApiUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * This class tests the behaviour of the GitHubApiService class.
 */
@SpringBootTest
class GithubApiServiceTest {

    @MockBean
    RestTemplate restTemplate;

    @Autowired
    GithubApiService githubApiService;

    @Test
    void fetchingGithubUserShouldSucceed() {
        GithubApiUser mockedUser = new GithubApiUser(
                1, "someLogin", "someName", "someType", "someUrl", LocalDateTime.parse("2021-05-03T12:10:00"), 6, 8);

        when(restTemplate.getForObject("https://api.github.com/users/someLogin", GithubApiUser.class))
                .thenReturn(mockedUser);

        GithubApiUser user = githubApiService.fetchGithubUser("someLogin").orElseThrow();

        assertEquals(mockedUser, user);
    }

    @Test
    void fetchGithubUserShouldReturnEmpty() {
        when(restTemplate.getForObject("https://api.github.com/users/someNonexistentLogin", GithubApiUser.class))
                .thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));

        Optional<GithubApiUser> user = githubApiService.fetchGithubUser("someLogin");

        assertEquals(user, Optional.empty());
    }
}