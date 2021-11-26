package com.stacksimplify.restservices.controllers;


import com.stacksimplify.restservices.dtos.UserMmDto;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNameNotFoundException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.Optional;

@RestController
@RequestMapping(value = "modelmapper/users")
public class UserModelMapperController {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    //getUserById
    @GetMapping("/{id}")
    public UserMmDto getUserById(@PathVariable("id") @Min(1) Long id) throws UserNameNotFoundException, UserNotFoundException {

        Optional<User> userOptional = userService.getUserById(id);
        if (!userOptional.isPresent()) {
            throw new UserNameNotFoundException("User not found");

        }
        User user = userOptional.get();
        UserMmDto userDto = modelMapper.map(user, UserMmDto.class);
        return userDto;
    }
}