package edu.umn.csci5801.model;

import java.util.List;

/**
 * Created by Justin on 12/2/2014.
 */
public class ProgressSummary {

    private Student student;
    private Department department;
    private Degree degree;
    private Term termBegan;
    private List<Professor> advisors;
    private List<Professor> committee;
    private List<GradReqCheck> reqCheckResult;
    private List<String> notes;

    //Constructor
    public void ProgressSummary(Student s, Department dep, Degree deg, Term tb,
                                List<Professor> a, List<Professor> c, List<String> n) {
        student = s;
        department = dep;
        degree = deg;
        termBegan = tb;
        advisors = a;
        committee = c;
        notes = n;
    }

    public void checkGradStatus() {
        List<Requirement> requirements;
        GradReqCheck gradReqCheck = new GradReqCheck();
        requirements = gradReqCheck.createReqList(degree);
        gradReqCheck.testReqList();
        reqCheckResult = gradReqCheck.getReqChecks()
    }
}
