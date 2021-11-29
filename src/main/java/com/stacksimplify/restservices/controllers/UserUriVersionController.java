package com.stacksimplify.restservices.controllers;


import com.stacksimplify.restservices.dtos.UserDtoV1;
import com.stacksimplify.restservices.dtos.UserDtoV2;
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
@RequestMapping(value = "uriversion/users")
public class UserUriVersionController {

    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    //getUserById for VERSION-1
    @GetMapping({"/v1.0/{id}","/v1.1/{id}"})
    public UserDtoV1 getUserById1(@PathVariable("id") @Min(1) Long id) throws UserNameNotFoundException, UserNotFoundException {

        Optional<User> userOptional = userService.getUserById(id);
        if (!userOptional.isPresent()) {
            throw new UserNameNotFoundException("User not found");

        }
        User user = userOptional.get();
        UserDtoV1 userDtoV1 = modelMapper.map(user, UserDtoV1.class);
        return userDtoV1;
    }


    //getUserById for VERSION-2
    @GetMapping("/v2.0/{id}")
    public UserDtoV2 getUserById2(@PathVariable("id") @Min(1) Long id) throws UserNameNotFoundException, UserNotFoundException {

        Optional<User> userOptional = userService.getUserById(id);
        if (!userOptional.isPresent()) {
            throw new UserNameNotFoundException("User not found");

        }
        User user = userOptional.get();
        UserDtoV2 userDtoV2 = modelMapper.map(user, UserDtoV2.class);
        return userDtoV2;
    }
}
