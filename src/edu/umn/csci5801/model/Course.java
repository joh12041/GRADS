package edu.umn.csci5801.model;

/**
 * Created by Justin on 12/2/2014.
 */
public class Course {

    private String name;
    private String id;
    private String numCredits;
    private CourseArea courseArea;

    public Course() {}
    public Course(String n, String i_d, String nc, CourseArea ca) {
        name = n;
        id = i_d;
        numCredits = nc;
        courseArea = ca;
    }

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
    public String getNumCredits() { return numCredits; }
}
