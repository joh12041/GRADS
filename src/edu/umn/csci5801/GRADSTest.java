package edu.umn.csci5801;

import edu.umn.csci5801.model.InvalidUserException;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import edu.umn.csci5801.model.CourseTaken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GRADSTest extends TestCase {

    private String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line.replaceAll("\\s",""));
                line = br.readLine();
            }
            return sb.toString();
            } finally {
            br.close();
        }
    }

    @Test
    public void testLoadUsers() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
    }

    @Test(expected = IOException.class)
    public void textExceptionThrownLoadUsers() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/not_a_file.txt");
    }

    @Test
    public void testLoadCourses() throws Exception {
    	GRADS grads = new GRADS();
    	grads.loadCourses("resources/courses.txt");
    }

    @Test(expected = IOException.class)
    public void testExceptionThrownLoadCourses() throws Exception {
        GRADS grads = new GRADS();
        grads.loadCourses("resources/not_a_file.txt");
    }
    @Test
    public void testLoadRecords() throws Exception {
    	GRADS grads = new GRADS();
    	grads.loadRecords("resources/students.txt");
    }

    @Test(expected = IOException.class)
    public void testExceptionThrownLoadRecords() throws Exception {
        GRADS grads = new GRADS();
        grads.loadRecords("resources/not_a_file.txt");
    }

    @Test
    public void testSetUser() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
        grads.setUser("tolas9999");
    }

    @Test
    public void testGetUser() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
        grads.setUser("tolas9999");
        assertEquals("tolas9999",grads.getUser());
    }

    @Test
    public void testGPCGetStudentIDs() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
        grads.loadRecords("resources/students.txt");
        grads.setUser("tolas9999");
        grads.getStudentIDs();
        String expectedOutputString = "[\"smith1234\",\"doe5678\",\"nguy0621\",\"gayxx067\",\"bob099\",\"desil1337\",\"hanxx123\"]";
        assertEquals(expectedOutputString,readFile("studentids.txt"));
    }
    
    @Test(expected = InvalidUserException.class)
    public void testStudentGetStudentIDs() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
        grads.loadRecords("resources/courses.txt");
        grads.setUser("nguy0621");
        grads.getStudentIDs();
    }

    @Test
    public void testStudentGetOwnTranscript() throws Exception {

    }

    @Test
    public void testStudentGetOtherTranscript() throws Exception {

    }
    
    @Test
    public void testGPCGetTranscript() throws Exception {

    }
    
    @Test
    public void testStudentUpdateTranscript() throws Exception {

    }
    
    @Test
    public void testGPCUpdateTranscript() throws Exception {

    }

    @Test
    public void testStudentAddNote() throws Exception {

    }
    
    @Test
    public void testGPCAddNote() throws Exception {

    }

    @Test
    public void testStudentGenerateOwnProgressSummary() throws Exception {
    	GRADS grads = new GRADS();
    	grads.loadUsers("resources/users.txt");
    	grads.loadCourses("resources/courses.txt");
    	grads.loadRecords("resources/students.txt");
    	grads.setUser("zhang9101");
    	grads.generateProgressSummary("zhang9101");
    }
    
    @Test(expected = InvalidUserException.class)
    public void testStudentGenerateOtherProgressSummary() throws Exception {
    	GRADS grads = new GRADS();
    	grads.loadUsers("resources/users.txt");
    	grads.loadCourses("resources/courses.txt");
    	grads.loadRecords("resources/students.txt");
    	grads.setUser("zhang9101");
    	grads.generateProgressSummary("doe5678");
    }
    
    @Test
    public void testGPCGenerateProgressSummary() throws Exception {
    	GRADS grads = new GRADS();
    	grads.loadUsers("resources/users.txt");
    	grads.loadCourses("resources/courses.txt");
    	grads.loadRecords("resources/students.txt");
    	grads.setUser("tolas9999");
    	grads.generateProgressSummary("zhang9101");
    }

    @Test
    public void testStudentSimulateOwnCourses() throws Exception {
    	GRADS grads = new GRADS();
    	List<CourseTaken> coursesTaken =  Arrays.asList();
    	grads.loadUsers("resources/users.txt");
    	grads.loadCourses("resources/courses.txt");
    	grads.loadRecords("resources/students.txt");
    	grads.setUser("zhang9101");
    	grads.simulateCourses("zhang9101", coursesTaken);
    }
    
    @Test
    public void testStudentSimulateOtherCourses() throws Exception {
    	GRADS grads = new GRADS();
    	List<CourseTaken> coursesTaken =  Arrays.asList();
    	grads.loadUsers("resources/users.txt");
    	grads.loadCourses("resources/courses.txt");
    	grads.loadRecords("resources/students.txt");
    	grads.setUser("zhang9101");
    	grads.simulateCourses("doe5678", coursesTaken);
    }
    
    @Test
    public void testGPCSimulateCourses() throws Exception {
    	GRADS grads = new GRADS();
    	List<CourseTaken> coursesTaken =  Arrays.asList();
    	grads.loadUsers("resources/users.txt");
    	grads.loadCourses("resources/courses.txt");
    	grads.loadRecords("resources/students.txt");
    	grads.setUser("tolas9999");
    	grads.simulateCourses("zhang9101", coursesTaken);
    }
    
    @Test
    //GPA below PhD req, rest met
    public void testPhDSimulateCoursesLowGPA() throws Exception {
    	GRADS grads = new GRADS();
    	List<CourseTaken> coursesTaken =  Arrays.asList();
    	grads.loadUsers("resources/users.txt");
    	grads.loadCourses("resources/courses.txt");
    	grads.loadRecords("resources/students.txt");
    	grads.setUser("smith1234");
    	grads.simulateCourses("smith1234", coursesTaken);
    }
    
    @Test
    //GPA below Master req, rest met
    public void testMasterSimulateCoursesLowGPA() throws Exception {
    	GRADS grads = new GRADS();
    	List<CourseTaken> coursesTaken =  Arrays.asList();
    	grads.loadUsers("resources/users.txt");
    	grads.loadCourses("resources/courses.txt");
    	grads.loadRecords("resources/studentsJohnMastersA.txt");
    	grads.setUser("smith1234");
    	grads.simulateCourses("smith1234", coursesTaken);
    }
    
    @Test
    //PhD doesn't meet thesis credit, rest met
    public void testPhDSimulateCoursesThesisCredit() throws Exception {
    	GRADS grads = new GRADS();
    	List<CourseTaken> coursesTaken =  Arrays.asList();
    	grads.loadUsers("resources/users.txt");
    	grads.loadCourses("resources/courses.txt");
    	grads.loadRecords("resources/studentsJanePhd.txt");
    	grads.setUser("doe5678");
    	grads.simulateCourses("doe5678", coursesTaken);
    }
    
    @Test
    //All requirements met
    public void testMasterSimulateCoursesAllMet() throws Exception {
    	GRADS grads = new GRADS();
    	List<CourseTaken> coursesTaken =  Arrays.asList();
    	grads.loadUsers("resources/users.txt");
    	grads.loadCourses("resources/courses.txt");
    	grads.loadRecords("resources/students.txt");
    	grads.setUser("doe5678");
    	grads.simulateCourses("doe5678", coursesTaken);
    }
    
    @Test
    //PhD adds courses to meet necessary requirements
    public void testPhDSimulateCoursesNewCourse() throws Exception {
    	/*GRADS grads = new GRADS();
    	List<CourseTaken> coursesTaken =  Arrays.asList("csci8980", "math5335");
    	grads.loadUsers("resources/users.txt");
    	grads.loadCourses("resources/courses.txt");
    	grads.loadRecords("resources/students.txt");
    	grads.setUser("zhang9101");
    	grads.simulateCourses("zhang9101", coursesTaken);*/
    }
    
    @Test
    //MastersA adds courses to meet necessary requirements except 8000 level
    public void testMasterSimulateCoursesNewCourse() throws Exception {

    }
    
    @Test
    //MastersA doesn't meet credits, 8000-level, or Colloquium
    public void testMasterSimulateCoursesNew() throws Exception {

    }
    
    @Test
    public void testGPCAddMilestone() throws Exception {

    }
    
    @Test
    public void testGPCChangeMilestone() throws Exception {

    }
    
    @Test
    public void testGPCChangeAdvisor() throws Exception {

    }
    
    @Test
    //PhD or Plan B student
    public void testStudentAuthorizedChangeAdvisor() throws Exception {

    }
    
    @Test
    //PhD or Plan B student
    public void testStudentUnauthorizedChangeAdvisor() throws Exception {

    }
    
    @Test
    //PhD, Plan A, or Plan C
    public void testGPCChangeCommittee() throws Exception {

    }
    
    @Test
    //PhD, Plan A, or Plan C
    public void testStudentAuthorizedChangeCommittee() throws Exception {

    }
    
    @Test
    //PhD, Plan A, or Plan C
    public void testStudentUnauthorizedChangeCommittee() throws Exception {

    }
    
    @Test
    public void testGPCChangeGrade() throws Exception {

    }
    
    @Test
    public void testStudentChangeGrade() throws Exception {

    }
    
    @Test
    public void testGPCAllowCourse() throws Exception {

    }
    
    @Test
    public void testStudentAllowCourse() throws Exception {

    }
    
}