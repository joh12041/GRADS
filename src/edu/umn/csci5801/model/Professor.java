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
 * Professor.java - Class containing attributes identifying a professor,
 * including professor's department, professor's first name, and professor's last name
 * 
 * @author CSCI5801 Fall2014 Group1
 * @version 1.0
 */
public class Professor {
	
    private Department department;
    private String firstName;
    private String lastName;

    /**
     * Professor() - Constructor for creating a Professor object
     */
    public Professor() {}
    
    /**
     * Professor() - Constructor for creating a Professor object
     * 
     * @param d - A variable of type Department identifying a professor's department
     * @param fn - A variable of type String identifying a professor's first name
     * @param ln - A variable of type String identifying a professor's last name
     */
    public Professor(Department d, String fn, String ln) {
        department = d;
        firstName = fn;
        lastName = ln;
    }

    /**
     * setDepartment() - Method for setting the department attribute of a Professor object
     * 
     * @param d - A variable of type Department identifying a professor's department
     */
    public void setDepartment(Department d) {
    	department = d;
    }
    
    /**
     * setFirstName() - Method for setting the firstName attribute of a Professor object
     * 
     * @param fn - A variable of type String identifying a professor's first name
     */
    public void setFirstName(String fn) {
    	firstName = fn;
    }
    
    /**
     * setLastName() - Method for setting the lastName attribute of a Professor object
     * 
     * @param ln - A variable of type String identifying a professor's last name
     */
    public void setLastName(String ln) {
    	lastName = ln;
    }

    /**
     * getDepartment() - Method for getting the department attribute of a Professor object
     * 
     * @return department - Return the department attribute
     */
    public Department getDepartment() {
    	return department;
    }
    
    /**
     * getFirstName() - Method for getting the firstName attribute of a Professor object
     * 
     * @return firstName - Return the firstName attribute
     */
    public String getFirstName() {
    	return firstName;
    }
    
    /**
     * getLastName() - Method for getting the lastName attribute of a Professor object
     * 
     * @return lastName - Return the lastName attribute
     */
    public String getLastName() {
    	return lastName;
    }
}
