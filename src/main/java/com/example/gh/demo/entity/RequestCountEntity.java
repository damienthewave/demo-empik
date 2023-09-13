package com.example.gh.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@ToString
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RequestCountEntity {

    @Id
    private String login;

    private Integer requestCount;
}
