package edu.umn.csci5801.model;

import java.lang.Exception;

public class InvalidCourseException extends Exception{

    public InvalidCourseException(String message, Throwable t){
        super(message, t);
    }

    public InvalidCourseException(Throwable t){
        super(t);
    }

    public InvalidCourseException(String message){
        super(message);
    }

    public InvalidCourseException(){
        super();
    }
}
