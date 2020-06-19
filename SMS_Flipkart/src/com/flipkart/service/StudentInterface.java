package com.flipkart.service;

import java.util.List;

import com.flipkart.model.Course;
import com.flipkart.model.Student;

public interface StudentInterface {

	// Adding course
	void addCourse(Student student, String courseCode);

	// Removing course
	public void removeCourse(Student student, String courseCode);

	// List of courses enrolled after registration
	public List<Course> enrolledCourses(Student student);

	// Registration of courses
	public void registerCourses(Student student);

	// List of all courses based on major and semester
	void DisplayCourses(Student student);

	// Payment
	public void makePayment(Student student, String mode, String modeNumber);

	// Update Profile
	public void updateDetails(Student student);

	// Display Result
	public void ViewGrades(Student student);

}
