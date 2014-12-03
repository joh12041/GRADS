package edu.umn.csci5801.model;

import java.lang.Exception;

public class InvalidRequirementException extends Exception{

    public InvalidRequirementException(String message, Throwable t){
        super(message, t);
    }

    public InvalidRequirementException(Throwable t){
        super(t);
    }

    public InvalidRequirementException(String message){
        super(message);
    }

    public InvalidRequirementException(){
        super();
    }
}