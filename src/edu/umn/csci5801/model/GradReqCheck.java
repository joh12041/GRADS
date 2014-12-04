package edu.umn.csci5801.model;

import java.util.ArrayList;
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
            //TODO: Basic Procedure: determine which of hte coursestaken will be used, create a requirements object out of them, compare that requirements object to requirement passed into method, set result
            case BREADTH_REQUIREMENT_MS:
                caseBREADTH_REQUIREMENT_MS(requirement, courseTakenList);
                break;
            case BREADTH_REQUIREMENT_PHD:
                caseBREADTH_REQUIREMENT_PHD(requirement, courseTakenList);
                break;
            case THESIS_PHD:
                caseTHESIS(requirement, courseTakenList);
                break;
            case THESIS_MS:
                caseTHESIS(requirement, courseTakenList);
                break;
            case PLAN_B_PROJECT:
                casePASSED_AS_SATISFACTORY(requirement, courseTakenList);
                break;
            case COLLOQUIUM:
                casePASSED_AS_SATISFACTORY(requirement, courseTakenList);
                break;
            case OUT_OF_DEPARTMENT:
                caseOUT_OF_DEPARTMENT(requirement, courseTakenList);
                break;
            case PHD_LEVEL_COURSES:
                casePHD_LEVEL_COURSES(requirement, courseTakenList);
                break;
            case PHD_LEVEL_COURSES_PLANC:
                casePHD_LEVEL_COURSES_PLANC(requirement, courseTakenList);
                break;
            case INTRO_TO_RESEARCH:
                caseINTRO_TO_RESEARCH(requirement, courseTakenList);
                break;
            case TOTAL_CREDITS:
                caseTOTAL_CREDITS(requirement, courseTakenList);
                break;
            case COURSE_CREDITS:
                caseCOURSE_CREDITS(requirement, courseTakenList);
                break;
            case OVERALL_GPA_PHD:
                caseOVERALL_GPA_PHD(requirement, courseTakenList);
                break;
            case IN_PROGRAM_GPA_PHD:
                caseIN_PROGRAM_GPA_PHD(requirement, courseTakenList);
                break;
            case OVERALL_GPA_MS:
                caseOVERALL_GPA_MS(requirement, courseTakenList);
                break;
            case IN_PROGRAM_GPA_MS:
                caseIN_PROGRAM_GPA_MS(requirement, courseTakenList);
                break;
            case MILESTONES_PHD:
                caseMILESTONES_PHD(requirement, completedMilestoneList);
                break;
            case MILESTONES_MS_A:
                caseMILESTONES_MS_A(requirement, completedMilestoneList);
                break;
            case MILESTONES_MS_B:
                caseMILESTONES_MS_B(requirement, completedMilestoneList);
                break;
            case MILESTONES_MS_C:
                caseMILESTONES_MS_C(requirement, completedMilestoneList);
                break;
            default:
                break;
        }
    }

    private void  caseBREADTH_REQUIREMENT_MS(Requirement requirement, List<CourseTaken> courseTakenList) {

    }

    private void caseBREADTH_REQUIREMENT_PHD(Requirement requirement, List<CourseTaken> courseTakenList) {

    }

    private void caseTHESIS(Requirement requirement, List<CourseTaken> courseTakenList) {
        this.result = false;
        boolean takenClass = false;
        int thesisCredits = 0;
        List<CourseTaken> newCourseTakenList = new ArrayList<CourseTaken>();
        for(CourseTaken courseTaken : courseTakenList) {
            if (requirement.getCourses().get(0).getCourse().getId().equals(courseTaken.getCourse().getId())) {
                newCourseTakenList.add(courseTaken);
                takenClass = true;
                if (courseTaken.getGrade() == Grade.S) {
                    thesisCredits = thesisCredits + Integer.parseInt(courseTaken.getCourse().getNumCredits());
                }
            }
        }
        if (thesisCredits >= requirement.getCredits()) {
            this.result = true;
        }
        if(takenClass) {
            this.details = new Requirement(requirement.getName(), newCourseTakenList);
        }
        else {
            this.details = new Requirement(requirement.getName());
        }
    }

    private void casePASSED_AS_SATISFACTORY(Requirement requirement, List<CourseTaken> courseTakenList) {
        this.result = false;
        boolean takenClass = false;
        List<CourseTaken> newCourseTakenList = new ArrayList<CourseTaken>();
        for(CourseTaken courseTaken : courseTakenList) {
            if(requirement.getCourses().get(0).getCourse().getId().equals(courseTaken.getCourse().getId())) {
                if(courseTaken.getGrade() == Grade.S) {
                    this.result = true;
                }
                newCourseTakenList.add(courseTaken);
                takenClass = true;
            }
        }
        if(takenClass) {
            this.details = new Requirement(requirement.getName(), newCourseTakenList);
        }
        else {
            this.details = new Requirement(requirement.getName());
        }
    }

    private void caseOUT_OF_DEPARTMENT(Requirement requirement, List<CourseTaken> courseTakenList) {

    }

    private void casePHD_LEVEL_COURSES(Requirement requirement, List<CourseTaken> courseTakenList) {

    }

    private void casePHD_LEVEL_COURSES_PLANC(Requirement requirement, List<CourseTaken> courseTakenList) {

    }

    private void caseINTRO_TO_RESEARCH(Requirement requirement, List<CourseTaken> courseTakenList) {

    }

    private void caseTOTAL_CREDITS(Requirement requirement, List<CourseTaken> courseTakenList) {

    }

    private void caseCOURSE_CREDITS(Requirement requirement, List<CourseTaken> courseTakenList) {

    }

    private void caseOVERALL_GPA_PHD(Requirement requirement, List<CourseTaken> courseTakenList) {

    }

    private void caseIN_PROGRAM_GPA_PHD(Requirement requirement, List<CourseTaken> courseTakenList) {

    }

    private void caseOVERALL_GPA_MS(Requirement requirement, List<CourseTaken> courseTakenList) {

    }

    private void caseIN_PROGRAM_GPA_MS(Requirement requirement, List<CourseTaken> courseTakenList) {

    }

    private void caseMILESTONES_PHD(Requirement requirement, List<CompletedMilestone> completedMilestoneList) {

    }

    private void caseMILESTONES_MS_A(Requirement requirement, List<CompletedMilestone> completedMilestoneList) {

    }

    private void caseMILESTONES_MS_B(Requirement requirement, List<CompletedMilestone> completedMilestoneList) {

    }

    private void caseMILESTONES_MS_C(Requirement requirement, List<CompletedMilestone> completedMilestoneList) {

    }


}
