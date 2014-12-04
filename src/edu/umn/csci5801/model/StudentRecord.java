package edu.umn.csci5801.model;

/**
 * Created by Justin on 12/2/2014.
 */

import java.util.List;

public class StudentRecord {
    private Student student;
    private Department department;
    private Degree degreeSought;
    private Term termBegan;
    private List<Professor> advisors;
    private List<Professor> committee;
    private List<CourseTaken> coursesTaken;
    private List<CompletedMilestone> milestonesSet;
    private List<String> notes;

    public StudentRecord() {}
    public StudentRecord(Student s, Department dep, Role r, Degree deg, Term tb, List<Professor> a, List<Professor> c,
                         List<CourseTaken> ct, List<String> n){
        student = s;
        department = dep;
        degreeSought = deg;
        termBegan = tb;
        advisors = a;
        committee = c;
        coursesTaken = ct;
        notes = n;
    }

    public void setStudent(Student s) { student = s; }
    public void setDepartment(Department d) { department = d; }
    public void setDegreeSought(Degree d) { degreeSought = d; }
    public void setTermBegan(Term t) { termBegan = t; }
    public void setAdvisors(List<Professor> list) { advisors = list; }
    public void addAdvisor(Professor p) { advisors.add(p); }
    public void setCommittee(List<Professor> list) { committee = list; }
    public void addCommitteeMember(Professor p) { committee.add(p); }
    public void setCoursesTaken(List<CourseTaken> list) { coursesTaken = list; }
    public void addCourseTaken(CourseTaken courseTaken) { coursesTaken.add(courseTaken); }
    public void setMilestonesSet(List<CompletedMilestone> list) { milestonesSet = list; }
    public void addMilestonesSet(CompletedMilestone completedMilestone) { milestonesSet.add(completedMilestone); }
    public void setNotes(List<String> list) { notes = list; }
    public void addNote(String s) { notes.add(s); }

    public Student getStudent() { return student; }
    public Department getDepartment() { return department; }
    public Degree getDegreeSought() { return degreeSought; }
    public Term getTermBegan() { return termBegan; }
    public List<Professor> getAdvisors() { return advisors; }
    public List<Professor> getCommittee() { return committee; }
    public List<CourseTaken> getCoursesTaken() { return coursesTaken; }
    public List<CompletedMilestone> getMilestonesSet() { return milestonesSet; }
    public List<String> getNotes() { return notes; }

    public void appendCourses(List<CourseTaken> coursesAppended){
        for(CourseTaken courseTaken : coursesAppended) {
            this.coursesTaken.add(courseTaken);
        }
    }
}
