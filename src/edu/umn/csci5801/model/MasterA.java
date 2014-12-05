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
 * MasterA.java - Class containing all graduation requirements for students
 * pursuing a Master's degree on Plan A. Also included is a mechanism to access
 * all requirements externally.
 *
 * @author CSCI5801 Fall2014 Group1
 * @version 1.0
 */
public class MasterA {

    private List<Requirement> reqList;

    /**
     * getReqList() - Method for getting the requirements list for Master Plan A
     *
     * @return reqList - Return the list of all requirements for graduation for Master Plan A
     */
    public List<Requirement> getReqList() {
        if(reqList == null) {
            setReqList();
        }
        return reqList;
    }

    /**
     * setReqList() - Method for setting the requirements list for Master Plan A
     */
    private void setReqList() {

        List<Requirement> tempReqList = new ArrayList<Requirement>();

        //List<String> to be included in all Requirements
        List<String> ls = new ArrayList<String>();
        ls.add("");

        // REQUIREMENT #1 BREADTH_REQUIREMENT_MS
        List<CourseTaken> ctl1 = new ArrayList<CourseTaken>();
        ctl1.add(new CourseTaken(new Course("Analysis of Numerical Algorithms","csci5302","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Computational Aspects of Matrix Theory","csci5304","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Computational Complexity","csci5403","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Advanced Algorithms and Data Structures","csci5421","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5525","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));

        ctl1.add(new CourseTaken(new Course("Operating Systems","csci5103","3",CourseArea.ARCHITECTURE_SYSTEMS_SOFTWARE), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("System Modeling and Performance Evaluation","csci5104","3",CourseArea.ARCHITECTURE_SYSTEMS_SOFTWARE), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Introduction to Distributed Systems","csci5105","3",CourseArea.ARCHITECTURE_SYSTEMS_SOFTWARE), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Programming Languages","csci5106","3",CourseArea.ARCHITECTURE_SYSTEMS_SOFTWARE), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Introduction to Compilers","csci5161","3",CourseArea.ARCHITECTURE_SYSTEMS_SOFTWARE), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Advanced Computer Architecture","csci5204","3",CourseArea.ARCHITECTURE_SYSTEMS_SOFTWARE), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Data Communications and Computer Networks","csci5211","3",CourseArea.ARCHITECTURE_SYSTEMS_SOFTWARE), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Foundations of Advanced Networking","csci5221","3",CourseArea.ARCHITECTURE_SYSTEMS_SOFTWARE), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Wireless and Sensor Networks","csci5231","3",CourseArea.ARCHITECTURE_SYSTEMS_SOFTWARE), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Introduction to Parallel Computing: Architectures, Algorithms, and Programming","csci5451","3",CourseArea.ARCHITECTURE_SYSTEMS_SOFTWARE), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Functional Genomics, Systems Biology, and Bioinformatics","csci5461","3",CourseArea.ARCHITECTURE_SYSTEMS_SOFTWARE), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Architecture and Implementation of Database Management Systems","csci5708","3",CourseArea.ARCHITECTURE_SYSTEMS_SOFTWARE), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Software Engineering I","csci5801","3",CourseArea.ARCHITECTURE_SYSTEMS_SOFTWARE), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Software Engineering II","csci5802","3",CourseArea.ARCHITECTURE_SYSTEMS_SOFTWARE), new Term(), Grade.C));

        ctl1.add(new CourseTaken(new Course("User Interface Design, Implementation, and Evaluation","csci5115","3",CourseArea.APPLICATIONS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Collaborative and Social Computing","csci5125","3",CourseArea.APPLICATIONS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Introduction to Computer Security","csci5271","3",CourseArea.APPLICATIONS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Modern Cryptography","csci5471","3",CourseArea.APPLICATIONS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Computational Techniques for Genomics","csci5481","3",CourseArea.APPLICATIONS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Artificial Intelligence I","csci5511","3",CourseArea.APPLICATIONS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Artificial Intelligence II","csci5512","3",CourseArea.APPLICATIONS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Introduction to Machine Learning","csci5521","3",CourseArea.APPLICATIONS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Introduction to Data Mining","csci5523","3",CourseArea.APPLICATIONS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Introduction to Intelligent Robotic Systems","csci5551","3",CourseArea.APPLICATIONS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Computer Vision","csci5561","3",CourseArea.APPLICATIONS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Fundamentals of Computer Graphics I","csci5607","3",CourseArea.APPLICATIONS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Fundamentals of Computer Graphics 2","csci5608","3",CourseArea.APPLICATIONS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Visualization","csci5609","3",CourseArea.APPLICATIONS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Animation and Planning in Games","csci5611","3",CourseArea.APPLICATIONS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Virtual Reality and 3D Interaction","csci5619","3",CourseArea.APPLICATIONS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Principles of Database Systems","csci5707","3",CourseArea.APPLICATIONS), new Term(), Grade.C));

        Requirement req1 = new Requirement(Reqs.BREADTH_REQUIREMENT_MS, 3.25, ctl1, 9, ls);
        tempReqList.add(req1);

        //REQUIREMENT #2 THESIS_MS
        List<CourseTaken> ctl2 = new ArrayList<CourseTaken>();
        ctl2.add(new CourseTaken(new Course("Thesis Credit: Masters","csci8777","10"),new Term(), Grade.S));

        Requirement req2 = new Requirement(Reqs.THESIS_MS,ctl2,10,ls);
        tempReqList.add(req2);

        //REQUIREMENT #3 COLLOQUIUM
        List<CourseTaken> ctl3 = new ArrayList<CourseTaken>();
        ctl3.add(new CourseTaken(new Course("Computer Science Colloquium","csci8970","1"),new Term(), Grade.S));

        Requirement req3 = new Requirement(Reqs.COLLOQUIUM,ctl3,1,ls);
        tempReqList.add(req3);

        //REQUIREMENT #4 PHD_LEVEL_COURSES
        List<CourseTaken> ctl4 = new ArrayList<CourseTaken>();
        ctl4.add(new CourseTaken(new Course("Advanced Operating Systems","csci8101","3"),new Term(), Grade.C));
        ctl4.add(new CourseTaken(new Course("Foundations of Distributed Computing","csci8102","3"),new Term(), Grade.C));
        ctl4.add(new CourseTaken(new Course("Understanding the Social Web","csci8117","3"),new Term(), Grade.C));
        ctl4.add(new CourseTaken(new Course("Advanced Compiler Techniques","csci8161","3"),new Term(), Grade.C));
        ctl4.add(new CourseTaken(new Course("Parallel Computer Organization","csci8205","3"),new Term(), Grade.C));
        ctl4.add(new CourseTaken(new Course("Advanced Computer Networks and Their Applications","csci8211","3"),new Term(), Grade.C));
        ctl4.add(new CourseTaken(new Course("Security and Privacy in Computing","csci8271","3"),new Term(), Grade.C));
        ctl4.add(new CourseTaken(new Course("Sparse Matrix Computations","csci8314","3"),new Term(), Grade.C));
        ctl4.add(new CourseTaken(new Course("Numerical Linear Algebra in Data Exploration","csci8363","3"),new Term(), Grade.C));
        ctl4.add(new CourseTaken(new Course("Computational Geometry and Applications","csci8442","3"),new Term(), Grade.C));
        ctl4.add(new CourseTaken(new Course("Intelligent Agents","csci8551","3"),new Term(), Grade.C));
        ctl4.add(new CourseTaken(new Course("Overview of Database Research","csci8701","3"),new Term(), Grade.C));
        ctl4.add(new CourseTaken(new Course("Spatial Databases and Applications","csci8715","3"),new Term(), Grade.C));
        ctl4.add(new CourseTaken(new Course("Databases for Bioinformatics","csci8725","3"),new Term(), Grade.C));
        ctl4.add(new CourseTaken(new Course("Advanced Database Systems","csci8735","3"),new Term(), Grade.C));
        ctl4.add(new CourseTaken(new Course("Advanced Software Engineering","csci8801","3"),new Term(), Grade.C));
        ctl4.add(new CourseTaken(new Course("Special Advanced Topics in Computer Science","csci8980","3"),new Term(), Grade.C));

        Requirement req4 = new Requirement(Reqs.PHD_LEVEL_COURSES,ctl4,3,ls);
        tempReqList.add(req4);

        //REQUIREMENT #5 TOTAL_CREDITS_MSA
        Requirement req5 = new Requirement(Reqs.TOTAL_CREDITS_MSA);
        tempReqList.add(req5);

        //REQUIREMENT #6 COURSE_CREDITS
        Requirement req6 = new Requirement(Reqs.COURSE_CREDITS);
        tempReqList.add(req6);

        //REQUIREMENT #7 OVERALL_GPA_MS
        Requirement req7 = new Requirement(Reqs.OVERALL_GPA_MS, 3.25);
        tempReqList.add(req7);

        //REQUIREMENT #8 IN_PROGRAM_GPA_MS
        Requirement req8 = new Requirement(Reqs.IN_PROGRAM_GPA_MS, 3.25);
        tempReqList.add(req8);

        //Requirement #9 MILESTONES_MS_A
        List<CompletedMilestone> lm9 = new ArrayList<CompletedMilestone>();
        lm9.add(new CompletedMilestone(Milestone.DPF_SUBMITTED));
        lm9.add(new CompletedMilestone(Milestone.DPF_APPROVED));
        lm9.add(new CompletedMilestone(Milestone.THESIS_COMMITTEE_APPOINTED));
        lm9.add(new CompletedMilestone(Milestone.GRADUATION_PACKET_REQUESTED));
        lm9.add(new CompletedMilestone(Milestone.THESIS_SUBMITTED));
        lm9.add(new CompletedMilestone(Milestone.THESIS_APPROVED));
        lm9.add(new CompletedMilestone(Milestone.DEFENSE_PASSED));

        Requirement req9 = new Requirement(Reqs.MILESTONES_MS_A,lm9,ls);
        tempReqList.add(req9);

        reqList = tempReqList;
    }
}
