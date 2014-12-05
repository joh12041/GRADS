/**
 * Copyright 2014 CSCI5801 Fall2014 Group1
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.umn.csci5801.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Requirement.java - Class that handles the status of a Requirement
 * 
 * @author CSCI5801 Fall2014 Group1
 * @version 1.0
 */
public class Requirement {
    private Reqs name;
    private double gpa;
    private List<CourseTaken> courses;
    private int credits;
    private List<CompletedMilestone> milestones;
    private List<String> notes;

    /**
     * Requirement() - Constructors for creating a Requirement object
     */
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

    /**
     * Methods for setting or adding attributes of a Requirement object
     */
    public void setName(Reqs n) {
    	name = n;
    }
    public void setGpa(double g_p_a) {
    	gpa = g_p_a;
    }
    public void setCourses(List<CourseTaken> coursesTaken) {
    	courses = coursesTaken;
    }
    public void addCourse(CourseTaken ct) {
    	courses.add(ct);
    }
    public void setCredits(int c) {
    	credits = c;
    }
    public void setMilestones(List<CompletedMilestone> list) {
    	milestones = list;
    }
    public void addMilestone(CompletedMilestone cm) {
    	milestones.add(cm);
    }
    public void setNotes(List<String> list) {
    	notes = list;
    }
    public void addNote(String note) {
    	notes.add(note);
    }

    /**
     * Methods for getting attributes of a Requirement object
     */
    public double getGpa() {
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
    public Reqs getName() {
    	return name;
    }

    /**
     * gradeToDouble() - Method for mapping letter grades to numerical grades
     * 
     * @param grade - Input of type Grade which contains a letter grade
     * @return gradeD - Returns a Double containing a numerical value for a grade
     */
    private double gradeToDouble (Grade grade) throws Exception {
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
            	Exception exception = new InvalidGradeException("Exception when converting letter grade to numeric grade");
                throw exception;
        }
        return gradeD;
    }

    /**
     * calculateGpa() - Method for determining the GPA of a set of courses
     */
    public void calculateGpa() throws Exception {
        double totalGradePoints = 0;
        int totalCourseCredits = 0;

        //Only use letter grades
        List<Grade> validGrades = new ArrayList<Grade>();
        validGrades.add(Grade.A);
        validGrades.add(Grade.B);
        validGrades.add(Grade.C);
        validGrades.add(Grade.D);
        validGrades.add(Grade.F);
        for (CourseTaken cT : courses){
            if (validGrades.contains(cT.getGrade())) {
            	try {
            		totalGradePoints = totalGradePoints + (gradeToDouble(cT.getGrade()) * Integer.parseInt(cT.getCourse().getNumCredits()));
            		totalCourseCredits = totalCourseCredits + Integer.parseInt(cT.getCourse().getNumCredits());
            	} catch(InvalidGradeException e) {
            		Exception exception = new InvalidGradeException(e);
                    throw exception;
            	}
            }
        }
        gpa = (totalGradePoints / totalCourseCredits);
    }

}
