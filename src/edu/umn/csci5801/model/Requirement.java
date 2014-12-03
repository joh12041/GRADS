package edu.umn.csci5801.model;

import java.util.List;

/**
 * Created by Justin on 12/2/2014.
 */
public class Requirement {
    private String name;
    private float gpa;
    private List<CourseTaken> courses;
    private int credits;
    private List<CompletedMilestone> milestones;
    private List<String> notes;

    //constructor
    public Requirement(){

    }

    public float getGpa() {
        return gpa;
    }

    public int getCredits() {
        return credits;
    }

    public List<CompletedMilestone> getMilestones() {
        return milestones;
    }

    public List<CourseTaken> getCourses() {
        return courses;
    }

    public List<String> getNotes() {
        return notes;
    }

    public String getName() {
        return name;
    }
}
