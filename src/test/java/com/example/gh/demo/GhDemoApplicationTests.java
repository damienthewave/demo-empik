package com.example.gh.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


/**
 * This class contains integration tests.
 */
@SpringBootTest
@AutoConfigureMockMvc
class GhDemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnGithubUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/odersky"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.login").value("odersky"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.calculations").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.createdAt").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.type").value("User"));
    }

    @Test
    void shouldReturnNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/someNonexistentLogin"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

}
