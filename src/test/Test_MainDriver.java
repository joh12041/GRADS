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
import java.io.FileReader;
import java.io.File;


public class Test_MainDriver {
    public static void main(String [] args) throws Exception {
        FileReader fr = new FileReader("studentids.txt");
        char[] a = new char[500];
        fr.read(a);
        System.out.println(a);
        //System.out.println(new FileReader("studentids.txt").read());
        //GRADS grads = new GRADS();
        //Role role = Role.STUDENT;
        //role = Role.GRADUATE_PROGRAM_COORDINATOR;
        //System.out.println(role);
        //System.out.println("Hello World");
        //System.out.println("Working Directory = " +
        //        System.getProperty("user.dir"));
        //grads.loadUsers("resources/users.txt");
        //grads.loadCourses("resources/courses.txt");
        //grads.loadRecords("resources/students.txt");
        //grads.setUser("tolas9999");
        //grads.getUser();
        //grads.getStudentIDs();
        //ProgressSummary ps = new ProgressSummary();
        //ps = grads.generateProgressSummary("desil1337");
        //grads.simulateCourses("nguy0621",ps.getCoursesTaken());
    }
}
