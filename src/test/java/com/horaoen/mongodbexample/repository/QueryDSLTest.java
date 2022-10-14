package com.horaoen.mongodbexample.repository;

import com.alibaba.fastjson2.JSONObject;
import com.horaoen.mongodbexample.entity.QUser;
import com.horaoen.mongodbexample.entity.User;
import com.querydsl.core.types.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
public class QueryDSLTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void eqTest() {
        QUser qUser = new QUser("user");
        Predicate predicate = qUser.username.eq("horaoen");
        Iterable<User> all = userRepository.findAll(predicate);
        all.forEach(e -> log.info("each horaoen: {}", JSONObject.toJSONString(e)));
    }
}
