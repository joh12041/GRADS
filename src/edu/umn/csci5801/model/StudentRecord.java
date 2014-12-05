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

package edu.umn.csci5801.model;/**

 */

import java.util.List;

/**
 * StudentRecord.java - Class that handles the management of a student record
 *
 * @author CSCI5801 Fall2014 Group1
 * @version 1.0
 */
public class StudentRecord {

    private Student student;
    private Department department;
    private Degree degreeSought;
    private Term termBegan;
    private List<Professor> advisors;
    private List<Professor> committee;
    private List<CourseTaken> coursesTaken;
    private List<CompletedMilestone> milestonesSet;
    private List<String> notes;

    /**
     * StudentRecord() - Constructor for creating a StudentRecord object
     */
    public StudentRecord() {}

    /**
     * StudentRecord() - Constructor for creating a StudentRecord object
     *
     * @param s - A variable of type Student identifying the student of the StudentRecord object
     * @param dep - A variable of type Department identifying the student's department of the StudentRecord object
     * @param r - A variable of type Role identifying the role of the student accessing the StudentRecord object
     * @param deg - A variable of type Degree identifying the student's degree of the StudentRecord object
     * @param tb - A variable of type Term identifying the term the student began of the StudentRecord object
     * @param a - A variable of type List<Professor> identifying the student's advisor of the StudentRecord object
     * @param c - A variable of type List<Professor> identifying the student's committee of the StudentRecord object
     * @param ct - A variable of type List<CourseTaken> identifying the student's courses taken of the StudentRecord object
     * @param n - A variable of type List<String> identifying the notes appended to the student of the StudentRecord object
     */
    public StudentRecord(Student s, Department dep, Role r, Degree deg, Term tb, List<Professor> a, List<Professor> c,
                         List<CourseTaken> ct, List<String> n){
        student = s;
        department = dep;
        degreeSought = deg;
        termBegan = tb;
        advisors = a;
        committee = c;
        coursesTaken = ct;
        notes = n;
    }

    /**
     * setStudent() - Method for setting the student attribute of a StudentRecord object
     *
     * @param s - A variable of type Student identifying a student's name
     */
    public void setStudent(Student s) {
        student = s;
    }

    /**
     * setDepartment() - Method for setting the department attribute of a StudentRecord object
     *
     * @param d - A variable of type Department identifying a student's department
     */
    public void setDepartment(Department d) {
        department = d;
    }

    /**
     * setDegreeSought() - Method for setting the degreeSought attribute of a StudentRecord object
     *
     * @param d - A variable of type Degree identifying a student's degree sought
     */
    public void setDegreeSought(Degree d) {
        degreeSought = d;
    }

    /**
     * setTermBegan() - Method for setting the termBegan attribute of a StudentRecord object
     *
     * @param t - A variable of type Term identifying a student's term began
     */
    public void setTermBegan(Term t) {
        termBegan = t;
    }

    /**
     * setAdvisors() - Method for setting the advisors attribute of a StudentRecord object
     *
     * @param list - A variable of type List<Professors> identifying a student's advisors
     */
    public void setAdvisors(List<Professor> list) {
        advisors = list;
    }

    /**
     * addAdvisors() - Method for adding to the advisors attribute of a StudentRecord object
     *
     * @param p - A variable of type Professor identifying a student's new advisor
     */
    public void addAdvisor(Professor p) {
        advisors.add(p);
    }

    /**
     * setAdvisor() - Method for setting the committee attribute of a StudentRecord object
     *
     * @param list - A variable of type List<Professors> identifying a student's committee members
     */
    public void setCommittee(List<Professor> list) {
        committee = list;
    }

    /**
     * addCommitteeMember() - Method for adding to the committee attribute of a StudentRecord object
     *
     * @param p - A variable of type Professor identifying a student's new committee members
     */
    public void addCommitteeMember(Professor p) {
        committee.add(p);
    }

    /**
     * setCoursesTaken() - Method for setting the coursesTaken attribute of a StudentRecord object
     *
     * @param list - A variable of type List<CourseTaken> identifying a student's courses taken
     */
    public void setCoursesTaken(List<CourseTaken> list) {
        coursesTaken = list;
    }

    /**
     * addCourseTaken() - Method for adding a course taken to the coursesTaken attribute of a StudentRecord object
     *
     * @param courseTaken - A variable of type CourseTaken identifying a student's new taken course
     */
    public void addCourseTaken(CourseTaken courseTaken) {
        coursesTaken.add(courseTaken);
    }

    /**
     * setMilestonesSet() - Method for setting the milestonesSet attribute of a StudentRecord object
     *
     * @param list - A variable of type List<CompletedMilestone> identifying a student's completed milestones
     */
    public void setMilestonesSet(List<CompletedMilestone> list) {
        milestonesSet = list;
    }

    /**
     * addMilestonesSet() - Method for setting the milestonesSet attribute of a StudentRecord object
     *
     * @param completedMilestone - A variable of type CompletedMilestone identifying a student's completed milestones
     */
    public void addMilestonesSet(CompletedMilestone completedMilestone) {
        milestonesSet.add(completedMilestone);
    }

    public void setNotes(List<String> list) {
        notes = list;
    }

    public void addNote(String s) {
        notes.add(s);
    }

    /**
     * Methods which return the specified attribute from the StudentRecord object
     */
    public Student getStudent() { return student; }
    public Department getDepartment() { return department; }
    public Degree getDegreeSought() { return degreeSought; }
    public Term getTermBegan() { return termBegan; }
    public List<Professor> getAdvisors() { return advisors; }
    public List<Professor> getCommittee() { return committee; }
    public List<CourseTaken> getCoursesTaken() { return coursesTaken; }
    public List<CompletedMilestone> getMilestonesSet() { return milestonesSet; }
    public List<String> getNotes() { return notes; }

    public void appendCourses(List<CourseTaken> coursesAppended){
        if(coursesAppended == null) return;
        for(CourseTaken courseTaken : coursesAppended) {
            this.coursesTaken.add(courseTaken);
        }
    }
}
