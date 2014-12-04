package edu.umn.csci5801.model;

/**
 * Created by Justin on 12/2/2014.
 */
public class Term {
    private Semester semester;
    private int year;

    public void setSemester(String sem) throws Exception {
        if(sem.equals("FALL")){
            this.semester = Semester.FALL;
        }
        else if(sem.equals("SPRING")) {
            this.semester = Semester.SPRING;
        }
        else if(sem.equals("SUMMER")) {
            this.semester = Semester.SUMMER;
        }
        else {
            Exception e = new Exception();
            throw e;
        }
    }
    public void setSemester(Semester sem) { this.semester = sem;  }
    public void setYear(int yr) { this.year = yr; }

    public int getYear() { return year; }
    public Semester getSemester() { return semester; }
}
