/**
 * Copyright 2014 CSCI5801 Fall2014 Group1
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package edu.umn.csci5801;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import edu.umn.csci5801.model.*;
import edu.umn.csci5801.GRADSIntf;


/**
 * GRADS.java - Class implementing the GRADS interface,
 * which contains all methods available in an API accessible
 * to those who implement other systems interacting with GRADS
 *
 * @author CSCI5801 Fall2014 Group1
 * @version 1.0
 */
public class GRADS implements GRADSIntf {

    private List<User> userList;
    public User currentUser;
    private List<Course> courseList;
    private List<StudentRecord> recordList;

    /**
     * loadUsers() - Loads the list of system usernames and permissions.
     *
     * @param usersFile the filename of the users file.
     * @throws Exception for I/O errors.  SEE NOTE IN CLASS HEADER.
     */
    public void loadUsers(String usersFile) throws IOException{
        try {
            List<User> users = new Gson().fromJson( new FileReader( new File(usersFile)), new TypeToken<List<User>>(){}.getType());
            this.userList = users;
        } catch (IOException ioException) {
            System.out.println("IO Exception while Loading Users");
        }
    }

    /**
     * loadCourses() - Loads the list of courses.
     *
     * @param coursesFile the filename of the users file.
     * @throws Exception for I/O errors.  SEE NOTE IN CLASS HEADER.
     */
    public void loadCourses(String coursesFile) throws Exception{
        try {
            List<Course> courses = new Gson().fromJson( new FileReader( new File(coursesFile)), new TypeToken<List<Course>>(){}.getType());
            this.courseList = courses;
        } catch (IOException ioException) {
            System.out.println("IO Exception while Loading Courses");
        }
    }

    /**
     * loadRecords() - Loads the list of system transcripts.
     *
     * @param recordsFile the filename of the transcripts file.
     * @throws Exception for I/O errors.  SEE NOTE IN CLASS HEADER.
     */
    public void loadRecords(String recordsFile) throws Exception {
        try {
            List<StudentRecord> records = new Gson().fromJson( new FileReader( new File(recordsFile)), new TypeToken<List<StudentRecord>>(){}.getType());
            this.recordList = records;
        } catch (IOException ioException) {
            System.out.println("IO Exception while Loading Records");
        }
    }

    /**
     * setUser() - Sets the user id (X500) of the user currently using the system.
     *
     * @param userId  the X500 id of the user generating progress summaries.
     * @throws Exception  if the user id is invalid.  SEE NOTE IN CLASS HEADER.
     */
    public void setUser(String userId) throws Exception {
        if(userList == null) {
            Exception exception = new Exception();
            throw exception;
        }
        else {
            boolean assigned = false;
            for (User u : userList) {
                if (userId.equals(u.getId())) {
                    this.currentUser = u;
                    assigned = true;
                }
            }
            if (!assigned) {
                Exception exception = new Exception();
                throw exception;
            }
        }
    }

    /**
     * getUser() - Gets the user id of the user currently using the system.
     *
     * @return  the X500 user id of the user currently using the system.
     */
    public String getUser() {
        if(this.currentUser == null) {
            System.out.println("User Not Assigned");
            return null;
        }
        return this.currentUser.getId();
    }

    /**
     * getStudentIDs() - Gets a list of the userIds of the students that a GPC can view.
     *
     * @return a list containing the userId of for each student in the
     *      system belonging to the current user
     * @throws Exception is the current user is not a GPC.
     */
    public List<String> getStudentIDs() throws Exception {
        if(currentUser == null || currentUser.getRole() == Role.STUDENT || currentUser.getDepartment() != Department.COMPUTER_SCIENCE){
            Exception exception = new Exception();
            throw exception;
        }
        List<String> studentIDList = new ArrayList<String>();
        try {
            for (StudentRecord sr : recordList) {
                studentIDList.add(sr.getStudent().getId());
            }
        } catch(Exception e){
            throw e;
        }
        String representation = new GsonBuilder().setPrettyPrinting().create().toJson(studentIDList);
        try {
            FileWriter out = new FileWriter("studentids.txt");
            out.write(representation);
            out.close();
        } catch(IOException e) {
            throw e;
        }
        return studentIDList;
    }


    /**
     * getTranscript() - Gets the raw student record data for a given userId.
     *
     * @param userId  the identifier of the student.
     * @return  the student record data.
     * @throws Exception  if the form data could not be retrieved.  SEE NOTE IN
     *      CLASS HEADER.
     */
    public StudentRecord getTranscript(String userId) throws Exception {
        if(currentUser == null || currentUser.getDepartment() != Department.COMPUTER_SCIENCE || (currentUser.getRole() == Role.STUDENT && !(userId.equals(currentUser.getId())))) {
            Exception exception = new Exception();
            throw exception;
        }
        StudentRecord studentRecord = new StudentRecord();
        boolean assigned = false;
        for(StudentRecord sRecord : this.recordList) {
            if(userId.equals(sRecord.getStudent().getId())) {
                studentRecord = sRecord;
                assigned = true;
            }
        }
        if(!assigned) {
            Exception e = new Exception();
            throw e;
        }

        String representation = new GsonBuilder().setPrettyPrinting().create().toJson(studentRecord);
        try {
            FileWriter out = new FileWriter("studentrecord.txt");
            out.write(representation);
            out.close();
        } catch(IOException e) {
            throw e;
        }

        return studentRecord;
    }

