package com.horaoen.mongodbexample.entity;

import com.querydsl.core.annotations.QueryEntity;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document
@QueryEntity
public class User {
    @Id
    private String id;
    private String username;
    private String password;
}
