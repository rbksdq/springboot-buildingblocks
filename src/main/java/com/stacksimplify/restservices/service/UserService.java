package com.stacksimplify.restservices.service;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserExistException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
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
    public User createUser(User user)throws UserExistException {
        //check if user exists using username else throw UserExistException
        User existingUser= userRepository.findByUsername(user.getUsername());
        if(existingUser != null){
            throw new UserExistException("user already exists in repository");
        }
        return userRepository.save(user);
    }

    //getUserById method optional returns even null values
    public Optional<User> getUserById(Long id)throws UserNotFoundException {
        Optional<User> user= userRepository.findById(id);
        if (!user.isPresent()){
            throw new UserNotFoundException("User not found in User Repository");
        }
        return  user;
    }

    //user updateUserById
    public User updateUserById(Long id, User user)throws UserNotFoundException {
        Optional<User> optionalUser= userRepository.findById(id);
        if (!optionalUser.isPresent()){
            throw new UserNotFoundException("User not found in User Repository, provide correct id");
        }
        user.setId(id);
        return  userRepository.save(user);
    }

    //deleteUserById
    public void deleteUserById(Long id)throws UserNotFoundException{
        Optional<User> optionalUser= userRepository.findById(id);
        if(!optionalUser.isPresent()){
            throw new UserNotFoundException("User not found in User Repository, provide correct id");
        }else
            userRepository.deleteById(id);

    }

    //getUserByUserName method
    public  User getUserByUsername(String username){

        return userRepository.findByUsername(username);
    }



}
