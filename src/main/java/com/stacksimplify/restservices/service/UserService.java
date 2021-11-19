package com.stacksimplify.restservices.service;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//service
@Service
public class UserService {

    //autowire the UserRepository
    @Autowired
    private UserRepository userRepository;

    //getALLUser methods
    public List<User> getALLUsers(){

        return userRepository.findAll();
    }

    //createUser method
    public User createUser(User user){

        return userRepository.save(user);
    }

    //getUserById method optional returns even null values
    public Optional<User> getUserById(Long id){
        Optional<User> user= userRepository.findById(id);
        return  user;
    }

    //user updateUserById
    public User updateUserById(Long id, User user){
        user.setId(id);
        return  userRepository.save(user);
    }

    //deleteUserById
    public void deleteUserById(Long id){
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
        }
    }

    //getUserByUserName method
    public  User getUserByUsername(String username){

        return userRepository.findByUsername(username);
    }



}
