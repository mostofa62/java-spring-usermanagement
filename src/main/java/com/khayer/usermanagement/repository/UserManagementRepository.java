package com.khayer.usermanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.khayer.usermanagement.model.User;

public interface UserManagementRepository extends MongoRepository<User
, String> {
    User findByEmail(String email);
}
