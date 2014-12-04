package edu.umn.csci5801.model;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 12/2/2014.
 */
public class MasterA {
    private List<Requirement> reqList;
    public List<Requirement> getReqList() {
        if(reqList == null) {
            setReqList();
        }
        return reqList;
    }
    //TODO: This is where the Requirements for Masters A get inputted into a List
    //TODO: STEP 1 -- Create Requirement
    //TODO: STEP 2 -- Append req to list "reqList.add(req1);"
    //TODO: STEP 3 -- Repeat for all Requirements
    private void setReqList() {
        //public Requirement(String _name_, float _gpa_, List<CourseTaken> _courses_, int _credits_,
                            //List<CompletedMilestone> _milestones_, List<String> _notes_) {

        // REQUIREMENT #1 Breadth Requirement Courses
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
        ls1.add(s);

        Requirement req1 = new Requirement("BREADTH_REQUIREMENT_MS", 3.25f, ctl1, 9, ls);
        reqList.add(req1);

        //REQUIREMENT #2 THESIS_MS

        List<CourseTaken> ctl2 = new ArrayList<CourseTaken>();
        CourseTaken ct2 = new CourseTaken(new Course("Thesis_MS","csci8777","10"),new Term(), Grade.S);
        ctl2.add(ct2);

        Requirement req2 = new Requirement("THESIS_MS",ctl2,10,ls);
        reqList.add(req2);

        //REQUIREMENT #3 COLLOQUIUM
        List<CourseTaken> ctl3 = new ArrayList<CourseTaken>();
        CourseTaken ct3 = new CourseTaken(new Course("Colloquium","csci8970","1"),new Term(), Grade.S);
        ctl3.add(ct3);

        Requirement req3 = new Requirement("COLLOQUIUM",ctl3,1,ls);
        reqList.add(req3);

        //REQUIREMENT #4 PHD LEVEL COURSES
        List<CourseTaken> ctl4 = new ArrayList<CourseTaken>();
        CourseTaken ct4 = new CourseTaken(new Course("PhD level courses","csci8000","3"),new Term(), Grade.C);
        ctl4.add(ct4);

        Requirement req4 = new Requirement("PHD_LEVEL_COURSES",ctl4,3,ls);
        reqList.add(req4);

        //REQUIREMENT #5 TOTAL CREDITS
        List<CourseTaken> ctl5 = new ArrayList<CourseTaken>();
        CourseTaken ct5 = new CourseTaken(new Course(),new Term(), Grade.C);
        ctl5.add(ct5);

        Requirement req5 = new Requirement("TOTAL_CREDITS",3.25f,ctl5,31,ls);
        reqList.add(req5);

        //REQUIREMENT #6 COURSE CREDITS
        List<CourseTaken> ctl6 = new ArrayList<CourseTaken>();
        CourseTaken ct6 = new CourseTaken(new Course(),new Term(), Grade.C);
        ctl6.add(ct6);

        Requirement req6 = new Requirement("COURSE_CREDITS",3.25f,ctl6,22,ls);
        reqList.add(req6);

        //Requirement #7 COMPLETED MILESTONES
        List<CompletedMilestone> lm7 = new ArrayList<CompletedMilestone>();
        lm7.add(new CompletedMilestone(Milestone.DPF_SUBMITTED));
        lm7.add(new CompletedMilestone(Milestone.DPF_APPROVED));
        lm7.add(new CompletedMilestone(Milestone.THESIS_COMMITTEE_APPOINTED));
        lm7.add(new CompletedMilestone(Milestone.GRADUATION_PACKET_REQUESTED));
        lm7.add(new CompletedMilestone(Milestone.THESIS_SUBMITTED));
        lm7.add(new CompletedMilestone(Milestone.THESIS_APPROVED));
        lm7.add(new CompletedMilestone(Milestone.DEFENSE_PASSED));

        Requirement req7 = new Requirement("MILESTONES_MS_A",lm7,ls);
        reqList.add(req7);
    }
}
