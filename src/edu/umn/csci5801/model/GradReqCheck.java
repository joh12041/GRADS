package edu.umn.csci5801.model;

import java.util.List;

/**
 * Created by Justin on 12/2/2014.
 */
public class GradReqCheck {
    private Reqs reqName;
    private boolean result;
    private Requirement details;

    public GradReqCheck() {}
    public GradReqCheck(Reqs n) {
        reqName = n;
    }

    public void setReqName(Reqs n) { reqName = n; }
    public void setResult(boolean ic) { result = ic; }
    public void setDetails(Requirement r) { details = r; }

    public Reqs getReqName() { return reqName; }
    public boolean getResult() { return result; }
    public Requirement getDetails() { return details; }

    public void testReq(Requirement requirement, List<CourseTaken> courseTakenList, List<CompletedMilestone> completedMilestoneList) {
        //DETERMINE WHETHER REQUIREMENT PASSED IN IS MET IN COURSETAKENLIST AND COMPLETEDMILESTONES
        //TODO: Logic for checking any given requirement
        switch (requirement.getName()) {
            //TODO: Fill in all the different case statements (one for each possible requirement name
            case BREADTH_REQUIREMENT_MS:
                break;
            case BREADTH_REQUIREMENT_PHD:
                break;
            case THESIS_PHD:
                break;
            case THESIS_MS:
                break;
            case PLAN_B_PROJECT:
                break;
            case COLLOQUIUM:
                break;
            case OUT_OF_DEPARTMENT:
                break;
            case PHD_LEVEL_COURSES:
                break;
            case PHD_LEVEL_COURSES_PLANC:
                break;
            case INTRO_TO_RESEARCH:
                break;
            case TOTAL_CREDITS:
                break;
            case COURSE_CREDITS:
                break;
            case OVERALL_GPA_PHD:
                break;
            case IN_PROGRAM_GPA_PHD:
                break;
            case OVERALL_GPA_MS:
                break;
            case IN_PROGRAM_GPA_MS:
                break;
            case MILESTONES_PHD:
                break;
            case MILESTONES_MS_A:
                break;
            case MILESTONES_MS_B:
                break;
            case MILESTONES_MS_C:
                break;
            default:
                break;
        }
    }
}
