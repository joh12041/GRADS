package edu.umn.csci5801;

/**
 * Created by Justin on 12/2/2014.
 */

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.Reader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import edu.umn.csci5801.model.StudentRecord;
import edu.umn.csci5801.model.ProgressSummary;
import edu.umn.csci5801.model.CourseTaken;
import edu.umn.csci5801.model.User;
import edu.umn.csci5801.GRADSIntf;
import edu.umn.csci5801.model.Course;


/**
  * Your implementation of this interface must be named GRADS
  */
public class GRADS implements GRADSIntf
{
        /**
         * Loads the list of system usernames and permissions.
         * @param usersFile the filename of the users file.
         * @throws Exception for I/O errors.  SEE NOTE IN CLASS HEADER.
         */
        public void loadUsers(String usersFile) throws Exception{
            List<User> users = new Gson().fromJson( new FileReader( new File(usersFile)), new TypeToken<List<User>>(){}.getType());
        }

        /**
         * Loads the list of courses.
         * @param coursesFile the filename of the users file.
         * @throws Exception for I/O errors.  SEE NOTE IN CLASS HEADER.
         */
        public void loadCourses(String coursesFile) throws Exception{
            List<Course> courses = new Gson().fromJson( new FileReader( new File(coursesFile)), new TypeToken<List<Course>>(){}.getType());
        }

        /**
         * Loads the list of system transcripts.
         * @param recordsFile the filename of the transcripts file.
         * @throws Exception for I/O errors.  SEE NOTE IN CLASS HEADER.
         */
        public void loadRecords(String recordsFile) throws Exception {
            List<StudentRecord> studentRecords = new Gson().fromJson( new FileReader( new File(recordsFile)), new TypeToken<List<StudentRecord>>(){}.getType());
        }

        /**
         * Sets the user id (X500) of the user currently using the system.
         * @param userId  the X500 id of the user generating progress summaries.
         * @throws Exception  if the user id is invalid.  SEE NOTE IN CLASS HEADER.
         */
        public void setUser(String userId) throws Exception {}

        /**
         * Gets the user id of the user currently using the system.
         * @return  the X500 user id of the user currently using the system.
         */
        public String getUser() { return "hi"; }

        /**
         * Gets a list of the userIds of the students that a GPC can view.
         * @return a list containing the userId of for each student in the
         *      system belonging to the current user
         * @throws Exception is the current user is not a GPC.
         */
        public List<String> getStudentIDs() throws Exception {
            List<String> ret = new ArrayList<String>();
            return ret;
        }

        /**
         * Gets the raw student record data for a given userId.
         * @param userId  the identifier of the student.
         * @return  the student record data.
         * @throws Exception  if the form data could not be retrieved.  SEE NOTE IN
         *      CLASS HEADER.
         */
        public StudentRecord getTranscript(String userId) throws Exception {
            StudentRecord studentRecord = new StudentRecord();
            return studentRecord;
        }

        /**
         * Saves a new set of student data to the records data.
         * @param userId the student ID to overwrite.
         * @param transcript  the new student record
         * @throws Exception  if the transcript data could not be saved, failed
         * a validity check, or a non-GPC tries to call.  SEE NOTE IN CLASS HEADER.
         */
        public void updateTranscript(String userId, StudentRecord transcript) throws Exception {
            return;
        }

        /**
         * Appends a note to a student record.
         * @param userId the student ID to add a note to.
         * @param note  the note to append
         * @throws Exception  if the note could not be saved or a non-GPC tries to call.
         * SEE NOTE IN CLASS HEADER.
         */
        public void addNote(String userId, String note) throws Exception {
            return;
        }

        /**
         * Generates progress summary
         * @param userId the student to generate the record for.
         * @returns the student's progress summary in a data class matching the JSON format.
         * @throws Exception  if the progress summary could not be generated.
         * SEE NOTE IN CLASS HEADER.
         */
        public ProgressSummary generateProgressSummary(String userId) throws Exception {
            ProgressSummary progressSummary = new ProgressSummary();
            return progressSummary;
        }

        /**
         * Generates a new progress summary, assuming that the student passes the
         * provided set of prospective courses.
         * @param userId the student to generate the record for.
         * @param courses a list of the prospective courses.
         * @returns a map containing the student's hypothetical progress summary
         * @throws Exception  if the progress summary could not be generated or the courses
         * are invalid. SEE NOTE IN CLASS HEADER.
         */
        public ProgressSummary simulateCourses(String userId, List<CourseTaken> courses) throws Exception {
            ProgressSummary progressSummary = new ProgressSummary();
            return progressSummary;
        }
}

