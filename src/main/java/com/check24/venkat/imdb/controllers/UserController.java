package com.check24.venkat.imdb.controllers;

import com.check24.venkat.imdb.dto.UserDto;
import com.check24.venkat.imdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.FailedLoginException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/userref")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        return new ResponseEntity<UserDto>(userService.createUser(user), HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<UserDto> login(@RequestBody UserDto user) throws FailedLoginException {
        try{
          return   new ResponseEntity<UserDto>(userService.authenticateUser(user), HttpStatus.OK);
        }catch (FailedLoginException ex){
            throw new FailedLoginException("Username/Password is not correct");
        }
    }
}
