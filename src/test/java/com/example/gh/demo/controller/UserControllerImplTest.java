package com.example.gh.demo.controller;

import com.example.gh.demo.controller.impl.UserControllerImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * A unit testing class for UserControllerImpl.
 */
@WebMvcTest(UserControllerImpl.class)
public class UserControllerImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/someLogin"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }
}
