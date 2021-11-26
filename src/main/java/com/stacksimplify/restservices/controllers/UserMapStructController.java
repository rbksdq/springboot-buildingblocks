package com.stacksimplify.restservices.controllers;


import com.stacksimplify.restservices.dtos.UserMsDto;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.mappers.UserMapper;
import com.stacksimplify.restservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/mapstruct/users")
public class UserMapStructController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public List<UserMsDto> getAllUserDtos(){
        return (List<UserMsDto>) userMapper.userToUserDtos((List<User>) userRepository.findAll());
    }

    //get user  by id
    @GetMapping("/{id}")
    public UserMsDto getUserById(@PathVariable Long id) throws UserNotFoundException {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()){
            throw new UserNotFoundException("User not found in User Repository");
        }
        User user= userOptional.get();
        return userMapper.userToUserMsDto(user);

    }
}
