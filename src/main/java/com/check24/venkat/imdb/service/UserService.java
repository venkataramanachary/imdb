package com.check24.venkat.imdb.service;

import com.check24.venkat.imdb.dto.UserDto;

import javax.security.auth.login.FailedLoginException;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto authenticateUser(UserDto userDto) throws FailedLoginException;

}
