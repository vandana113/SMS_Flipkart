package com.flipkart.service;

import com.flipkart.model.Professor;

public interface ProfessorInterface {

	// public ArrayList<Course> viewCourses(Professor p);

	public void viewEnrolledStudents(String courseCode);

	public void addGrades(Professor professor, String studentID, String courseID, int grade);

	public void removeCourse(Professor professor, String courseCode);

	public void addCourse(Professor professor, String courseCode);

	public void taughtCourses(Professor professor);

	public void updateDetails(Professor professor);

}
