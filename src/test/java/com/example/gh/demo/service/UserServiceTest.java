package com.example.gh.demo.service;

import com.example.gh.demo.external.GithubApiUser;
import com.example.gh.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * This class tests the implementation of the user service. A user from GitHub's API has to be converted into
 * a User with calculations field present.
 */
@SpringBootTest
class UserServiceTest {

    @MockBean
    GithubApiService githubApiService;

    @Autowired
    UserService userService;

    @Test
    void getUser() {
        GithubApiUser mockedUser = new GithubApiUser(
                1, "someLogin", "someName", "someType", "someUrl", LocalDateTime.parse("2021-05-03T12:10:00"), 6, 8);

        when(githubApiService.fetchGithubUser("someLogin")).thenReturn(Optional.of(mockedUser));

        double calculations = 6.0 / 6 * (2 + 8);
        User expected = User.builder()
                .id(1).login("someLogin").name("someName").type("someType").avatarUrl("someUrl")
                .createdAt(LocalDateTime.parse("2021-05-03T12:10:00")).calculations(calculations)
                .build();

        User actual = userService.getUser("someLogin").orElseThrow();

        assertEquals(expected, actual);
    }
}