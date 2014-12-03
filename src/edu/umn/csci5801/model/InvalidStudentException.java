package edu.umn.csci5801.model;

import java.lang.Exception;

public class InvalidStudentException extends Exception{

    public InvalidStudentException(String message, Throwable t){
        super(message, t);
    }

    public InvalidStudentException(Throwable t){
        super(t);
    }

    public InvalidStudentException(String message){
        super(message);
    }

    public InvalidStudentException(){
        super();
    }
}