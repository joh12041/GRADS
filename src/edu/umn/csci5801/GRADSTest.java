package edu.umn.csci5801;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GRADSTest extends TestCase {

    @Test
    public void testLoadUsers() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/users.txt");
    }

    @Test
    public void textExceptionThrownLoadUsers() throws Exception {
        GRADS grads = new GRADS();
        grads.loadUsers("resources/not_a_file.txt");
    }

    @Test
    public void testLoadCourses() throws Exception {

    }

    @Test
    public void testLoadRecords() throws Exception {

    }

    @Test
    public void testSetUser() throws Exception {

    }

    @Test
    public void testGetUser() throws Exception {

    }

    @Test
    public void testGPCGetStudentIDs() throws Exception {

    }
    
    @Test
    public void testStudentGetStudentIDs() throws Exception {

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

    }
    
    @Test
    public void testStudentGenerateOtherProgressSummary() throws Exception {

    }
    
    @Test
    public void testGPCGenerateProgressSummary() throws Exception {

    }

    @Test
    public void testStudentSimulateOwnCourses() throws Exception {

    }
    
    @Test
    public void testStudentSimulateOtherCourses() throws Exception {

    }
    
    @Test
    public void testGPCSimulateCourses() throws Exception {

    }
    
    //TODO: Insert specific requirements for Test Case 3.1.2 to 3.1.8
}