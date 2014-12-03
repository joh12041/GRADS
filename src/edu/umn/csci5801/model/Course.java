package edu.umn.csci5801.model;

public class Course{

    private String name;
    private String id;
    private String numCredits;
    private CourseArea courseArea;

    public void setCourseArea(CourseArea courseArea) {
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

    public CourseArea getCourseArea() {
        return courseArea;
    }

    public String getName() {
        return name;
    }

    public String getNumCredits() {
        return numCredits;
    }
}