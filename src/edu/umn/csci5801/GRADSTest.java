package edu.umn.csci5801;

import edu.umn.csci5801.model.InvalidUserException;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import edu.umn.csci5801.model.CourseArea;
import edu.umn.csci5801.model.CourseTaken;
import edu.umn.csci5801.model.Grade;
import edu.umn.csci5801.model.Term;
import edu.umn.csci5801.model.Course;
import edu.umn.csci5801.model.StudentRecord;
import edu.umn.csci5801.model.Professor;
import edu.umn.csci5801.model.CompletedMilestone;
import edu.umn.csci5801.model.Milestone;
import edu.umn.csci5801.model.Semester;


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
                sb.append(line.replaceAll("\\s", ""));
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }

    private boolean compareStudentRecords(StudentRecord sr1, StudentRecord sr2) {
        if(!sr1.getStudent().sameStudents(sr2.getStudent())) { // Student
            return false; }
        else if(sr1.getDepartment() != sr2.getDepartment()) { // Department
            return false; }
        else if(sr1.getDegreeSought() != sr2.getDegreeSought()) { // degreeSought
            return false; }
        else if(!sr1.getTermBegan().sameTerm(sr2.getTermBegan())) { // termBegan
            return false; }
        else if(!compareProfessorList(sr1.getAdvisors(), sr2.getAdvisors())) { // advisors
            return false; }
        else if(!compareProfessorList(sr1.getCommittee(), sr2.getCommittee())) { // committee
            return false; }
        else if(!compareCoursesTaken(sr1.getCoursesTaken(), sr2.getCoursesTaken())) { // coursesTaken
            return false; }
        else if(!compareMilestonesList(sr1.getMilestonesSet(), sr2.getMilestonesSet())) { // milestonesSet
            return false; }
        else if(!compareNotesList(sr1.getNotes(), sr2.getNotes())) { // notes
            return false; }
        return true;
    }

    private boolean compareNotesList(List<String> l1, List<String> l2) {
        if(l1.isEmpty() && l2.isEmpty()) {
            return true; }
        else if(l1.isEmpty() || l2.isEmpty()) {
            return false; }
        if(l1.size() != l2.size()) {
            return false; }
        for(int i=0; i< l1.size(); i++) {
            if(!l2.get(i).equals(l2.get(i))) {
                return false; }
        }
        return true;
    }

    private boolean compareMilestonesList(List<CompletedMilestone> l1, List<CompletedMilestone> l2) {
        if(l1.isEmpty() && l2.isEmpty()) {
            return true; }
        else if(l1.isEmpty() || l2.isEmpty()) {
            return false; }
        if(l1.size() != l2.size()) {
            return false; }
        for(int i=0; i< l1.size(); i++) {
            if(!l1.get(i).compareCompletedMilestone(l2.get(i))) {
                return false; }
        }
        return true;
    }

    private boolean compareProfessorList(List<Professor> l1, List<Professor> l2) {
        if(l1.isEmpty() && l2.isEmpty()) {
            return true; }
        else if(l1.isEmpty() || l2.isEmpty()) {
            return false; }
        if(l1.size() != l2.size()) {
            return false; }
        for(int i=0; i< l1.size(); i++) {
            if(!l1.get(i).compareProfessor(l2.get(i))) {
                return false; }
        }
        return true;
    }

    private boolean compareCoursesTaken(List<CourseTaken> l1, List<CourseTaken> l2) {
        if(l1.isEmpty() && l2.isEmpty()) {
            return true; }
        else if(l1.isEmpty() || l2.isEmpty()) {
            return false; }
        if(l1.size() != l2.size()) {
            return false; }
        for(int i=0; i< l1.size(); i++) {
            if(!l1.get(i).compareCourseTaken(l2.get(i))) {
                return false; }
        }
        return true;
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

    @Test
    public void testStudentGetStudentIDs() throws Exception {
        try {
            GRADS grads = new GRADS();
            grads.loadUsers("resources/users.txt");
            grads.loadRecords("resources/courses.txt");
            grads.setUser("nguy0621");
            grads.getStudentIDs();
            fail("Should throw Invalid User Exception");
        } catch (InvalidUserException e) {
            assertTrue(e.getMessage().equals("User does not have this access to Student IDs"));
        }
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

    @Test
    public void testStudentGenerateOtherProgressSummary() throws Exception {
        try {
            GRADS grads = new GRADS();
            grads.loadUsers("resources/users.txt");
            grads.loadCourses("resources/courses.txt");
            grads.loadRecords("resources/students.txt");
            grads.setUser("zhang9101");
            grads.generateProgressSummary("doe5678");
            fail("Student can't generate another student's progress summary");
        } catch (InvalidUserException e) {
            assertTrue(e.getMessage().equals("Invalid user"));
        }

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
        try {
            GRADS grads = new GRADS();
            List<CourseTaken> coursesTaken = Arrays.asList();
            grads.loadUsers("resources/users.txt");
            grads.loadCourses("resources/courses.txt");
            grads.loadRecords("resources/students.txt");
            grads.setUser("zhang9101");
            grads.simulateCourses("doe5678", coursesTaken);
        } catch (InvalidUserException e) {
            assertTrue(e.getMessage().equals("Invalid user"));
        }
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
        GRADS grads = new GRADS();
        Term f15 = new Term();
        f15.setSemester("FALL");
        f15.setYear(2015);
        Course csci8980 = new Course("Special Advanced Topics in Computer Science", "csci8980", "3");
        CourseTaken csci8980f15 = new CourseTaken(csci8980, f15, Grade.B);
        Course math5335 = new Course("MATH 5335", "math5335", "4");
        CourseTaken math5335f15 = new CourseTaken(math5335, f15, Grade.A);
        Course math5336 = new Course("MATH 5336", "math5336", "3");
        CourseTaken math5336f15 = new CourseTaken(math5336, f15, Grade.A);
        Course csci5512 = new Course("Artificial Intelligence II", "csci5512", "3", CourseArea.APPLICATIONS);
        CourseTaken csci5512f15 = new CourseTaken(csci5512, f15, Grade.B);
        Course cs8970 = new Course("Computer Science Colloquium", "csci8970", "1");
        CourseTaken cs8970f15 = new CourseTaken(cs8970, f15, Grade.S);
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/students.txt");
        List<CourseTaken> coursesTaken =  Arrays.asList(csci8980f15, math5335f15, math5336f15, csci5512f15, cs8970f15);
        grads.setUser("zhang9101");
        grads.simulateCourses("zhang9101", coursesTaken);
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
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/students.txt");
        grads.setUser("tolas9999");
        StudentRecord studentRecord = grads.getTranscript("zhang9101");
        studentRecord.addMilestonesSet(new CompletedMilestone(Milestone.PRELIM_COMMITTEE_APPOINTED, new Term(Semester.FALL, 2014)));
        grads.updateTranscript("zhang9101", studentRecord);
        StudentRecord newTranscript = grads.getTranscript("zhang9101");
        // Compare to:
        GRADS grads1 = new GRADS();
        grads1.loadUsers("resources/users.txt");
        grads1.loadRecords("resources/testGPCAddMilestone.txt");
        grads1.setUser("tolas9999");  // CSCI GPC
        StudentRecord compareTranscript = grads1.getTranscript("zhang9101");

        assert(compareStudentRecords(newTranscript, compareTranscript));
        //assert(compareStudentRecords(compareTranscript, compareTranscript));
        //assert(compareStudentRecords(newTranscript, newTranscript));
        //assert(true);
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