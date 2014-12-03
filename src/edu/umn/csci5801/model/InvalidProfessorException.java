package edu.umn.csci5801.model;

import java.lang.Exception;

public class InvalidProfessorException extends Exception{

    public InvalidProfessorException(String message, Throwable t){
        super(message, t);
    }

    public InvalidProfessorException(Throwable t){
        super(t);
    }

    public InvalidProfessorException(String message){
        super(message);
    }

    public InvalidProfessorException(){
        super();
    }
}