package com.stacksimplify.restservices.exceptions;

public class UserExistException extends Exception{

    private static final long serialVersionUID = -4979446186685543171L;

    public UserExistException(String message) {
        super(message);
    }
}
