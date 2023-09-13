package com.example.gh.demo.repository;

import com.example.gh.demo.entity.RequestCountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RequestCountRepository extends JpaRepository<RequestCountEntity, String> {

    @Transactional
    @Modifying
    @Query("update RequestCountEntity r set r.requestCount = r.requestCount + 1 where r.login = :login")
    void incrementRequestCount(@Param("login") String login);
}
