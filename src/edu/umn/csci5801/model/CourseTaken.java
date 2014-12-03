package edu.umn.csci5801.model;

/**
 * Created by Justin on 12/2/2014.
 */
public class CourseTaken {
    private Course course;
    private Term term;
    private Grade grade;

    public CourseTaken() {}
    public CourseTaken(Course c, Term t, Grade g) {
        course = c;
        term = t;
        grade = g;
    }

    public Course getCourse() { return course; }
    public Term getTerm() { return term; }
    public Grade getGrade() { return grade; }

    public void setCourse(Course courseIn) { course = courseIn; }
    public void setTerm(Term termIn){ term = termIn; }
    public void setGrade(Grade gradeIn) { grade = gradeIn; }
}
