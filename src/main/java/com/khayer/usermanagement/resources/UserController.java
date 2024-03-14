package com.khayer.usermanagement.resources;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.khayer.usermanagement.exception.CustomResponse;
import com.khayer.usermanagement.model.User;
import com.khayer.usermanagement.service.UserManagementService;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoWriteException;

import lombok.val;



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserManagementService userManagementService;

    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<CustomResponse> register(@Validated @RequestBody User user){

        userManagementService.save(user);
        
        CustomResponse success = new CustomResponse();
        success.setTimestamp(LocalDateTime.now());
        success.setMessage("Thank you for singing up.");
        success.setStatus(HttpStatus.CREATED.value());

        return new ResponseEntity<>(success,HttpStatus.CREATED);
    }
    /*
    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "duplicate email address")
    @ExceptionHandler(value={MongoWriteException.class, DuplicateKeyException.class}) 
    public void duplicateEmail(){

    }
    */
    
}
