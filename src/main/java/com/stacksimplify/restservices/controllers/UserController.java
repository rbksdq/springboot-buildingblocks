package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public User createUser(@RequestBody User user){

        return userService.createUser(user);
    }

    //getUserById
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id){
      return userService.getUserById(id);
    }
    //updateUserById
    @PutMapping("/users/{id}")
    public User updateUserById(@PathVariable("id") Long id, @RequestBody User user){
        return userService.updateUserById(id, user);
    }

    //deleteUserById
    @DeleteMapping("/users/{id}")
    public void  User (@PathVariable("id") Long id){
        userService.deleteUserById(id);
    }

    //getuserbyusername
    @GetMapping("/users/byusername/{username}")
    public User getUserByUsername(@PathVariable("username") String username){
        return userService.getUserByUsername(username);
    }
}
