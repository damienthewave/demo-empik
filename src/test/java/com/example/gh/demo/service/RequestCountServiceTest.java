package com.example.gh.demo.service;

import com.example.gh.demo.entity.RequestCountEntity;
import com.example.gh.demo.repository.RequestCountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
class RequestCountServiceTest {

    @Autowired
    RequestCountService requestCountService;

    @Autowired
    RequestCountRepository requestCountRepository;

    @Test
    void insertsValueIfKeyIsNotPresent() {
        requestCountService.updateCounter("newLogin");

        RequestCountEntity expected = new RequestCountEntity("newLogin", 1);
        RequestCountEntity actual = requestCountRepository.findById("newLogin").orElseThrow();

        assertEquals(expected, actual);
    }

    @Test
    void incrementsValueIfKeyIsPresent() {
        requestCountRepository.save(new RequestCountEntity("someLogin", 6));

        // key is present
        requestCountService.updateCounter("someLogin");

        RequestCountEntity expected = new RequestCountEntity("someLogin", 7);
        RequestCountEntity actual = requestCountRepository.findById("someLogin").orElseThrow();

        assertEquals(expected, actual);
    }
}