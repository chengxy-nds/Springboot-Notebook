package com.springboot101.service;

import com.springboot101.po.User;
import com.springboot101.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserService {

    @Resource
    private UserRepository userRepository;


    public void insertUser(User user){

        userRepository.save(user);
    }
}
