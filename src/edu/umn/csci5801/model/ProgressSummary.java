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

import java.util.List;

/**
 * ProgressSummary.java - Class that handles the creation of a progress summary
 *
 * @author CSCI5801 Fall2014 Group1
 * @version 1.0
 */
public class ProgressSummary {

    private Student student;
    private Department department;
    private Degree degree;
    private Term termBegan;
    private List<Professor> advisors;
    private List<Professor> committee;
    private List<GradReqCheck> requirementCheckResults;
    private List<String> notes;
    private List<CourseTaken> coursesTaken;

    /**
     * ProgressSummary() - Constructors for creating a ProgressSummary object
     */
    public ProgressSummary() {}
    public ProgressSummary(Student s, Department dep, Degree deg, Term tb,
                           List<Professor> a, List<Professor> c, List<String> n, List<CourseTaken> ct) {
        student = s;
        department = dep;
        degree = deg;
        termBegan = tb;
        advisors = a;
        committee = c;
        notes = n;
        coursesTaken = ct;
    }

    /**
     * checkGradStatus() - Method for checking how close a student is to graduating
     *
     * @param completedMilestonesList - Input of type List<CompletedMilestone> which contains a student's completed milestones
     */
    public void checkGradStatus(List<CompletedMilestone> completedMilestonesList) throws Exception {
        GradRequirements gradRequirements = new GradRequirements(degree);
        try {
            gradRequirements.testReqList(coursesTaken, completedMilestonesList);
        } catch(Exception e) {
            Exception exception = new InvalidRequirementException("Exception when checking courses against milestones in checkGradStatus", e);
            throw exception;
        }
        try {
            requirementCheckResults = gradRequirements.getReqChecks();
        } catch(Exception e) {
            Exception exception = new InvalidRequirementException("Exception when checking completed requirements against graduation requirements in checkGradStatus", e);
            throw exception;
        }
    }

    /**
     * Methods for getting attributes of a ProgressSummary object
     */
    public List<GradReqCheck> getRequirementCheckResults() {
        return requirementCheckResults;
    }

    public List<Professor> getCommittee() {
        return committee;
    }

    public Department getDepartment() {
        return department;
    }

    public List<String> getNotes() {
        return notes;
    }

    public List<CourseTaken> getCoursesTaken() {
        return coursesTaken;
    }

    public Degree getDegree() {
        return degree;
    }

    public Student getStudent() {
        return student;
    }

    public Term getTermBegan() {
        return termBegan;
    }

    public List<Professor> getAdvisors() {
        return advisors;
    }
}
