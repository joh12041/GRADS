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

/**
 * CourseTaken.java - Class containing attributes identifying a taken course,
 * including the taken course itself, taken course's term, and taken course's grade
 * 
 * @author CSCI5801 Fall2014 Group1
 * @version 1.0
 */
public class CourseTaken {
	
    private Course course;
    private Term term;
    private Grade grade;

    /**
     * CourseTaken() - Constructor for creating a CourseTaken object
     */
    public CourseTaken() {}
    
    /**
     * CourseTaken() - Constructor for creating a Course object
     * 
     * @param c - A variable of type Course identifying a taken course's course information
     * @param t - A variable of type Term identifying a taken course's term
     * @param g - A variable of type Grade identifying a taken course's grade
     */
    public CourseTaken(Course c, Term t, Grade g) {
        course = c;
        term = t;
        grade = g;
    }

    /**
     * setCourse() - Method for setting the course attribute of a CourseTaken object
     * 
     * @param courseIn - A variable of type Course identifying a taken course's name
     */
    public void setCourse(Course courseIn) {
    	course = courseIn;
    }
    
    /**
     * setTerm() - Method for setting the term attribute of a CourseTaken object
     * 
     * @param termIn - A variable of type Term identifying a taken course's term
     */
    public void setTerm(Term termIn){
    	term = termIn;
    }
    
    /**
     * setGrade() - Method for setting the grade attribute of a CourseTaken object
     * 
     * @param gradeIn - A variable of type Grade identifying a taken course's grade
     */
    public void setGrade(Grade gradeIn) {
    	grade = gradeIn;
    }

    /**
     * getCourse() - Method for getting the course attribute of a CourseTaken object
     * 
     * @return course - Return the course attribute
     */
    public Course getCourse() {
    	return course;
    }
    
    /**
     * getTerm() - Method for getting the term attribute of a CourseTaken object
     * 
     * @return term - Return the term attribute
     */
    public Term getTerm() {
    	return term;
    }
    
    /**
     * getGrade() - Method for getting the grade attribute of a CourseTaken object
     * 
     * @return grade - Return the grade attribute
     */
    public Grade getGrade() {
    	return grade;
    }
}
