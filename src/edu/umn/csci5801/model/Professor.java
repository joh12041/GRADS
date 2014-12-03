package edu.umn.csci5801.model;

/**
 * Created by Justin on 12/2/2014.
 */
public class Professor {
    private Department department;
    private String firstName;
    private String lastName;

    public Professor() {}
    public Professor(Department d, String fn, String ln) {
        department = d;
        firstName = fn;
        lastName = ln;
    }

    public void setDepartment(Department d) { department = d; }
    public void setFirstName(String fn) { firstName = fn; }
    public void setLastName(String ln) { lastName = ln; }

    public Department getDepartment() { return department; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}
