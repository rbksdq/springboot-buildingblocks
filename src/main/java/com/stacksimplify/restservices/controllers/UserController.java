package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserExistException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //getALLUsers method
    @GetMapping("/users")
    public List<User> getALLUsers(){

        return userService.getALLUsers();
    }
    //create user method
    //@RequestBody annotation
    //@PostMapping annotation
    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder builder) {
        try{
            userService.createUser(user);
            HttpHeaders headers= new HttpHeaders();
            headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }catch (UserExistException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }


    }

    //getUserById
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id){
        try {
            return userService.getUserById(id);
        } catch (UserNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    //updateUserById
    @PutMapping("/users/{id}")
    public User updateUserById(@PathVariable("id") Long id, @RequestBody User user){
       try{
           return userService.updateUserById(id, user);
       } catch (UserNotFoundException ex){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
       }
    }

    //deleteUserById
    @DeleteMapping("/users/{id}")
    public void  User (@PathVariable("id") Long id){
       try {
           userService.deleteUserById(id);
       }catch (UserNotFoundException ex){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
       }
    }

    //getuserbyusername
    @GetMapping("/users/byusername/{username}")
    public User getUserByUsername(@PathVariable("username") String username){
        return userService.getUserByUsername(username);
    }
}
