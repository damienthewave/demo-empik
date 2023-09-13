package com.example.gh.demo.service.impl;

import com.example.gh.demo.entity.RequestCountEntity;
import com.example.gh.demo.repository.RequestCountRepository;
import com.example.gh.demo.service.RequestCountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RequestCountServiceImpl implements RequestCountService {

    private RequestCountRepository repository;

    @Override
    public void updateCounter(String login) {
        if (repository.existsById(login)) {
            repository.incrementRequestCount(login);
        } else {
            repository.save(new RequestCountEntity(login, 1));
        }
    }
}
