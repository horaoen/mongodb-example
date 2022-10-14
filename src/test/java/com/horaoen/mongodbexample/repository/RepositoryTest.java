package com.horaoen.mongodbexample.repository;

import com.alibaba.fastjson2.JSONObject;
import com.horaoen.mongodbexample.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
@Slf4j
public class RepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void insertTest() {
        User user = User.builder().username("hhh").build();
        userRepository.insert(user);
    }

    @Test
    public void findAllWithSort() {
        List<User> userList = userRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        userList.forEach(e -> log.info("{}", JSONObject.toJSONString(e)));
    }

    @Test
    public void pageQuery() {
        //分页查询的第一页是从0开始算
        Pageable pageableRequest = PageRequest.of(0, 3);
        Page<User> page = userRepository.findAll(pageableRequest);
        List<User> userList = page.getContent();
        userList.forEach(e -> log.info("{}", JSONObject.toJSONString(e)));
    }

    @Test
    public void findByX() {
        List<User> user = userRepository.findByUsername("mack");
        log.info("{}", JSONObject.toJSONString(user));
    }

    @Test
    public void startAndEndWithTest() {
        List<User> userList = userRepository.findByUsernameStartingWith("m");
        userList.forEach(e -> log.info("name start with m user: {}", JSONObject.toJSONString(e)));
    }


}
