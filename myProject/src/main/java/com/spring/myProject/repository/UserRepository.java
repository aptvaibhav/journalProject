package com.spring.myProject.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.myProject.entity.User;

public interface UserRepository extends MongoRepository<User,ObjectId>{
    User findByUserName(String username);
}
