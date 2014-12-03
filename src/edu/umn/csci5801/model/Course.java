package edu.umn.csci5801.model;

public class Course{

    public enum CourseArea{
        THEORY_ALGORITHMS, APPLICATIONS, ARCHITECTURE_SYSTEMS_SOFTWARE
    }

    private String name;
    private String id;
    private String numCredits;
    private CourseArea courseArea;

    public void setCourseArea(edu.umn.csci5801.model.Course.CourseArea courseArea) {
        this.courseArea = courseArea;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNumCredits(String numCredits) {
        this.numCredits = numCredits;
    }

    public String getId() {
        return id;
    }

    public edu.umn.csci5801.model.Course.CourseArea getCourseArea() {
        return courseArea;
    }

    public String getName() {
        return name;
    }

    public String getNumCredits() {
        return numCredits;
    }
}