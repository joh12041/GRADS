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
        as
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
    public void testGetStudentIDs() throws Exception {

    }

    @Test
    public void testGetTranscript() throws Exception {

    }

    @Test
    public void testUpdateTranscript() throws Exception {

    }

    @Test
    public void testAddNote() throws Exception {

    }

    @Test
    public void testGenerateProgressSummary() throws Exception {

    }

    @Test
    public void testSimulateCourses() throws Exception {

    }
}