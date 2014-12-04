package edu.umn.csci5801.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 12/2/2014.
 */
public class Requirement {
    private Reqs name;
    private double gpa;
    private List<CourseTaken> courses;
    private int credits;
    private List<CompletedMilestone> milestones;
    private List<String> notes;

    //constructor
    public Requirement(){}
    public Requirement(Reqs _name_) {
        name = _name_;
    }
    public Requirement(Reqs _name_, double _gpa_) {
        name = _name_;
        gpa = _gpa_;
    }
    public Requirement(Reqs _name_, List<CourseTaken> _courses_) {
        name = _name_;
        courses = _courses_;
    }
    public Requirement(Reqs _name_, double _gpa_, List<CourseTaken> _courses_, int _credits_,
                       List<CompletedMilestone> _milestones_, List<String> _notes_) {
        name = _name_;
        gpa = _gpa_;
        courses = _courses_;
        credits = _credits_;
        milestones = _milestones_;
        notes = _notes_;
    }
    public Requirement(Reqs _name_, List<CourseTaken> _courses_, int _credits_,
                       List<String> _notes_) {
        name = _name_;
        courses = _courses_;
        credits = _credits_;
        notes = _notes_;
    }
    public Requirement(Reqs _name_, double _gpa_, List<CourseTaken> _courses_, int _credits_,
                       List<String> _notes_) {
        name = _name_;
        gpa = _gpa_;
        courses = _courses_;
        credits = _credits_;
        notes = _notes_;
    }
    public Requirement(Reqs _name_, List<CompletedMilestone> _milestones_, List<String> _notes_) {
        name = _name_;
        milestones = _milestones_;
        notes = _notes_;
    }

    public void setName(Reqs n) { name = n; }
    public void setGpa(double g_p_a) { gpa = g_p_a; }
    public void setCourses(List<CourseTaken> coursesTaken) { courses = coursesTaken; }
    public void addCourse(CourseTaken ct) { courses.add(ct); }
    public void setCredits(int c) { credits = c; }
    public void setMilestones(List<CompletedMilestone> list) { milestones = list; }
    public void addMilestone(CompletedMilestone cm) { milestones.add(cm); }
    public void setNotes(List<String> list) { notes = list; }
    public void addNote(String note) { notes.add(note); }

    public double getGpa() { return gpa; }
    public int getCredits() { return credits; }
    public List<CompletedMilestone> getMilestones() { return milestones; }
    public List<CourseTaken> getCourses() { return courses; }
    public List<String> getNotes() { return notes; }
    public Reqs getName() { return name; }

    private double gradeToDouble(Grade grade){
        double gradeD = 0.0;
        switch (grade) {
            case A: gradeD = 4.0;
                break;
            case B: gradeD = 3.0;
                break;
            case C: gradeD = 2.0;
                break;
            case D: gradeD = 1.0;
                break;
            case F: gradeD = 0.0;
                break;
            default:
                //throw invalid grade exception or something
        }
        return gradeD;
    }

    public void calculateGpa() {
        double totalGradePoints = 0;
        int totalCourseCredits = 0;
        List<Grade> validGrades = new ArrayList<Grade>();
        validGrades.add(Grade.A);
        validGrades.add(Grade.B);
        validGrades.add(Grade.C);
        validGrades.add(Grade.D);
        validGrades.add(Grade.F);
        for (CourseTaken cT : courses){
            if (validGrades.contains(cT.getGrade())) {
                totalGradePoints = totalGradePoints + (gradeToDouble(cT.getGrade()) * Integer.parseInt(cT.getCourse().getNumCredits()));
                totalCourseCredits = totalCourseCredits + Integer.parseInt(cT.getCourse().getNumCredits());
            }
        }
        gpa = (totalGradePoints / totalCourseCredits);
    }

}
