package com.khayer.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khayer.usermanagement.model.User;
import com.khayer.usermanagement.repository.UserManagementRepository;

@Service
public class UserManagementService {

    @Autowired
    private UserManagementRepository userManagementRepository;

    public void save(User user){
        userManagementRepository.save(user);

    }
    
}
