package edu.umn.csci5801.model;

/**
 * Created by Justin on 12/2/2014.
 */
public class CompletedMilestone {
    private Milestone milestone;
    private Term term;

    public void setMilestone(Milestone milestone){
        this.milestone = milestone;
    }
    public void setTerm(Term term){
        this.term = term;
    }

    public Milestone getMilestone(){
        return milestone;
    }

    public Term getTerm(){
        return term;
    }
}
