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

        // REQUIREMENT #1
        List<CourseTaken> ctl1 = new ArrayList<CourseTaken>();
        ctl1.add(new CourseTaken(new Course("Analysis of Numerical Algorithms","csci5302","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Computational Aspects of Matrix Theory","csci5304","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Computational Complexity","csci5403","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Advanced Algorithms and Data Structures","csci5421","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5103","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5104","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5105","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5106","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5161","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5204","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5211","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5221","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5231","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5451","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5461","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5708","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5801","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5802","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5115","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5125","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5271","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5471","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5481","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5511","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5512","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5521","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5523","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5551","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5561","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5607","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5608","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5609","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5611","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5619","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));
        ctl1.add(new CourseTaken(new Course("Machine Learning","csci5707","3",CourseArea.THEORY_ALGORITHMS), new Term(), Grade.C));

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
