package com.horaoen.mongodbexample.repository;

import com.horaoen.mongodbexample.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String>, QuerydslPredicateExecutor<User> {
    List<User> findByUsername(String name);
    List<User> findByPassword(String password);
    List<User> findByUsernameStartingWith(String regexp);
    List<User> findByUsernameEndingWith(String regexp);
}