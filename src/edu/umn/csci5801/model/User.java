package edu.umn.csci5801.model;

public class User{

    private String id;
    private String firstName;
    private String lastName;
    private Role role;
    private Department department;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Department getDepartment() {
        return department;
    }

    public Role getRole() {
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