package edu.umn.csci5801.model;

import java.lang.Exception;

public class InvalidTermException extends Exception{

    public InvalidTermException(String message, Throwable t){
        super(message, t);
    }

    public InvalidTermException(Throwable t){
        super(t);
    }

    public InvalidTermException(String message){
        super(message);
    }

    public InvalidTermException(){
        super();
    }
}