    /**
     * updateTranscript() - Saves a new set of student data to the records data.
     *
     * @param userId the student ID to overwrite.
     * @param transcript  the new student record
     * @throws Exception  if the transcript data could not be saved, failed
     * a validity check, or a non-GPC tries to call.  SEE NOTE IN CLASS HEADER.
     */
    public void updateTranscript(String userId, StudentRecord transcript) throws Exception {
        if(currentUser == null || currentUser.getDepartment() != Department.COMPUTER_SCIENCE || (currentUser.getRole() == Role.STUDENT && !(userId.equals(currentUser.getId())))) {
            Exception exception = new Exception();
            throw exception;
        }
        int count = 0, index = -1;
        for(StudentRecord sRecord : this.recordList) {
            if(userId.equals(sRecord.getStudent().getId())) {
                index = count;
            }
            count++;
        }
        if(index == -1) {
            Exception e = new Exception();
            throw e;
        }
        this.recordList.set(index,transcript);
    }

    /**
     * addNote() - Appends a note to a student record.
     *
     * @param userId the student ID to add a note to.
     * @param note  the note to append
     * @throws Exception  if the note could not be saved or a non-GPC tries to call.
     * SEE NOTE IN CLASS HEADER.
     */
    public void addNote(String userId, String note) throws Exception {
        if(currentUser == null || currentUser.getDepartment() != Department.COMPUTER_SCIENCE || (currentUser.getRole() == Role.STUDENT && !(userId.equals(currentUser.getId())))) {
            Exception exception = new Exception();
            throw exception;
        }
        if(this.recordList == null) {
            Exception e = new Exception();
            throw e;
        }
        int index = -1, count = 0;
        for(StudentRecord sRecord : this.recordList) {
            if(userId.equals(sRecord.getStudent().getId()))
                index = count;
            count++;
        }
        if(index == -1){
            Exception e = new Exception();
            throw e;
        }
        else {
            this.recordList.get(index).addNote(note);
        }
    }

    /**
     * generateProgressSummary() - Generates progress summary
     *
     * @param userId the student to generate the record for.
     * @returns the student's progress summary in a data class matching the JSON format.
     * @throws Exception  if the progress summary could not be generated.
     * SEE NOTE IN CLASS HEADER.
     */
    public ProgressSummary generateProgressSummary(String userId) throws Exception {
        if(currentUser == null || currentUser.getDepartment() != Department.COMPUTER_SCIENCE || (currentUser.getRole() == Role.STUDENT && !(userId.equals(currentUser.getId())))) {
            Exception exception = new Exception();
            throw exception;
        }
        ProgressSummary progressSummaryReturn = new ProgressSummary();

        //finds studentRecord from data passed in with loadRecords and gets progressSummary
        for(StudentRecord sr : recordList) {
            if (currentUser.getDepartment() == sr.getDepartment() && userId.equals(sr.getStudent().getId())) {
                ProgressSummary progressSummary = new ProgressSummary(sr.getStudent(),
                        sr.getDepartment(), sr.getDegreeSought(), sr.getTermBegan(),
                        sr.getAdvisors(), sr.getCommittee(), sr.getNotes(), sr.getCoursesTaken());
                progressSummary.checkGradStatus(sr.getMilestonesSet());
                progressSummaryReturn = progressSummary;
            }
        }
        String representation = new GsonBuilder().setPrettyPrinting().create().toJson(progressSummaryReturn);
        try {
            FileWriter out = new FileWriter("progress.txt");
            out.write(representation);
            out.close();
        } catch(IOException e) {
            throw e;
        }

        return progressSummaryReturn;
    }

    /**
     * simulateCourses() - Generates a new progress summary, assuming that the student passes the
     * provided set of prospective courses.
     *
     * @param userId the student to generate the record for.
     * @param courses a list of the prospective courses.
     * @returns a map containing the student's hypothetical progress summary
     * @throws Exception  if the progress summary could not be generated or the courses
     * are invalid. SEE NOTE IN CLASS HEADER.
     */
    public ProgressSummary simulateCourses(String userId, List<CourseTaken> courses) throws Exception {
        if(currentUser == null || currentUser.getDepartment() != Department.COMPUTER_SCIENCE || (currentUser.getRole() == Role.STUDENT && !(userId.equals(currentUser.getId())))) {
            Exception exception = new Exception();
            throw exception;
        }
        ProgressSummary progressSummaryReturn = new ProgressSummary();

        //finds studentRecord from data passed in with loadRecords and gets progressSummary
        for(StudentRecord sr : recordList) {
            if (currentUser.getDepartment() == sr.getDepartment() && userId.equals(sr.getStudent().getId())) {
                sr.appendCourses(courses);
                ProgressSummary progressSummary = new ProgressSummary(sr.getStudent(),
                        sr.getDepartment(), sr.getDegreeSought(), sr.getTermBegan(),
                        sr.getAdvisors(), sr.getCommittee(), sr.getNotes(), sr.getCoursesTaken());
                progressSummary.checkGradStatus(sr.getMilestonesSet());
                progressSummaryReturn = progressSummary;
            }
        }
        return progressSummaryReturn;
    }
}

