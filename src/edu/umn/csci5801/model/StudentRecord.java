package edu.umn.csci5801.model;

import java.util.List;

/**
 * Created by Justin on 12/2/2014.
 */
public class StudentRecord {

    private Student student;
    private Department department;
    private Role role;
    private Degree degreeSought;
    private Term termBegan;
    private List<Professor> advisor;
    private List<Professor> committee;
    private List<CourseTaken> coursesTaken;
    private List<CompletedMilestone> milestonesSet;
    private List<String> notes;

    public Degree getDegreeSought() {
        return degreeSought;
    }

    public Department getDepartment() {
        return department;
    }

    public List<Professor> getAdvisor() {
        return advisor;
    }

    public List<Professor> getCommittee() {
        return committee;
    }

    public List<String> getNotes() {
        return notes;
    }

    public Role getRole() {
        return role;
    }

    public Student getStudent() {
        return student;
    }

    public Term getTermBegan() {
        return termBegan;
    }

    public List<CourseTaken> getCoursesTaken() {
        return coursesTaken;
    }
//
    public List<CompletedMilestone> getMilestonesSet() {
        return milestonesSet;
    }

//    public ProgressSummary checkProgressSummary(Degree degree, List<CourseTaken> coursesTaken){
//
//        return progress;
//    }
//
    public void appendCourses(List<CourseTaken> coursesAppended){
        this.coursesTaken = coursesAppended;

    }

}
