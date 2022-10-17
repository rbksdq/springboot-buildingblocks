package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserExistException;
import com.stacksimplify.restservices.exceptions.UserNameNotFoundException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;


@Api(tags = "User Management RESTful Services", value = "UserController",description = "Controller For User Management Services")
@RestController
@Validated
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;



    //getALLUsers method
    @ApiOperation(value = "Retrieve list of Users")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) //swagger (response)
    public List<User> getALLUsers(){

        return userService.getALLUsers();
    }


    //create user method
    //@RequestBody annotation
    //@PostMapping annotation
    @ApiOperation(value = "Creates a new user")
    @PostMapping
    public ResponseEntity<User> createUser(@ApiParam("User information for a new user to be created") @Valid @RequestBody User user, UriComponentsBuilder builder) {
        try{
            userService.createUser(user);
            HttpHeaders headers= new HttpHeaders();
            headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
            return new ResponseEntity<User>(headers, HttpStatus.CREATED);
        }catch (UserExistException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }



    //getUserById
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") @Min(1) Long id){
        try {
            Optional<User> userOptional= userService.getUserById(id);
            return userOptional.get();
        } catch (UserNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }



    //updateUserById
    @PutMapping("/{id}")
    public User updateUserById(@PathVariable("id") Long id, @RequestBody User user){
       try{
           return userService.updateUserById(id, user);
       } catch (UserNotFoundException ex){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
       }
    }



    //deleteUserById
    @DeleteMapping("/{id}")
    public void  User (@PathVariable("id") Long id){
       try {
           userService.deleteUserById(id);
       }catch (UserNotFoundException ex){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
       }
    }



    //getuserbyusername
    @GetMapping("/byusername/{username}")
    public User getUserByUsername(@PathVariable("username") String username) throws UserNotFoundException, UserNameNotFoundException {
        User user = userService.getUserByUsername(username);
        if(user==null)
            throw new UserNameNotFoundException("UserName: '"+ username+"' not found in user repository");
            return user;
    }

}
