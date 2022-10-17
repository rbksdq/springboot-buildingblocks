package com.stacksimplify.restservices.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.entities.Views;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(value = "/jsonviews/users")
public class UserJsonViewController {

    @Autowired
    private UserService userService;


    //getUserById external views
    @JsonView(Views.External.class)
    @GetMapping("/external/{id}")
    public Optional<User> getUserById(@PathVariable("id") @Min(1) Long id){
        try {
            return userService.getUserById(id);
        } catch (UserNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    //getUserById internal vies
    @JsonView(Views.Internal.class)
    @GetMapping("/internal/{id}")
    public Optional<User> getUserById2(@PathVariable("id") @Min(1) Long id){
        try {
            return userService.getUserById(id);
        } catch (UserNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
}
