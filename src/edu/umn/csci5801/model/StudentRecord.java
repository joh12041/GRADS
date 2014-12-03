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
