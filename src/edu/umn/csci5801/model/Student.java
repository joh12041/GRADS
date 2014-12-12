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
 * Student.java - Class containing attributes identifying a student,
 * including student's id, student's first name, and student's last name
 *
 * @author CSCI5801 Fall2014 Group1
 * @version 1.0
 */
public class Student {

    private String id;
    private String firstName;
    private String lastName;

    /**
     * Student() - Constructor for creating a Student object
     */
    public Student() {}

    /**
     * Student() - Constructor for creating a Student object
     *
     * @param i_d - A variable of type String identifying a student's id
     * @param fName - A variable of type String identifying a student's first name
     * @param lName - A variable of type String identifying a student's last name
     */
    public Student(String i_d, String fName, String lName) {
        id = i_d; firstName = fName; lastName = lName;
    }

    /**
     * setId() - Method for setting the id attribute of a Student object
     *
     * @param i_d - A variable of type String identifying a student's id
     */
    public void setId(String i_d){
        id = i_d;
    }

    /**
     * setFirstName() - Method for setting the firstName attribute of a Student object
     *
     * @param fName - A variable of type String identifying a student's first name
     */
    public void setFirstName(String fName) {
        firstName = fName;
    }

    /**
     * setLastName() - Method for setting the lastName attribute of a Student object
     *
     * @param lName - A variable of type String identifying a student's last name
     */
    public void setLastName(String lName) {
        lastName = lName;
    }

    /**
     * getId() - Method for getting the id attribute of a Student object
     *
     * @return id - Return the id attribute
     */
    public String getId() {
        return id;
    }

    /**
     * getFirstName() - Method for getting the firstName attribute of a Student object
     *
     * @return firstName - Return the firstName attribute
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * getLastName() - Method for getting the lastName attribute of a Student object
     *
     * @return lastName - Return the lastName attribute
     */
    public String getLastName() {
        return lastName;
    }

    public boolean sameStudents(Student s) {
        if(!this.id.equals(s.getId())) {
            return false;
        }
        else if(!this.firstName.equals(s.getFirstName())) {
            return false;
        }
        else if(!this.lastName.equals((s.getLastName()))) {
            return false;
        }
        return true;
    }
}
