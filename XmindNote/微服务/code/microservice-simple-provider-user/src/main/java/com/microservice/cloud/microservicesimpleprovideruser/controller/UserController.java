package com.microservice.cloud.microservicesimpleprovideruser.controller;

import com.microservice.cloud.microservicesimpleprovideruser.entity.User;
import com.microservice.cloud.microservicesimpleprovideruser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id){
        User usera = userRepository.getOne(id);
        return usera;
    }
}
