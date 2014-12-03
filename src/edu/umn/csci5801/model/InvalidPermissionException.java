package edu.umn.csci5801.model;

import java.lang.Exception;

public class InvalidPermissionException extends Exception{

    public InvalidPermissionException(String message, Throwable t){
        super(message, t);
    }

    public InvalidPermissionException(Throwable t){
        super(t);
    }

    public InvalidPermissionException(String message){
        super(message);
    }

    public InvalidPermissionException(){
        super();
    }
}