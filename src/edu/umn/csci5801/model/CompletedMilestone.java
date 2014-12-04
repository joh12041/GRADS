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

/**
 * CompletedMilestone.java - Class containing milestone which has been
 * completed by a student
 * 
 * @author CSCI5801 Fall2014 Group1
 * @version 1.0
 */
public class CompletedMilestone {
	
    private Milestone milestone;
    private Term term;

    /**
     * CompletedMilestone() - Constructor for creating a Milestone object
     */
    public CompletedMilestone() {}

    public CompletedMilestone(Milestone m) {
        milestone = m;
    }
    /**
     * CompletedMilestone() - Constructor for creating a Milestone object
     * 
     * @param m - A variable of type Milestone identifying a milestone's name
     * @param t - A variable of type Term identifying the milestone's term completed
     */
    public CompletedMilestone(Milestone m, Term t) {
        milestone = m;
        term = t;
    }
    
    /**
     * setMilestone() - Method for setting the Milestone attribute of
     * a Milestone object
     * 
     * @param milestone - A variable of type Milestone identifying a milestone's name
     */
    public void setMilestone(Milestone milestone){
        this.milestone = milestone;
    }
    
    /**
     * setTerm() - Method for setting the Term attribute of
     * a Milestone object
     * 
     * @param term - A variable of type Term identifying a milestone's term
     */
    public void setTerm(Term term){
        this.term = term;
    }

    /**
     * getMilestone() - Method for getting the Milestone attribute of
     * a Milestone object
     * 
     * @return milestone - Return the Milestone attribute
     */
    public Milestone getMilestone(){
        return milestone;
    }
    
    /**
     * getTerm() - Method for getting the Term attribute of
     * a Milestone object
     * 
     * @return term - Return the Term attribute
     */
    public Term getTerm(){
        return term;
    }
}
