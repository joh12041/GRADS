package edu.umn.csci5801.model;

import edu.umn.csci5801.model.Enums;

public class User{

    private String id;
    private String firstName;
    private String lastName;
    private Role role;
    private Department department;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setDepartment(edu.umn.csci5801.model.User.Department department) {
        this.department = department;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRole(edu.umn.csci5801.model.User.Role role) {
        this.role = role;
    }

    public edu.umn.csci5801.model.User.Department getDepartment() {
        return department;
    }

    public edu.umn.csci5801.model.User.Role getRole() {
        return role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }
}