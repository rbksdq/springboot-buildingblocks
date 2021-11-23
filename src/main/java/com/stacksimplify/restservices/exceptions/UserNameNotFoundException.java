package com.stacksimplify.restservices.exceptions;

public class UserNameNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;

    //super class constructor
    public UserNameNotFoundException(String message) {
        super(message);
    }
}
