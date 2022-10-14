package com.horaoen.mongodbexample.controller;

import com.horaoen.mongodbexample.entity.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    private final MongoTemplate mongoTemplate;


    public TestController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostMapping
    public void insert() {
        User user = User.builder()
                .username("horaoen")
                .password("1223456")
                .build();
        mongoTemplate.insert(user, "user");
    }
}
