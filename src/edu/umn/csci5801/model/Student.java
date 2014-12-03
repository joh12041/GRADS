package edu.umn.csci5801.model;

/**
 * Created by Justin on 12/2/2014.
 */
public class Student {
    private String id;
    private String firstName;
    private String lastName;

    public Student() {}
    public Student(String i_d, String fName, String lName) {
        id = i_d; firstName = fName; lastName = lName;
    }

    public void setId(String i_d){ id = i_d; }
    public void setFirstName(String fName) { firstName = fName; }
    public void setLastName(String lName) { lastName = lName; }

    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}
