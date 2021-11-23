package com.stacksimplify.restservices.exceptions;


import java.util.Date;

//create simple custom error details bean
public class CustomErrorDetails {

    private Date timestamp;
    private String message;
    private  String errordetails;
    //fields constructor
    public CustomErrorDetails(Date timestamp, String message, String errordetails) {
        this.timestamp = timestamp;
        this.message = message;
        this.errordetails = errordetails;
    }
    //getters

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getErrordetails() {
        return errordetails;
    }
}
