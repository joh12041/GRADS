package edu.umn.csci5801.model;

import java.lang.Exception;

public class InvalidMilestoneException extends Exception{

    public InvalidMilestoneException(String message, Throwable t){
        super(message, t);
    }

    public InvalidMilestoneException(Throwable t){
        super(t);
    }

    public InvalidMilestoneException(String message){
        super(message);
    }

    public InvalidMilestoneException(){
        super();
    }
}