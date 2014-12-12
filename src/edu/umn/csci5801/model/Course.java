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
 * Course.java - Class containing attributes identifying a course,
 * including term's name, id, number of credits, and course area
 *
 * @author CSCI5801 Fall2014 Group1
 * @version 1.0
 */
public class Course {

    private String name;
    private String id;
    private String numCredits;
    private CourseArea courseArea;

    /**
     * Course() - Constructor for creating a Course object
     */
    public Course() {}

    /**
     * Course() - Constructor for creating a Course object
     *
     * @param n - A variable of type String identifying a course's name
     * @param i_d - A variable of type String identifying a course's id
     * @param nc - A variable of type String identifying a course's number of credits
     * @param ca - A variable of type CourseArea identifying a course's course area
     */
    public Course(String n, String i_d, String nc, CourseArea ca) {
        name = n;
        id = i_d;
        numCredits = nc;
        courseArea = ca;
    }

    /**
     * Course() - Constructor for creating a Course object
     *
     * @param n - A variable of type String identifying a course's name
     * @param i_d - A variable of type String identifying a course's id
     * @param nc - A variable of type String identifying a course's number of credits
     */

    public Course(String n, String i_d, String nc) {
        name = n;
        id = i_d;
        numCredits = nc;
    }

    /**
     * setName() - Method for setting the name attribute of a Course object
     *
     * @param name - A variable of type String identifying a course's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setId() - Method for setting the id attribute of a Course object
     *
     * @param id - A variable of type String identifying a course's id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * setNumCredits() - Method for setting the numCredits attribute of a Course object
     *
     * @param numCredits - A variable of type String identifying a course's number of credits
     */
    public void setNumCredits(String numCredits) {
        this.numCredits = numCredits;
    }

    /**
     * setCourseArea() - Method for setting the courseArea attribute of a Course object
     *
     * @param courseArea - A variable of type CourseArea identifying a course's course area
     */
    public void setCourseArea(CourseArea courseArea) {
        this.courseArea = courseArea;
    }

    /**
     * getName() - Method for getting the name attribute of a Course object
     *
     * @return name - Return the name attribute
     */
    public String getName() {
        return name;
    }

    /**
     * getId() - Method for getting the id attribute of a Course object
     *
     * @return id - Return the id attribute
     */
    public String getId() {
        return id;
    }

    /**
     * getNumCredits() - Method for getting the numCredits attribute of a Course object
     *
     * @return numCredits - Return the numCredits attribute
     */
    public String getNumCredits() {
        return numCredits;
    }

    /**
     * getCourseArea() - Method for getting the courseArea attribute of a Course object
     *
     * @return courseArea - Return the courseArea attribute
     */
    public CourseArea getCourseArea() {
        return courseArea;
    }

    public boolean compareCourse(Course c) {
        if(!this.id.equals(c.getId())) {
            return false;
        }
        if(this.courseArea != c.getCourseArea()) {
            return false;
        }
        if(!this.numCredits.equals(c.getNumCredits())) {
            return false;
        }
        if(!this.name.equals(c.getName())) {
            return false;
        }
        return true;
    }
}
