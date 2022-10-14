package com.horaoen.mongodbexample.mongotemplate;

import com.alibaba.fastjson2.JSONObject;
import com.horaoen.mongodbexample.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@SpringBootTest
@Slf4j
public class MongoTemplateTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void insertTest() {
        User user = User.builder()
                .username("horaoen")
                .password("1223456")
                .build();
        mongoTemplate.insert(user, "user");
    }

    @Test
    public void saveInsert() {
        User user = User.builder()
                .username("bleso")
                .password("1223456")
                .build();
        mongoTemplate.save(user, "user");
    }

    @Test
    public void savaUpdate() {
        User user = mongoTemplate.findOne(
                Query.query(Criteria.where("username").is("bleso")),
                User.class
        );

        user.setUsername("Jim");
        mongoTemplate.save(user, "user");
    }

    @Test
    public void updateFirst() {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is("Jim"));
        Update update = new Update();
        update.set("username", "mack");
        mongoTemplate.updateFirst(query, update, User.class);
    }

    @Test
    public void updateMulti() {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is("Jim"));
        Update update = new Update();
        update.set("username", "fhr");
        mongoTemplate.updateMulti(query, update, User.class);
    }

    @Test
    public void findAndModify() {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is("mack"));
        Update update = new Update();
        update.set("password", "12345");
        User user = mongoTemplate.findAndModify(query, update, User.class);
        log.info("user: [{}]", JSONObject.toJSONString(user));
    }

    @Test
    public void upsertTest() {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is("Markus"));
        Update update = new Update();
        update.set("username", "Nick");
        mongoTemplate.upsert(query, update, User.class);
    }

    @Test
    public void removeTest() {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is("Nick"));
        User user = mongoTemplate.findOne(query, User.class);
        mongoTemplate.remove(user);
    }







}
