package test;

/**
 * Created by Justin on 12/2/2014.
 */
import edu.umn.csci5801.GRADSIntf;
import edu.umn.csci5801.GRADS;
import edu.umn.csci5801.model.CompletedMilestone;
import edu.umn.csci5801.model.Course;
import edu.umn.csci5801.model.CourseArea;
import edu.umn.csci5801.model.CourseTaken;
import edu.umn.csci5801.model.Degree;
import edu.umn.csci5801.model.DegreeRequirement;
import edu.umn.csci5801.model.Department;
import edu.umn.csci5801.model.GradReqCheck;
import edu.umn.csci5801.model.MasterA;
import edu.umn.csci5801.model.MasterB;
import edu.umn.csci5801.model.MasterC;
import edu.umn.csci5801.model.Milestone;
import edu.umn.csci5801.model.PHD;
import edu.umn.csci5801.model.Professor;
import edu.umn.csci5801.model.ProgressSummary;
import edu.umn.csci5801.model.Requirement;
import edu.umn.csci5801.model.Role;
import edu.umn.csci5801.model.Semester;
import edu.umn.csci5801.model.Student;
import edu.umn.csci5801.model.StudentRecord;
import edu.umn.csci5801.model.Term;
import edu.umn.csci5801.model.User;


public class Test_MainDriver {
    public static void main(String [] args) {
        GRADS grads = new GRADS();
        Role role = Role.STUDENT;
        role = Role.GRADUATE_PROGRAM_COORDINATOR;
        System.out.println(role);
        System.out.println("Hello World");
    }
}
