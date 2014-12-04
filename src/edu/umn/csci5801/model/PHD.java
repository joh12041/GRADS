package edu.umn.csci5801.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zihong on 12/2/14.
 */
public class PHD {
    private List<Requirement> reqList;
    public List<Requirement> getReqList() {
        if(reqList == null) {
            setReqList();
        }
        return reqList;
    }
    //TODO: This is where the Requirements for  PHD get inputted into a List
    private void setReqList() {
        List<String> ls = new ArrayList<String>();
        ls.add("");

        // REQUIREMENT #1 BREADTH_REQUIREMENT_PHD
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

        Requirement req1 = new Requirement(Reqs.BREADTH_REQUIREMENT_PHD, 3.45, ctl1, 15, ls);
        reqList.add(req1);

        //REQUIREMENT #2 THESIS_PHD
        List<CourseTaken> ctl2 = new ArrayList<CourseTaken>();
        ctl2.add(new CourseTaken(new Course("Thesis Credit: Doctoral","csci8888","24"),new Term(), Grade.S));

        Requirement req2 = new Requirement(Reqs.THESIS_PHD,ctl2,24,ls);
        reqList.add(req2);

        //REQUIREMENT #3 COLLOQUIUM
        List<CourseTaken> ctl3 = new ArrayList<CourseTaken>();
        ctl3.add(new CourseTaken(new Course("Computer Science Colloquium","csci8970","1"),new Term(), Grade.S));

        Requirement req3 = new Requirement(Reqs.COLLOQUIUM,ctl3,1,ls);
        reqList.add(req3);

        //REQUIREMENT #4 OUT_OF_DEPARTMENT

        Requirement req4 = new Requirement(Reqs.OUT_OF_DEPARTMENT);
        reqList.add(req4);

        //REQUIREMENT #5 INTRO_TO_RESEARCH
        List<CourseTaken> ctl5 = new ArrayList<CourseTaken>();
        ctl5.add(new CourseTaken(new Course("Introduction to Research in Computer Science I","csci8001","1"),new Term(), Grade.S));
        ctl5.add(new CourseTaken(new Course("Introduction to Research in Computer Science II","csci8002","2"),new Term(), Grade.S));

        Requirement req5 = new Requirement(Reqs.INTRO_TO_RESEARCH, ctl5, 3, ls);
        reqList.add(req5);

        //TODO:REQUIREMENT #6 TOTAL_CREDITS_PHD
        Requirement req6 = new Requirement(Reqs.TOTAL_CREDITS_PHD, 31);
        reqList.add(req6);

        //REQUIREMENT #7 OVERALL_GPA_PHD
        Requirement req7 = new Requirement(Reqs.OVERALL_GPA_PHD, 3.45);
        reqList.add(req7);

        //REQUIREMENT #8 IN_PROGRAM_GPA_PHD
        Requirement req8 = new Requirement(Reqs.IN_PROGRAM_GPA_PHD, 3.45);
        reqList.add(req8);

        //Requirement #9 MILESTONES_PHD
        List<CompletedMilestone> lm9 = new ArrayList<CompletedMilestone>();
        lm9.add(new CompletedMilestone(Milestone.PRELIM_COMMITTEE_APPOINTED));
        lm9.add(new CompletedMilestone(Milestone.WRITTEN_PE_SUBMITTED));
        lm9.add(new CompletedMilestone(Milestone.WRITTEN_PE_APPROVED));
        lm9.add(new CompletedMilestone(Milestone.ORAL_PE_PASSED));
        lm9.add(new CompletedMilestone(Milestone.DPF_SUBMITTED));
        lm9.add(new CompletedMilestone(Milestone.DPF_APPROVED));
        lm9.add(new CompletedMilestone(Milestone.THESIS_COMMITTEE_APPOINTED));
        lm9.add(new CompletedMilestone(Milestone.PROPOSAL_PASSED));
        lm9.add(new CompletedMilestone(Milestone.GRADUATION_PACKET_REQUESTED));
        lm9.add(new CompletedMilestone(Milestone.THESIS_SUBMITTED));
        lm9.add(new CompletedMilestone(Milestone.THESIS_APPROVED));
        lm9.add(new CompletedMilestone(Milestone.DEFENSE_PASSED));

        Requirement req9 = new Requirement(Reqs.MILESTONES_PHD,lm9,ls);
        reqList.add(req9);
    }
}
