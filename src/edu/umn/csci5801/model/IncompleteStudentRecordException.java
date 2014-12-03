package edu.umn.csci5801.model;

import java.lang.Exception;

public class IncompleteStudentRecordException extends Exception{

    public IncompleteStudentRecordException(String message, Throwable t){
        super(message, t);
    }

    public IncompleteStudentRecordException(Throwable t){
        super(t);
    }

    public IncompleteStudentRecordException(String message){
        super(message);
    }

    public IncompleteStudentRecordException(){
        super();
    }
}