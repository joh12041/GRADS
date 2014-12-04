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

        //String n, String i_d, String nc, CourseArea ca

        // REQUIREMENT #1
        List<CourseTaken> ctl1 = new ArrayList<CourseTaken>();
        CourseTaken ct1 = new CourseTaken(new Course("Analysis of Numerical Algorithms","csci5302","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C);
        CourseTaken ct2 = new CourseTaken(new Course("Computational Aspects of Matrix Theory","csci5304","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C);
        ctl1.add(ct1);
        ctl1.add(ct2);

        CompletedMilestone m1 = new CompletedMilestone();
        List<CompletedMilestone> lm1 = new ArrayList<CompletedMilestone>();
        lm1.add(m1);

        String s1 = "";
        List<String> ls1 = new ArrayList<String>();
        ls1.add(s1);

        Requirement req1 = new Requirement("BREADTH_REQUIREMENT_MS", 3.25f, ctl1, 9, lm1, ls1);

        reqList.add(req1);

        //REQUIREMENT #2
        //etc...
    }
}
