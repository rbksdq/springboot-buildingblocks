package com.stacksimplify.restservices.exceptions;

public class UserNotFoundException extends Exception{

    //usernotfound exception class creation
    private static final long serialVersionUID = 1L;

    //default constructor using super class
    public UserNotFoundException(String message) {

        super(message);
    }

}
