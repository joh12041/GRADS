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
 * Term.java - Class containing attributes identifying a term,
 * including term's semester, and professor's term's year
 *
 * @author CSCI5801 Fall2014 Group1
 * @version 1.0
 */
public class Term {

    private Semester semester;
    private int year;

    public Term() {};
    public Term(Semester s, int y) {
        semester = s;
        year = y;
    }
    public Term(String s, int y) {
        year = y;
        if(s.equals("FALL")){
            this.semester = Semester.FALL;
        }
        else if(s.equals("SPRING")) {
            this.semester = Semester.SPRING;
        }
        else if(s.equals("SUMMER")) {
            this.semester = Semester.SUMMER;
        }
    }

    /**
     * setSemester() - Method for setting the semester attribute of a Term object
     *
     * @param sem - A variable of type String identifying a term's semester
     * @throws Exception - If a String which isn't a valid semester is entered
     */
    public void setSemester(String sem) throws Exception {
        if(sem.equals("FALL")){
            this.semester = Semester.FALL;
        }
        else if(sem.equals("SPRING")) {
            this.semester = Semester.SPRING;
        }
        else if(sem.equals("SUMMER")) {
            this.semester = Semester.SUMMER;
        }
        else {
            Exception e = new Exception();
            throw e;
        }
    }

    /**
     * setSemester() - Method for setting the semester attribute of a Term object
     *
     * @param sem - A variable of type Semester identifying a term's semester
     */
    public void setSemester(Semester sem) {
        this.semester = sem;
    }

    /**
     * setYear() - Method for setting the year attribute of a Term object
     *
     * @param yr - A variable of type int identifying a term's year
     */
    public void setYear(int yr) {
        this.year = yr;
    }

    /**
     * getSemester() - Method for getting the semester attribute of a Term object
     *
     * @return semester - Return the semester attribute
     */
    public Semester getSemester() {
        return semester;
    }

    /**
     * getYear() - Method for getting the year attribute of a Term object
     *
     * @return year - Return the year attribute
     */
    public int getYear() {
        return year;
    }

    public boolean sameTerm(Term t) {
        if(this.semester != t.getSemester()) {
            return false;
        }
        else if(this.year != t.getYear()) {
            return false;
        }
        return true;
    }
}
