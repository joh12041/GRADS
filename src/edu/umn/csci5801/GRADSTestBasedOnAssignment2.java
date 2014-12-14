package edu.umn.csci5801;

import edu.umn.csci5801.model.*;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GRADSTestBasedOnAssignment2 extends TestCase {

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
        grads.loadRecords("resources/students_original.txt");
        grads.setUser("tolas9999");
        grads.getStudentIDs();
        String expectedOutputString = "[\"smith1234\",\"doe5678\",\"nguy0621\",\"gayxx067\",\"bob099\",\"desil1337\",\"hanxx123\",\"zhang9101\"]";
        assertEquals(expectedOutputString,readFile("studentids.txt"));
    }

    @Test
    
    public void testStudentGetStudentIDs() throws Exception {
        try {
            GRADS grads = new GRADS();
            grads.loadUsers("resources/users.txt");
            grads.loadRecords("resources/students_original.txt");
            grads.setUser("nguy0621");
            grads.getStudentIDs();
            fail("Should throw Invalid User Exception");
        } catch (InvalidUserException e) {
            assertTrue(e.getMessage().equals("User does not have this access to Student IDs"));
        }
    }

    @Test
    public void testStudentGetOwnTranscript() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/students_original.txt");
        grads.setUser("hanxx123");
        StudentRecord transcript = grads.getTranscript("hanxx123");

        // Compare to:
        GRADS grads1 = new GRADS();
        grads1.loadUsers("resources/users.txt");
        grads1.loadRecords("resources/testGPCAddMilestone.txt");
        grads1.setUser("tolas9999");  // CSCI GPC
        StudentRecord compareTranscript = grads1.getTranscript("hanxx123");

        assert(compareStudentRecords(transcript, compareTranscript));
    }

    //@Test(expected = InvalidUserException.class)
    //@Test(expected = Exception.class)
    @Test(expected = IOException.class)
    public void testStudentGetOtherTranscript() throws Exception {
        try {
            GRADS grads = new GRADS();
            grads.loadUsers("resources/users.txt");
            grads.loadCourses("resources/courses.txt");
            grads.loadRecords("resources/students_original.txt");
            grads.setUser("smith1234");
            grads.getTranscript("hanxx123");
            fail("Should throw Invalid User Exception");
        } catch (InvalidUserException e) {
            assertTrue(e.getMessage().equals("Invalid user"));
        }
    }

    @Test
    public void testGPCGetTranscript() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/students_original.txt");
        grads.setUser("hanxx123");
        StudentRecord transcript = grads.getTranscript("hanxx123");

        // Compare to:
        GRADS grads1 = new GRADS();
        grads1.loadUsers("resources/users.txt");
        grads1.loadRecords("resources/students_original.txt");
        grads1.setUser("tolas9999");  // CSCI GPC
        StudentRecord compareTranscript = grads1.getTranscript("hanxx123");

        assert(compareStudentRecords(transcript, compareTranscript));
    }

    @Test
    public void testStudentUpdateTranscript() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/students_original.txt");
        grads.setUser("hanxx123");

        StudentRecord studentRecord = grads.getTranscript("hanxx123");
        List<Professor> professorList = studentRecord.getAdvisors();
        Professor professor = new Professor(Department.MATH, professorList.get(0).getFirstName(), professorList.get(0).getLastName());
        professorList.set(0, professor);

        studentRecord.setAdvisors(professorList);
        grads.updateTranscript("hanxx123", studentRecord);
        StudentRecord newTranscript = grads.getTranscript("hanxx123");

        // Compare to:
        GRADS grads1 = new GRADS();
        grads1.loadUsers("resources/users.txt");
        grads1.loadRecords("resources/testGPCChangeAdvisor.txt");
        grads1.setUser("hanxx123");  // CSCI GPC
        StudentRecord compareTranscript = grads1.getTranscript("hanxx123");

        assert(compareStudentRecords(newTranscript, compareTranscript));
    }

    @Test
    public void testGPCUpdateTranscript() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/students_original.txt");
        grads.setUser("tolas9999");

        StudentRecord studentRecord = grads.getTranscript("hanxx123");
        List<Professor> professorList = studentRecord.getAdvisors();
        Professor professor = new Professor(Department.MATH, professorList.get(0).getFirstName(), professorList.get(0).getLastName());
        professorList.set(0, professor);

        studentRecord.setAdvisors(professorList);
        grads.updateTranscript("hanxx123", studentRecord);
        StudentRecord newTranscript = grads.getTranscript("hanxx123");

        // Compare to:
        GRADS grads1 = new GRADS();
        grads1.loadUsers("resources/users.txt");
        grads1.loadRecords("resources/testGPCChangeAdvisor.txt");
        grads1.setUser("tolas9999");  // CSCI GPC
        StudentRecord compareTranscript = grads1.getTranscript("hanxx123");

        assert(compareStudentRecords(newTranscript, compareTranscript));
    }

    @Test
    public void testGPCAddNote() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/students_original.txt");
        grads.setUser("tolas9999");
        grads.addNote("hanxx123", "note4");
        StudentRecord newTranscript = grads.getTranscript("hanxx123");

        // Compare to:
        GRADS grads1 = new GRADS();
        grads1.loadUsers("resources/users.txt");
        grads1.loadRecords("resources/testAddNote.txt");
        grads1.setUser("tolas9999");  // CSCI GPC
        StudentRecord compareTranscript = grads1.getTranscript("hanxx123");

        assert(compareStudentRecords(newTranscript, compareTranscript));
    }

    //can't think of any way to assert this easily
    @Test
    public void testStudentGenerateOwnProgressSummary() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/students_original.txt");
        grads.setUser("zhang9101");
        grads.generateProgressSummary("zhang9101");
    }

    @Test
    public void testStudentGenerateOtherProgressSummary() throws Exception {
        try {
            GRADS grads = new GRADS();
            grads.loadUsers("resources/users.txt");
            grads.loadCourses("resources/courses.txt");
            grads.loadRecords("resources/students_original.txt");
            grads.setUser("zhang9101");
            grads.generateProgressSummary("doe5678");
            fail("Student can't generate another student's progress summary");
        } catch (InvalidUserException e) {
            assertTrue(e.getMessage().equals("Invalid user"));
        }

    }

    //no good way to test correctness
    @Test
    public void testGPCGenerateProgressSummary() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/students_original.txt");
        grads.setUser("tolas9999");
        grads.generateProgressSummary("zhang9101");
    }

    //needs second check with courses already added to a students_original.txt transcript and then compare function
    @Test
    public void testStudentSimulateOwnCourses() throws Exception {
        GRADS grads = new GRADS();
        List<CourseTaken> coursesTaken =  Arrays.asList();
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/students_original.txt");
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
            grads.loadRecords("resources/students_original.txt");
            grads.setUser("zhang9101");
            grads.simulateCourses("doe5678", coursesTaken);
        } catch (InvalidUserException e) {
            assertTrue(e.getMessage().equals("Invalid user"));
        }
    }

    //see test two above for student
    @Test
    public void testGPCSimulateCourses() throws Exception {
        GRADS grads = new GRADS();
        List<CourseTaken> coursesTaken =  Arrays.asList();
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/students_original.txt");
        grads.setUser("tolas9999");
        grads.simulateCourses("zhang9101", coursesTaken);
    }

    @Test
    //maybe check the GPA specifically?
    //GPA below PhD req, rest met
    public void testPhDSimulateCoursesLowGPA() throws Exception {
        GRADS grads = new GRADS();
        List<CourseTaken> coursesTaken =  Arrays.asList();
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/students_original.txt");
        grads.setUser("smith1234");
        grads.simulateCourses("smith1234", coursesTaken);
    }

    @Test
    //maybe check the GPA specifically?
    //GPA below Master req, rest met
    public void testMasterSimulateCoursesLowGPA() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/studentsJohnMastersA.txt");
        grads.setUser("smith1234");
        StudentRecord sr = grads.getTranscript("smith1234");
        sr.setDegreeSought(Degree.MS_C);
        grads.updateTranscript("smith1234",sr);
        grads.generateProgressSummary("smith1234");
    }

    @Test
    //maybe check the thesis credit directly?
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
    //how to test?
    //All requirements met
    public void testMasterSimulateCoursesAllMet() throws Exception {
        GRADS grads = new GRADS();
        List<CourseTaken> coursesTaken =  Arrays.asList();
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/students_original.txt");
        grads.setUser("doe5678");
        grads.simulateCourses("doe5678", coursesTaken);
    }

    @Test
    //how to test?
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
        grads.loadRecords("resources/students_original.txt");
        List<CourseTaken> coursesTaken =  Arrays.asList(csci8980f15, math5335f15, math5336f15, csci5512f15, cs8970f15);
        grads.setUser("zhang9101");
        grads.simulateCourses("zhang9101", coursesTaken);
    }

    @Test
    public void testGPCAddMilestone() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/students_original.txt");
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
    }

    @Test
    public void testGPCChangeMilestone() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/students_original.txt");
        grads.setUser("tolas9999");
        StudentRecord studentRecord = grads.getTranscript("hanxx123");

        List<CompletedMilestone> milestoneList = studentRecord.getMilestonesSet();
        int year = milestoneList.get(0).getTerm().getYear() - 1;
        Milestone milestone = milestoneList.get(0).getMilestone();
        Term term = new Term(milestoneList.get(0).getTerm().getSemester(), year);
        milestoneList.set(0, new CompletedMilestone(milestone, term));

        studentRecord.setMilestonesSet(milestoneList);
        grads.updateTranscript("hanxx123", studentRecord);
        StudentRecord newTranscript = grads.getTranscript("hanxx123");

        // Compare to:
        GRADS grads1 = new GRADS();
        grads1.loadUsers("resources/users.txt");
        grads1.loadRecords("resources/testGPCChangeMilestone.txt");
        grads1.setUser("tolas9999");  // CSCI GPC
        StudentRecord compareTranscript = grads1.getTranscript("hanxx123");

        assert(compareStudentRecords(newTranscript, compareTranscript));
    }

    @Test
    public void testGPCChangeAdvisor() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/students_original.txt");
        grads.setUser("tolas9999");

        StudentRecord studentRecord = grads.getTranscript("desil1337");
        studentRecord.addAdvisor(new Professor(Department.COMPUTER_SCIENCE, "Will", "Smith"));
        grads.updateTranscript("desil1337", studentRecord);
        StudentRecord newTranscript = grads.getTranscript("desil1337");

        // Compare to:
        GRADS grads1 = new GRADS();
        grads1.loadUsers("resources/users.txt");
        grads1.loadRecords("resources/testAddAdvisor.txt");
        grads1.setUser("tolas9999");  // CSCI GPC
        StudentRecord compareTranscript = grads1.getTranscript("desil1337");

        assert(compareStudentRecords(newTranscript, compareTranscript));
    }

    @Test
    //PhD or Plan B student
    public void testStudentAuthorizedChangeAdvisor() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/students_original.txt");
        grads.setUser("desil1337");

        StudentRecord studentRecord = grads.getTranscript("desil1337");
        studentRecord.addAdvisor(new Professor(Department.COMPUTER_SCIENCE, "Will", "Smith"));
        grads.updateTranscript("desil1337", studentRecord);
        StudentRecord newTranscript = grads.getTranscript("desil1337");

        // Compare to:
        GRADS grads1 = new GRADS();
        grads1.loadUsers("resources/users.txt");
        grads1.loadRecords("resources/testAddAdvisor.txt");
        grads1.setUser("desil1337");  // CSCI GPC
        StudentRecord compareTranscript = grads1.getTranscript("desil1337");

        assert(compareStudentRecords(newTranscript, compareTranscript));
    }

    @Test
    //try/catch clause needed
    //PhD or Plan B student
    public void testStudentUnauthorizedChangeAdvisor() throws Exception {
        try {
            GRADS grads = new GRADS();
            List<CourseTaken> coursesTaken = Arrays.asList();
            grads.loadUsers("resources/users.txt");
            grads.loadCourses("resources/courses.txt");
            grads.loadRecords("resources/students_original.txt");
            grads.setUser("zhang9101");
            StudentRecord studentRecord = grads.getTranscript("gayxx067");
            studentRecord.addAdvisor(new Professor(Department.MATH, "Will", "Smith"));
            grads.updateTranscript("gayxx067", studentRecord);
        } catch (InvalidUserException e) {
            assertTrue(e.getMessage().equals("Invalid user"));
        }
    }

    @Test
    //delete? or write similar to ones above
    //PhD, Plan A, or Plan C
    public void testGPCChangeCommittee() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/students_original.txt");
        grads.setUser("tolas9999");

        StudentRecord studentRecord = grads.getTranscript("nguy0621");
        studentRecord.addCommitteeMember(new Professor(Department.COMPUTER_SCIENCE, "Iron", "Man"));
        grads.updateTranscript("nguy0621", studentRecord);
        StudentRecord newTranscript = grads.getTranscript("nguy0621");

        // Compare to:
        GRADS grads1 = new GRADS();
        grads1.loadUsers("resources/users.txt");
        grads1.loadRecords("resources/testAddAdvisor.txt");
        grads1.setUser("tolas9999");  // CSCI GPC
        StudentRecord compareTranscript = grads1.getTranscript("nguy0621");

        assert(compareStudentRecords(newTranscript, compareTranscript));
    }

    @Test
    //delete?
    //PhD, Plan A, or Plan C
    public void testStudentAuthorizedChangeCommittee() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/students_original.txt");
        grads.setUser("nguy0621");

        StudentRecord studentRecord = grads.getTranscript("nguy0621");
        studentRecord.addCommitteeMember(new Professor(Department.COMPUTER_SCIENCE, "Iron", "Man"));
        grads.updateTranscript("nguy0621", studentRecord);
        StudentRecord newTranscript = grads.getTranscript("nguy0621");

        // Compare to:
        GRADS grads1 = new GRADS();
        grads1.loadUsers("resources/users.txt");
        grads1.loadRecords("resources/testAddAdvisor.txt");
        grads1.setUser("nguy0621");  // CSCI GPC
        StudentRecord compareTranscript = grads1.getTranscript("nguy0621");

        assert(compareStudentRecords(newTranscript, compareTranscript));
    }

    @Test
    //try/catch clause if this is needed
    //PhD, Plan A, or Plan C
    public void testStudentUnauthorizedChangeCommittee() throws Exception {
        try {
            GRADS grads = new GRADS();
            grads.loadUsers("resources/users.txt");
            grads.loadCourses("resources/courses.txt");
            grads.loadRecords("resources/students_original.txt");
            grads.setUser("gayxx067");

            StudentRecord studentRecord = grads.getTranscript("nguy0621");
            studentRecord.addCommitteeMember(new Professor(Department.COMPUTER_SCIENCE, "Iron", "Man"));
            grads.updateTranscript("nguy0621", studentRecord);
        } catch (InvalidUserException e) {
            assertTrue(e.getMessage().equals("Invalid user"));
        }
    }
    //desil1337
    //tolas9999
    @Test
    //need to fix this
    public void testGPCChangeGrade() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/students_original.txt");
        grads.setUser("tolas9999");

        StudentRecord studentRecord = grads.getTranscript("desil1337");
        List<CourseTaken> courseTakenList = studentRecord.getCoursesTaken();
        Course course = courseTakenList.get(0).getCourse();
        Term term = courseTakenList.get(0).getTerm();
        courseTakenList.set(0, new CourseTaken(course, term, Grade.A));
        studentRecord.setCoursesTaken(courseTakenList);
        grads.updateTranscript("desil1337", studentRecord);
        StudentRecord newTranscript = grads.getTranscript("desil1337");

        // Compare to:
        GRADS grads1 = new GRADS();
        grads1.loadUsers("resources/users.txt");
        grads1.loadRecords("resources/testChangeGrade.txt");
        grads1.setUser("tolas9999");  // CSCI GPC
        StudentRecord compareTranscript = grads1.getTranscript("desil1337");

        assert(compareStudentRecords(newTranscript, compareTranscript));
    }

    @Test
    //new test not found in requirements - ooh we found a bug!
    public void testEmptyStudentRecordProgressReport() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
        grads.loadCourses("resources/courses.txt");
        grads.loadRecords("resources/studentsJohnMastersA.txt");
        grads.setUser("tolas9999");
        StudentRecord oldSR = grads.getTranscript("smith1234");
        Student s = oldSR.getStudent();
        Department d = oldSR.getDepartment();
        Degree dS = Degree.MS_B;
        Term tB = oldSR.getTermBegan();
        List<Professor> advs = oldSR.getAdvisors();
        List<Professor> comm = oldSR.getCommittee();
        List<CourseTaken> coursesTaken =  null;
        List<String> notes = oldSR.getNotes();
        StudentRecord sr = new StudentRecord(s, d, dS, tB, advs, comm, coursesTaken, notes);
        grads.updateTranscript("smith1234",sr);
        grads.generateProgressSummary("smith1234");
    }

}