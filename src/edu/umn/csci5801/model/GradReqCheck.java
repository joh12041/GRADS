/**
 * Copyright 2014 CSCI5801 Fall2014 Group1
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.umn.csci5801.model;

import java.util.ArrayList;
import java.util.List;

/**
 * GradReqCheck.java - Class that handles the checking of completed student requirements against graduation requirements
 * 
 * @author CSCI5801 Fall2014 Group1
 * @version 1.0
 */
public class GradReqCheck {
	
    private Reqs reqName;
    private boolean result;
    private Requirement details;

    /**
     * ProgressSummary() - Constructors for creating a GradReqCheck object
     */
    public GradReqCheck() {}
    public GradReqCheck(Reqs n) {
        reqName = n;
    }
    
    /**
     * Methods for setting attributes of a GradReqCheck object
     */
    public void setReqName(Reqs n) { reqName = n; }
    public void setResult(boolean ic) { result = ic; }
    public void setDetails(Requirement r) { details = r; }

    /**
     * Methods for getting attributes of a GradReqCheck object
     */
    public Reqs getReqName() { return reqName; }
    public boolean getResult() { return result; }
    public Requirement getDetails() { return details; }

    /**
     * Methods which test various completed requirements against graduation requirements, in whole or in part
     */
    public void testReq(Requirement requirement, List<CourseTaken> courseTakenList, List<CompletedMilestone> completedMilestoneList) {
        //Logic for checking any given requirement
        switch (requirement.getName()) {
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
                casePASSED_AS_SATISFACTORY(requirement, courseTakenList);
                break;
            case TOTAL_CREDITS_PHD:
                caseTOTAL_CREDITS_PHD(requirement, courseTakenList);
                break;
            case TOTAL_CREDITS_MSA:
                caseTOTAL_CREDITS_MSA(requirement, courseTakenList);
                break;
            case TOTAL_CREDITS_MSB:
                caseTOTAL_CREDITS_MSBC(requirement, courseTakenList);
                break;
            case TOTAL_CREDITS_MSC:
                caseTOTAL_CREDITS_MSBC(requirement, courseTakenList);
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

        this.result = false;
        CourseTaken topThry = null;
        CourseTaken topAppl = null;
        CourseTaken topArch = null;

        List<CourseTaken> newCourseTakenList = new ArrayList<CourseTaken>();
        List<String> validCourseIDs = new ArrayList<String>();
        List<Grade> validGrades = new ArrayList<Grade>();
        validGrades.add(Grade.A);
        validGrades.add(Grade.B);
        validGrades.add(Grade.C);

        //Generate list of valid courses
        for (CourseTaken validCourseTaken : requirement.getCourses()) {
            validCourseIDs.add(validCourseTaken.getCourse().getId());
        }

        //Find and count only the coursesTaken that match the requirement
        for (CourseTaken courseTaken : courseTakenList) {
            if (validCourseIDs.contains(courseTaken.getCourse().getId()) && validGrades.contains(courseTaken.getGrade())) {
                switch (courseTaken.getCourse().getCourseArea()) {
                    case APPLICATIONS:
                        if (topAppl == null) {
                            topAppl = courseTaken;
                            break;
                        }
                        if (topAppl.getGrade() == Grade.A) {
                            break;
                        }
                        if (topAppl.getGrade() == Grade.B) {
                            if (courseTaken.getGrade() == Grade.A) {
                                topAppl = courseTaken;
                                break;
                            }
                            break;
                        }
                        if (topAppl.getGrade() == Grade.C) {
                            if (courseTaken.getGrade() == Grade.A || courseTaken.getGrade() == Grade.B) {
                                topAppl = courseTaken;
                                break;
                            }
                            break;
                        }
                        break;

                    case THEORY_ALGORITHMS:
                        if (topThry == null) {
                            topThry = courseTaken;
                            break;
                        }
                        if (topThry.getGrade() == Grade.A) {
                            break;
                        }
                        if (topThry.getGrade() == Grade.B) {
                            if (courseTaken.getGrade() == Grade.A) {
                                topThry = courseTaken;
                                break;
                            }
                            break;
                        }
                        if (topThry.getGrade() == Grade.C) {
                            if (courseTaken.getGrade() == Grade.A || courseTaken.getGrade() == Grade.B) {
                                topThry = courseTaken;
                                break;
                            }
                            break;
                        }
                        break;

                    case ARCHITECTURE_SYSTEMS_SOFTWARE:
                        if (topArch == null) {
                            topArch = courseTaken;
                            break;
                        }
                        if (topArch.getGrade() == Grade.A) {
                            break;
                        }
                        if (topArch.getGrade() == Grade.B) {
                            if (courseTaken.getGrade() == Grade.A) {
                                topArch = courseTaken;
                                break;
                            }
                            break;
                        }
                        if (topArch.getGrade() == Grade.C) {
                            if (courseTaken.getGrade() == Grade.A || courseTaken.getGrade() == Grade.B) {
                                topArch = courseTaken;
                                break;
                            }
                            break;
                        }
                        break;
                }
            }
        }
        if (topAppl != null) {
            newCourseTakenList.add(topAppl);
        }
        if (topThry != null) {
            newCourseTakenList.add(topThry);
        }
        if (topArch != null) {
            newCourseTakenList.add(topArch);
        }

        //Fill in gradReqCheck
        this.details = new Requirement(requirement.getName(), newCourseTakenList);
        this.details.calculateGpa();
        if (details.getGpa() >= requirement.getGpa() && this.details.getCourses().size() == 5) {
            this.result = true;
        }

    }

    private void caseBREADTH_REQUIREMENT_PHD(Requirement requirement, List<CourseTaken> courseTakenList) {

        this.result = false;
        CourseTaken topThry = null;
        CourseTaken topAppl = null;
        CourseTaken topArch = null;
        CourseTaken fourth = null;
        CourseTaken fifth = null;

        List<CourseTaken> newCourseTakenList = new ArrayList<CourseTaken>();
        List<String> validCourseIDs = new ArrayList<String>();
        List<Grade> validGrades = new ArrayList<Grade>();
        validGrades.add(Grade.A);
        validGrades.add(Grade.B);
        validGrades.add(Grade.C);

        //Generate list of valid courses
        for (CourseTaken validCourseTaken : requirement.getCourses()) {
            validCourseIDs.add(validCourseTaken.getCourse().getId());
        }

        //Find and count only the coursesTaken that match the requirement
        for (CourseTaken courseTaken : courseTakenList) {
            if (validCourseIDs.contains(courseTaken.getCourse().getId()) && validGrades.contains(courseTaken.getGrade())) {
                switch (courseTaken.getCourse().getCourseArea()) {
                    case APPLICATIONS:
                        if (topAppl == null) {
                            topAppl = courseTaken;
                            break;
                        }
                        if (topAppl.getGrade() == Grade.A) {
                            break;
                        }
                        if (topAppl.getGrade() == Grade.B) {
                            if (courseTaken.getGrade() == Grade.A) {
                                topAppl = courseTaken;
                                break;
                            }
                            break;
                        }
                        if (topAppl.getGrade() == Grade.C) {
                            if (courseTaken.getGrade() == Grade.A || courseTaken.getGrade() == Grade.B) {
                                topAppl = courseTaken;
                                break;
                            }
                            break;
                        }
                        break;

                    case THEORY_ALGORITHMS:
                        if (topThry == null) {
                            topThry = courseTaken;
                            break;
                        }
                        if (topThry.getGrade() == Grade.A) {
                            break;
                        }
                        if (topThry.getGrade() == Grade.B) {
                            if (courseTaken.getGrade() == Grade.A) {
                                topThry = courseTaken;
                                break;
                            }
                            break;
                        }
                        if (topThry.getGrade() == Grade.C) {
                            if (courseTaken.getGrade() == Grade.A || courseTaken.getGrade() == Grade.B) {
                                topThry = courseTaken;
                                break;
                            }
                            break;
                        }
                        break;

                    case ARCHITECTURE_SYSTEMS_SOFTWARE:
                        if (topArch == null) {
                            topArch = courseTaken;
                            break;
                        }
                        if (topArch.getGrade() == Grade.A) {
                            break;
                        }
                        if (topArch.getGrade() == Grade.B) {
                            if (courseTaken.getGrade() == Grade.A) {
                                topArch = courseTaken;
                                break;
                            }
                            break;
                        }
                        if (topArch.getGrade() == Grade.C) {
                            if (courseTaken.getGrade() == Grade.A || courseTaken.getGrade() == Grade.B) {
                                topArch = courseTaken;
                                break;
                            }
                            break;
                        }
                        break;
                }
            }
        }

        if (topAppl != null) {
            newCourseTakenList.add(topAppl);
        }
        if (topThry != null) {
            newCourseTakenList.add(topThry);
        }
        if (topArch != null) {
            newCourseTakenList.add(topArch);
        }

        for (CourseTaken courseTaken2 : courseTakenList) {
            if (validCourseIDs.contains(courseTaken2.getCourse().getId()) && validGrades.contains(courseTaken2.getGrade()) && !newCourseTakenList.contains(courseTaken2)) {
                if (fourth == null) {
                    fourth = courseTaken2;
                    continue;
                }
                if (fifth == null) {
                    fifth = courseTaken2;
                    continue;
                }
                if (fourth.getGrade() == Grade.C) {
                    if (courseTaken2.getGrade() == Grade.A || courseTaken2.getGrade() == Grade.B) {
                        fourth = courseTaken2;
                        continue;
                    }
                }
                if (fifth.getGrade() == Grade.C) {
                    if (courseTaken2.getGrade() == Grade.A || courseTaken2.getGrade() == Grade.B) {
                        fifth = courseTaken2;
                        continue;
                    }
                }
                if (fourth.getGrade() == Grade.B) {
                    if (courseTaken2.getGrade() == Grade.A) {
                        fourth = courseTaken2;
                        continue;
                    }
                }
                if (fifth.getGrade() == Grade.B) {
                    if (courseTaken2.getGrade() == Grade.A) {
                        fifth = courseTaken2;
                        continue;
                    }
                }
            }
        }


        if (fourth != null) {
            newCourseTakenList.add(fourth);
        }
        if (fifth != null) {
            newCourseTakenList.add(fifth);
        }

        //Fill in gradReqCheck
        this.details = new Requirement(requirement.getName(), newCourseTakenList);
        this.details.calculateGpa();
        if (details.getGpa() >= requirement.getGpa() && this.details.getCourses().size() == 5) {
            this.result = true;
        }
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

    private void caseTOTAL_CREDITS_PHD(Requirement requirement, List<CourseTaken> courseTakenList) {
        this.result = false;
        int csciCredits = 0;
        int totalCredits = 0;
        int reqCsciCredits = 16;
        int reqTotalCredits = 31;
        List<CourseTaken> newCourseTakenList = new ArrayList<CourseTaken>();

        //Only letter grades A, B, C, and S count towards requirements
        List<Grade> validGrades = new ArrayList<Grade>();
        validGrades.add(Grade.A);
        validGrades.add(Grade.B);
        validGrades.add(Grade.C);
        validGrades.add(Grade.S);
        List<String> invalidCourseIDs = new ArrayList<String>();

        //Thesis credits do not count
        invalidCourseIDs.add("csci8777");
        invalidCourseIDs.add("csci8888");
        invalidCourseIDs.add("csci8666");

        for(CourseTaken courseTaken : courseTakenList) {
            if (validGrades.contains(courseTaken.getGrade()) && !invalidCourseIDs.contains(courseTaken.getCourse().getId())) {
                //Collect only the coursesTaken that are CSCI 5000+ level
                if (courseTaken.getCourse().getId().matches("^csci[56789][0-9]{3}$")) {
                    newCourseTakenList.add(courseTaken);
                    csciCredits = csciCredits + Integer.parseInt(courseTaken.getCourse().getNumCredits());
                    totalCredits = totalCredits + Integer.parseInt(courseTaken.getCourse().getNumCredits());
                    continue;
                }
                //Collect the coursesTaken that are non-CSCI or CSCI below the 5000 level
                newCourseTakenList.add(courseTaken);
                totalCredits = totalCredits + Integer.parseInt(courseTaken.getCourse().getNumCredits());
            }
        }

        //Fill in reqCheck and ensure 16 CSCI 5000+ level credits and 31 total
        this.details = new Requirement(requirement.getName(), newCourseTakenList);
        if (csciCredits >= reqCsciCredits && totalCredits >= reqTotalCredits) {
            this.result = true;
        }
    }

    private void caseTOTAL_CREDITS_MSA(Requirement requirement, List<CourseTaken> courseTakenList) {
        this.result = false;
        int totalCredits = 0;
        int reqTotalCredits = 31;
        List<CourseTaken> newCourseTakenList = new ArrayList<CourseTaken>();

        //Only letter grades A, B, C, and S count towards requirements
        List<Grade> validGrades = new ArrayList<Grade>();
        validGrades.add(Grade.A);
        validGrades.add(Grade.B);
        validGrades.add(Grade.C);
        validGrades.add(Grade.S);

        for(CourseTaken courseTaken : courseTakenList) {
            if (validGrades.contains(courseTaken.getGrade())) {
                newCourseTakenList.add(courseTaken);
                totalCredits = totalCredits + Integer.parseInt(courseTaken.getCourse().getNumCredits());
            }
        }

        this.details = new Requirement(requirement.getName(), newCourseTakenList);
        if (totalCredits >= reqTotalCredits) {
            this.result = true;
        }
    }

    private void caseTOTAL_CREDITS_MSBC(Requirement requirement, List<CourseTaken> courseTakenList) {
        this.result = false;
        int csciCredits = 0;
        int totalCredits = 0;
        int reqCsciCredits = 16;
        int reqTotalCredits = 31;
        List<CourseTaken> newCourseTakenList = new ArrayList<CourseTaken>();

        //Only letter grades A, B, C, and S count towards requirements
        List<Grade> validGrades = new ArrayList<Grade>();
        validGrades.add(Grade.A);
        validGrades.add(Grade.B);
        validGrades.add(Grade.C);
        validGrades.add(Grade.S);

        for(CourseTaken courseTaken : courseTakenList) {
            if (validGrades.contains(courseTaken.getGrade())) {
                //Collect only the coursesTaken that are CSCI 5000+ level
                if (courseTaken.getCourse().getId().matches("^csci[56789][0-9]{3}$")) {
                    newCourseTakenList.add(courseTaken);
                    csciCredits = csciCredits + Integer.parseInt(courseTaken.getCourse().getNumCredits());
                    totalCredits = totalCredits + Integer.parseInt(courseTaken.getCourse().getNumCredits());
                    continue;
                }
                //Collect the coursesTaken that are non-CSCI or CSCI below the 5000 level
                newCourseTakenList.add(courseTaken);
                totalCredits = totalCredits + Integer.parseInt(courseTaken.getCourse().getNumCredits());
            }
        }

        //Fill in reqCheck and ensure 16 CSCI 5000+ level credits and 31 total
        this.details = new Requirement(requirement.getName(), newCourseTakenList);
        if (csciCredits >= reqCsciCredits && totalCredits >= reqTotalCredits) {
            this.result = true;
        }
    }

    private void caseCOURSE_CREDITS(Requirement requirement, List<CourseTaken> courseTakenList) {
        //Track CSCI credits and Non-CSCI credits
        //Use regex similar to IN_PROGRAM_GPA and OUT_OF_DEPARTMENT to get individual credit requirements
        //Check that grades are A, B, or C
        //Remove any thesis credits from consideration

        this.result = false;
        int csciCredits = 0;
        int totalCredits = 0;
        int reqCsciCredits = 16;
        int reqTotalCredits = 22;
        List<CourseTaken> newCourseTakenList = new ArrayList<CourseTaken>();

        //Only letter grades A, B, C count towards requirements
        List<Grade> validGrades = new ArrayList<Grade>();
        validGrades.add(Grade.A);
        validGrades.add(Grade.B);
        validGrades.add(Grade.C);
        validGrades.add(Grade.S);
        List<String> invalidCourseIDs = new ArrayList<String>();

        //Thesis credits do not count
        invalidCourseIDs.add("csci8777");
        invalidCourseIDs.add("csci8888");
        invalidCourseIDs.add("csci8666");

        for(CourseTaken courseTaken : courseTakenList) {
            if (validGrades.contains(courseTaken.getGrade()) && !invalidCourseIDs.contains(courseTaken.getCourse().getId())) {
                //Collect only the coursesTaken that are CSCI 5000+ level
                if (courseTaken.getCourse().getId().matches("^csci[56789][0-9]{3}$")) {
                    newCourseTakenList.add(courseTaken);
                    csciCredits = csciCredits + Integer.parseInt(courseTaken.getCourse().getNumCredits());
                    totalCredits = totalCredits + Integer.parseInt(courseTaken.getCourse().getNumCredits());
                    continue;
                }
                //Collect only the coursesTaken that are non-CSCI or CSCI below the 5000 level
                newCourseTakenList.add(courseTaken);
                totalCredits = totalCredits + Integer.parseInt(courseTaken.getCourse().getNumCredits());
            }
        }

        //Calculate GPA and fill in gradReqCheck
        this.details = new Requirement(requirement.getName(), newCourseTakenList);
        if (csciCredits >= reqCsciCredits && totalCredits >= reqTotalCredits) {
            this.result = true;
        }
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
