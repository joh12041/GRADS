package edu.umn.csci5801.model;

/**
 * Created by Justin on 12/2/2014.
 */
public class GradReqCheck {
    private String reqName;
    private boolean result;
    private Requirement details;

    public GradReqCheck() {}
    public GradReqCheck(String n, boolean ic, Requirement r) {
        reqName = n;
        result = ic;
        details = r;
    }

    public void setReqName(String n) { reqName = n; }
    public void setResult(boolean ic) { result = ic; }
    public void setDetails(Requirement r) { details = r; }

    public String getReqName() { return reqName; }
    public boolean getResult() { return result; }
    public Requirement getDetails() { return details; }

    public Requirement buildReq(Requirement requirement) {
        return requirement;
    }
    public void testReq(Requirement requirement) {
        return;
    }
}
