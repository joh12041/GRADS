package edu.umn.csci5801.model;

import java.util.List;

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

    public void testReq(Requirement requirement, List<CourseTaken> courseTakenList, List<CompletedMilestone> completedMilestoneList) {
        //DETERMINE WHETHER REQUIREMENT PASSED IN IS MET IN COURSETAKENLIST AND COMPLETEDMILESTONES
        //TODO: Logic for checking any given requirement
        switch (requirement.getName()) {
            //TODO: Fill in all the different case statements (one for each possible requirement name
            case "BREADTH_REQUIREMENT_MS":
        }
    }
}
