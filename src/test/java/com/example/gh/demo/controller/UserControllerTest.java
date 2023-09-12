package com.example.gh.demo.controller;

import com.example.gh.demo.controller.impl.UserControllerImpl;
import com.example.gh.demo.model.User;
import com.example.gh.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * A unit testing class for UserControllerImpl.
 */
@WebMvcTest(UserControllerImpl.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void shouldReturnUser() throws Exception {
        User mockedUser = User.builder()
                .id(1)
                .login("someLogin")
                .avatarUrl("someUrl.com/somePath/some.jpg")
                .calculations(7.9)
                .type("someType")
                .createdAt(LocalDateTime.of(2021, 5, 3, 12, 10))
                .name("someName")
                .build();

        when(userService.getUser("someLogin")).thenReturn(Optional.of(mockedUser));

        mockMvc.perform(MockMvcRequestBuilders.get("/users/someLogin"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.login").value("someLogin"))
                .andExpect(jsonPath("$.name").value("someName"))
                .andExpect(jsonPath("$.calculations").value("7.9"))
                .andExpect(jsonPath("$.type").value("someType"))
                .andExpect(jsonPath("$.avatarUrl").value("someUrl.com/somePath/some.jpg"))
                .andExpect(jsonPath("$.createdAt").value("2021-05-03T12:10:00"));
    }

    @Test
    public void shouldReturnNotFound() throws Exception {
        when(userService.getUser("someLogin")).thenReturn(Optional.empty());

        mockMvc.perform(MockMvcRequestBuilders.get("/users/someLogin"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound());
    }
}
