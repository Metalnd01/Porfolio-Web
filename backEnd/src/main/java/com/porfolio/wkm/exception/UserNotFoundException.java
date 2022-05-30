package com.porfolio.wkm.exception;

public class UserNotFoundException extends RuntimeException{
    
    public UserNotFoundException(String message){
        super(message);
    }    
}
