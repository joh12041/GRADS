package edu.umn.CSCI5801;

public class User{

    public enum Role{
        STUDENT, GRADUATE_PROGRAM_COORDINATOR
    }

    public enum Department{
        COMPUTER_SCIENCE, MATH
    }

    private String id;
    private String firstName;
    private String lastName;
    private Role role;
    private Department department;
}