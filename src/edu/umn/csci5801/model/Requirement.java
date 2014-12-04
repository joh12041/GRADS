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
    public Requirement(){}
    public Requirement(String _name_, float _gpa_, List<CourseTaken> _courses_, int _credits_,
                       List<CompletedMilestone> _milestones_, List<String> _notes_) {
        name = _name_;
        gpa = _gpa_;
        courses = _courses_;
        credits = _credits_;
        milestones = _milestones_;
        notes = _notes_;
    }
    public Requirement(String _name_, List<CourseTaken> _courses_, int _credits_,
                       List<String> _notes_) {
        name = _name_;
        courses = _courses_;
        credits = _credits_;
        notes = _notes_;
    }
    public Requirement(String _name_, float _gpa_, List<CourseTaken> _courses_, int _credits_,
                       List<String> _notes_) {
        name = _name_;
        gpa = _gpa_;
        courses = _courses_;
        credits = _credits_;
        notes = _notes_;
    }
    public Requirement(String _name_, List<CompletedMilestone> _milestones_, List<String> _notes_) {
        name = _name_;
        milestones = _milestones_;
        notes = _notes_;
    }

    public void setName(String n) { name = n; }
    public void setGpa(float g_p_a) { gpa = g_p_a; }
    public void setCourses(List<CourseTaken> coursesTaken) { courses = coursesTaken; }
    public void addCourse(CourseTaken ct) { courses.add(ct); }
    public void setCredits(int c) { credits = c; }
    public void setMilestones(List<CompletedMilestone> list) { milestones = list; }
    public void addMilestone(CompletedMilestone cm) { milestones.add(cm); }
    public void setNotes(List<String> list) { notes = list; }
    public void addNote(String note) { notes.add(note); }

    public float getGpa() { return gpa; }
    public int getCredits() { return credits; }
    public List<CompletedMilestone> getMilestones() { return milestones; }
    public List<CourseTaken> getCourses() { return courses; }
    public List<String> getNotes() { return notes; }
    public String getName() { return name; }

    private float gradeToFloat(Grade grade){
        float gradef = new float;
        switch (grade) {
            case A: return 4.0f;
        }
    }

    public void calculateGpa() {

    }

}
