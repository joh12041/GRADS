GRADS
=====

CSCI 5801 Fall 2014 Project - Group 1

In addition to the updates we made to GRADS.java, we have two new classes: GRADSTestBasedOnAssignment2.java and GRADSTestAllTests.java. These two classes implement test cases from Assignment 2 and then that in addition to several more to reach 80% statement coverage. They depend on JUnit jars (included in the lib/ folder) and were developed in IntelliJ. To get proper evaluation of code coverage, make sure that the JUnit tests not be run are not included in the report (this can be done by temporarily removing the file from the project). The tests also pull from additional .txt files found in resources, but the GRADS.java interface still only depends on students.txt, courses.txt, and users.txt.
