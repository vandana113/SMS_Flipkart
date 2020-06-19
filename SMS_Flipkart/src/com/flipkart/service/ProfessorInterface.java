package com.flipkart.service;

import com.flipkart.model.Professor;

public interface ProfessorInterface {

	// Display all students enrolled in particular course
	public void viewEnrolledStudents(String courseCode);

	// Adding grades of student
	public void addGrades(Professor professor, String studentID, String courseID, int grade);

	// Deleting course taught by professor
	public void removeCourse(Professor professor, String courseCode);

	// Adding a new course taught by professor
	public void addCourse(Professor professor, String courseCode);

	// Display all course taught by professor
	public void taughtCourses(Professor professor);

	// Update Profile-Add title
	public void updateDetails(Professor professor);

}
