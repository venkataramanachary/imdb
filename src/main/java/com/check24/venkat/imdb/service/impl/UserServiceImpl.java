package com.check24.venkat.imdb.service.impl;

import com.check24.venkat.imdb.dto.UserDto;
import com.check24.venkat.imdb.entity.User;
import com.check24.venkat.imdb.repository.UserRepository;
import com.check24.venkat.imdb.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.FailedLoginException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        user = userRepository.save(user);
        BeanUtils.copyProperties(user,userDto);
        userDto.setPassword(null);
        return userDto;
    }

    @Override
    public UserDto authenticateUser(UserDto userDto) throws FailedLoginException {
        Optional<User> user = userRepository.findByUserName(userDto.getUsername());
        if(user.isPresent() && user.get().getPassword().equals(userDto.getPassword())){
            userDto.setUserId(user.get().getUserId());
            userDto.setFirstName(user.get().getFirstName());
            userDto.setLastName(user.get().getLastName());
        }else {
            throw new FailedLoginException("username/password is incorrect");
        }
        return userDto;
    }
}
