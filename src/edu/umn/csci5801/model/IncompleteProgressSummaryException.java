package edu.umn.csci5801.model;

import java.lang.Exception;

public class IncompleteProgressSummaryException extends Exception{

    public IncompleteProgressSummaryException(String message, Throwable t){
        super(message, t);
    }

    public IncompleteProgressSummaryException(Throwable t){
        super(t);
    }

    public IncompleteProgressSummaryException(String message){
        super(message);
    }

    public IncompleteProgressSummaryException(){
        super();
    }
}