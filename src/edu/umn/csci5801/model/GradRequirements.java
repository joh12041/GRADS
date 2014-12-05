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
 * GradRequirements.java - Class that handles the creation of plan specific requirements
 * plans and compares them to requirements completed by the student
 * 
 * @author CSCI5801 Fall2014 Group1
 * @version 1.0
 */
public class GradRequirements {
	
    private List<GradReqCheck> reqChecks;
    private List<Requirement> reqList;
    private Degree degree;

    /**
     * GradRequirements() - Constructor for creating a GradRequirements object
     */
    public GradRequirements() {}
    
    /**
     * CourseTaken() - Constructor for creating a Course object
     * 
     * @param deg - A variable of type Degree identifying the degree a student is pursuing
     */
    public GradRequirements(Degree deg) throws Exception{
        //TODO:place in try/catch clause
        createReqList(deg);
    }
    
    /**
     * setReqChecks() - Method which copies a list of GradReqChecks
     * 
     * @param list - A variable of type List<GradReqCheck> identifying a list of GradReqCheck objects
     */
    public void setReqChecks(List<GradReqCheck> list) {
    	reqChecks = list;
    }
    
    /**
     * addReqCheck() - Method which adds a GradReqCheck to a list of GradReqChecks
     * 
     * @param grc - A variable of type GradReqCheck identifying a GradReqCheck object
     * to be added to a list
     */
    public void addReqCheck(GradReqCheck grc) {
    	reqChecks.add(grc);
    }
    
    /**
     * setReqList() - Method which copies a list of Requirements
     * 
     * @param list - A variable of type List<Requirement> identifying a list of Requirement objects
     */
    public void setReqList(List<Requirement> list) {
    	reqList = list;
    }
    
    /**
     * addRequirement() - Method which adds a Requirement to a list of Requirements
     * 
     * @param r - A variable of type Requirement identifying a Requirement object
     * to be added to a list
     */
    public void addRequirement(Requirement r) {
    	reqList.add(r);
    }
    
    /**
     * setDegree() - Method which the degree to test requirements against is set
     * 
     * @param d - A variable of type Degree to test Requirements against
     */
    public void setDegree(Degree d) {
    	degree = d;
    }

    /**
     * getReqChecks() - Method which returns the reqChecks list
     * 
     * @return reqChecks - Returns the List<GradReqChecks> stored in the GradRequirements object
     */
    public List<GradReqCheck> getReqChecks() {
    	return reqChecks;
    }
    
    /**
     * getReqList() - Method which returns the reqList list
     * 
     * @return reqChecks - Returns the List<GradReqChecks> stored in the GradRequirements object
     */
    public List<Requirement> getReqList() {
    	return reqList;
    }
    
    /**
     * getDegree() - Method which returns the degree
     * 
     * @return reqChecks - Returns the degree stored in the GradRequirements object
     */
    public Degree getDegree() {
    	return degree;
    }

    /**
     * getDegree() - Method which returns a list of Requirements
     * 
     * @param degree - Variable of type Degree which contains the type of degree to test against
     * @return reqChecks - Returns the List<Reqirements> to test completed requirements against
     */
    public List<Requirement> createReqList(Degree degree) throws Exception {
        List<Requirement> rList = new ArrayList<Requirement>();
        if(degree == Degree.MS_A) {
            MasterA MSA = new MasterA();
            rList = MSA.getReqList();
        }
        else if(degree == Degree.MS_B) {
            MasterB MSB = new MasterB();
            rList = MSB.getReqList();
        }
        else if(degree == Degree.MS_C) {
            MasterC MSC = new MasterC();
            rList = MSC.getReqList();
        }
        else if(degree == Degree.PHD) {
            PHD phd = new PHD();
            rList = phd.getReqList();
        }
        else {
            Exception e = new Exception();
            throw e;
        }
        this.reqList = rList;
        return reqList;
    }

    /**
     * testReqList() - Method which tests completed requirements against the requirements needed to graduated
     * 
     * @param courseTakenList - Variable of type List<CourseTaken> which contains completed courses 
     * @param completedMilestoneList - Variable of type List<CompletedMilestone> which contains completed milestones
     */
    public void testReqList(List<CourseTaken> courseTakenList, List<CompletedMilestone> completedMilestoneList) {
        for (Requirement r : reqList) {
            GradReqCheck grc = new GradReqCheck(r.getName());
            grc.testReq(r, courseTakenList, completedMilestoneList);
        }
    }
}
