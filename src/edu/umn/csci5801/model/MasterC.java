package edu.umn.csci5801.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 12/2/2014.
 */
public class MasterC {
    private List<Requirement> reqList;
    public List<Requirement> getReqList() {
        if(reqList == null) {
            setReqList();
        }
        return reqList;
    }
    //TODO: This is where the Requirements for Masters C get inputted into a List
    private void setReqList() {
        List<CourseTaken> ctl1 = new ArrayList<CourseTaken>();
        ctl1.add(new CourseTaken(new Course("Analysis of Numerical Algorithms","csci5302","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Computational Aspects of Matrix Theory","csci5304","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Computational Complexity","csci5403","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Advanced Algorithms and Data Structures","csci5421","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
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

        String s = "";
        List<String> ls = new ArrayList<String>();
        ls.add(s);

        Requirement req1 = new Requirement(Reqs.BREADTH_REQUIREMENT_MS, 3.25, ctl1, 9, ls);
        reqList.add(req1);


        //REQUIREMENT #2 COLLOQUIUM
        List<CourseTaken> ctl2 = new ArrayList<CourseTaken>();
        CourseTaken ct2 = new CourseTaken(new Course("Colloquium","csci8970","1"),new Term(), Grade.S);
        ctl2.add(ct2);

        Requirement req2 = new Requirement(Reqs.COLLOQUIUM,ctl2,1,ls);
        reqList.add(req2);

        //REQUIREMENT #4 PHD LEVEL COURSES
        List<CourseTaken> ctl3 = new ArrayList<CourseTaken>();
        ctl3.add(new CourseTaken(new Course("Advanced Operating Systems","csci8101","3"),new Term(), Grade.C));
        ctl3.add(new CourseTaken(new Course("Foundations of Distributed Computing","csci8102","3"),new Term(), Grade.C));
        ctl3.add(new CourseTaken(new Course("Understanding the Social Web","csci8117","3"),new Term(), Grade.C));
        ctl3.add(new CourseTaken(new Course("Advanced Compiler Techniques","csci8161","3"),new Term(), Grade.C));
        ctl3.add(new CourseTaken(new Course("Parallel Computer Organization","csci8205","3"),new Term(), Grade.C));
        ctl3.add(new CourseTaken(new Course("Advanced Computer Networks and Their Applications","csci8211","3"),new Term(), Grade.C));
        ctl3.add(new CourseTaken(new Course("Security and Privacy in Computing","csci8271","3"),new Term(), Grade.C));
        ctl3.add(new CourseTaken(new Course("Sparse Matrix Computations","csci8314","3"),new Term(), Grade.C));
        ctl3.add(new CourseTaken(new Course("Numerical Linear Algebra in Data Exploration","csci8363","3"),new Term(), Grade.C));
        ctl3.add(new CourseTaken(new Course("Computational Geometry and Applications","csci8442","3"),new Term(), Grade.C));
        ctl3.add(new CourseTaken(new Course("Intelligent Agents","csci8551","3"),new Term(), Grade.C));
        ctl3.add(new CourseTaken(new Course("Overview of Database Research","csci8701","3"),new Term(), Grade.C));
        ctl3.add(new CourseTaken(new Course("Spatial Databases and Applications","csci8715","3"),new Term(), Grade.C));
        ctl3.add(new CourseTaken(new Course("Databases for Bioinformatics","csci8725","3"),new Term(), Grade.C));
        ctl3.add(new CourseTaken(new Course("Advanced Database Systems","csci8735","3"),new Term(), Grade.C));
        ctl3.add(new CourseTaken(new Course("Advanced Software Engineering","csci8801","3"),new Term(), Grade.C));
        ctl3.add(new CourseTaken(new Course("Special Advanced Topics in Computer Science","csci8980","3"),new Term(), Grade.C));

        Requirement req3 = new Requirement(Reqs.PHD_LEVEL_COURSES,ctl3,3,ls);
        reqList.add(req3);

        //TODO:REQUIREMENT #4 TOTAL CREDITS
        List<CourseTaken> ctl4 = new ArrayList<CourseTaken>();
        CourseTaken ct4 = new CourseTaken(new Course(),new Term(), Grade.C);
        ctl4.add(ct4);

        Requirement req4 = new Requirement(Reqs.TOTAL_CREDITS,3.25,ctl4,31,ls);
        reqList.add(req4);


        //Requirement #5 COMPLETED MILESTONES
        List<CompletedMilestone> lm5 = new ArrayList<CompletedMilestone>();
        lm5.add(new CompletedMilestone(Milestone.DPF_SUBMITTED));
        lm5.add(new CompletedMilestone(Milestone.DPF_APPROVED));
        lm5.add(new CompletedMilestone(Milestone.THESIS_COMMITTEE_APPOINTED));
        lm5.add(new CompletedMilestone(Milestone.GRADUATION_PACKET_REQUESTED));
        lm5.add(new CompletedMilestone(Milestone.THESIS_SUBMITTED));
        lm5.add(new CompletedMilestone(Milestone.THESIS_APPROVED));
        lm5.add(new CompletedMilestone(Milestone.DEFENSE_PASSED));

        Requirement req5 = new Requirement(Reqs.MILESTONES_MS_C,lm5,ls);
        reqList.add(req5);
    }
}
