package com.flipkart.service;

import java.util.List;

import com.flipkart.model.Course;
import com.flipkart.model.Student;

public interface StudentInterface {

	void addCourse(Student student, String courseCode);

	public void removeCourse(Student student, String courseCode);

	public List<Course> enrolledCourses(Student student);

	public void registerCourses(Student student);

	void DisplayCourses(Student student);

	public void makePayment(Student student, String mode, String modeNumber);

	public void updateDetails(Student student);

	public void ViewGrades(Student student);

}
