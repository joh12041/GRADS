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
                casePASSED_AS_SATISFACTORY(requirement, courseTakenList);
                break;
            case THESIS_MS:
                casePASSED_AS_SATISFACTORY(requirement, courseTakenList);
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
                casePASSED_WITH_C(requirement, courseTakenList);
                break;
            case PHD_LEVEL_COURSES_PLANC:
                casePASSED_WITH_C(requirement, courseTakenList);
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
                caseOVERALL_GPA(requirement, courseTakenList);
                break;
            case IN_PROGRAM_GPA_PHD:
                caseIN_PROGRAM_GPA(requirement, courseTakenList);
                break;
            case OVERALL_GPA_MS:
                caseOVERALL_GPA(requirement, courseTakenList);
                break;
            case IN_PROGRAM_GPA_MS:
                caseIN_PROGRAM_GPA(requirement, courseTakenList);
                break;
            case MILESTONES_PHD:
                caseMILESTONES(requirement, completedMilestoneList);
                break;
            case MILESTONES_MS_A:
                caseMILESTONES(requirement, completedMilestoneList);
                break;
            case MILESTONES_MS_B:
                caseMILESTONES(requirement, completedMilestoneList);
                break;
            case MILESTONES_MS_C:
                caseMILESTONES(requirement, completedMilestoneList);
                break;
            default:
                break;
        }
    }

    private void  caseBREADTH_REQUIREMENT_MS(Requirement requirement, List<CourseTaken> courseTakenList) {

    }

    private void caseBREADTH_REQUIREMENT_PHD(Requirement requirement, List<CourseTaken> courseTakenList) {

    }

    //Checks any requirement that is based on passing with satisfactory a certain number of credits of a single course
    private void casePASSED_AS_SATISFACTORY(Requirement requirement, List<CourseTaken> courseTakenList) {
        this.result = false;
        int takenCredits = 0;
        List<CourseTaken> newCourseTakenList = new ArrayList<CourseTaken>();
        List<String> validCourseIDs = new ArrayList<String>();

        //Generate list of valid courses
        for (CourseTaken validCourseTaken : requirement.getCourses()) {
            validCourseIDs.add(validCourseTaken.getCourse().getId());
        }

        //Find and count only the coursesTaken that match the requirement
        for (CourseTaken courseTaken : courseTakenList) {
            if (validCourseIDs.contains(courseTaken.getCourse().getId())) {
                newCourseTakenList.add(courseTaken);
                //Check if passed and therefore credits count toward requirement
                if (courseTaken.getGrade() == Grade.S) {
                    takenCredits = takenCredits + Integer.parseInt(courseTaken.getCourse().getNumCredits());
                }
            }
        }

        //Fill in gradReqCheck
        this.details = new Requirement(requirement.getName(), newCourseTakenList);
        if (takenCredits >= requirement.getCredits()) {
            this.result = true;
        }
    }

    private void caseOUT_OF_DEPARTMENT(Requirement requirement, List<CourseTaken> courseTakenList) {
        this.result = false;
        int takenCredits = 0;
        List<CourseTaken> newCourseTakenList = new ArrayList<CourseTaken>();

        //Find and count only the coursesTaken that match the requirement
        for (CourseTaken courseTaken : courseTakenList) {
            if (courseTaken.getCourse().getId().matches("^(?!csci).*[56789][0-9]{3}$")) {
                newCourseTakenList.add(courseTaken);
                //Check if passed and therefore credits count toward requirement
                if (courseTaken.getGrade() == Grade.A || courseTaken.getGrade() == Grade.B || courseTaken.getGrade() == Grade.C) {
                    takenCredits = takenCredits + Integer.parseInt(courseTaken.getCourse().getNumCredits());
                }
            }
        }

        //Fill in gradReqCheck
        this.details = new Requirement(requirement.getName(), newCourseTakenList);
        if (takenCredits >= requirement.getCredits()) {
            this.result = true;
        }
    }

    private void casePASSED_WITH_C(Requirement requirement, List<CourseTaken> courseTakenList) {
        this.result = false;
        boolean takenClass = false;
        int takenCredits = 0;
        List<CourseTaken> newCourseTakenList = new ArrayList<CourseTaken>();
        List<String> validCourseIDs = new ArrayList<String>();

        //Generate list of valid courses
        for (CourseTaken validCourseTaken : requirement.getCourses()) {
            validCourseIDs.add(validCourseTaken.getCourse().getId());
        }

        //Find and count only the coursesTaken that match the requirement
        for (CourseTaken courseTaken : courseTakenList) {
            if (validCourseIDs.contains(courseTaken.getCourse().getId())) {
                newCourseTakenList.add(courseTaken);
                //Check if passed and therefore credits count toward requirement
                if (courseTaken.getGrade() == Grade.A || courseTaken.getGrade() == Grade.B || courseTaken.getGrade() == Grade.C) {
                    takenCredits = takenCredits + Integer.parseInt(courseTaken.getCourse().getNumCredits());
                }
            }
        }

        //Fill in gradReqCheck
        this.details = new Requirement(requirement.getName(), newCourseTakenList);
        if (takenCredits >= requirement.getCredits()) {
            this.result = true;
        }
    }

    private void caseINTRO_TO_RESEARCH(Requirement requirement, List<CourseTaken> courseTakenList) {

    }

    private void caseTOTAL_CREDITS(Requirement requirement, List<CourseTaken> courseTakenList) {

    }

    private void caseCOURSE_CREDITS(Requirement requirement, List<CourseTaken> courseTakenList) {

    }

    private void caseOVERALL_GPA(Requirement requirement, List<CourseTaken> courseTakenList) {
        this.result = false;

        //Calculate GPA and fill in gradReqCheck
        this.details = new Requirement(requirement.getName(), courseTakenList);
        this.details.calculateGpa();
        if (details.getGpa() >= requirement.getGpa()) {
            this.result = true;
        }
    }

    private void caseIN_PROGRAM_GPA(Requirement requirement, List<CourseTaken> courseTakenList) {
        this.result = false;
        List<CourseTaken> newCourseTakenList = new ArrayList<CourseTaken>();

        //Find and collect only the coursesTaken that are CSCI 5000 level
        for(CourseTaken courseTaken : courseTakenList) {
            if (courseTaken.getCourse().getId().matches("^csci5[0-9]{3}$")) {
                newCourseTakenList.add(courseTaken);
                }
            }

        //Calculate GPA and fill in gradReqCheck
        this.details = new Requirement(requirement.getName(), newCourseTakenList);
        this.details.calculateGpa();
        if (details.getGpa() >= requirement.getGpa()) {
            this.result = true;
        }
    }

    private void caseMILESTONES(Requirement requirement, List<CompletedMilestone> completedMilestoneList) {
        this.result = false;
        int studentsMilestones = 0;

        //Find if the student passed each milestone and count it if so
        for(CompletedMilestone requiredMilestone : requirement.getMilestones()) {
            for (CompletedMilestone studentMilestone : completedMilestoneList) {
                if (studentMilestone.getMilestone() == (requiredMilestone.getMilestone())) {
                    studentsMilestones++;
                    break;
                }
            }
        }

        //Fill in gradReqCheck
        this.details = new Requirement(requirement.getName(), completedMilestoneList, requirement.getNotes());
        //Check if requirement passed
        if (studentsMilestones == requirement.getMilestones().size()) {
                this.result = true;
        }
    }
}
