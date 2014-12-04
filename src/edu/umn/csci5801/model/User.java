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
 * User.java - Class containing user metadata and permissions,
 * including user id, user first name, user last name, user role, and user department
 *
 * @author CSCI5801 Fall2014 Group1
 * @version 1.0
 */
public class User{

    private String id;
    private String firstName;
    private String lastName;
    private Role role;
    private Department department;

    /**
     * setFirstName() - Method for setting the firstName attribute of a User object
     *
     * @param firstName - A variable of type String identifying a student's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * setLastName() - Method for setting the lastName attribute of a User object
     *
     * @param lastName - A variable of type String identifying a user's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * setId() - Method for setting the id attribute of a User object
     *
     * @param id - A variable of type String identifying a user's id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * setRole() - Method for setting the role attribute of a User object
     *
     * @param role - A variable of type Role identifying a user's role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * setDepartment() - Method for setting the department attribute of a User object
     *
     * @param department - A variable of type Department identifying a user's department
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * getFirstName() - Method for getting the firstName attribute of a User object
     *
     * @return firstName - Return the firstName attribute
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * getLastName() - Method for getting the lastName attribute of a User object
     *
     * @return lastName - Return the lastName attribute
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * getId() - Method for getting the id attribute of a User object
     *
     * @return id - Return the id attribute
     */
    public String getId() {
        return id;
    }

    /**
     * getRole() - Method for getting the role attribute of a Role object
     *
     * @return role - Return the role attribute
     */
    public Role getRole() {
        return role;
    }

    /**
     * getDepartment() - Method for setting the department attribute of a User object
     *
     * @return Department - Return the department attribute
     */
    public Department getDepartment() {
        return department;
    }
}