package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.model.Course;
import com.flipkart.model.Student;

public interface StudentInterface {
	public ArrayList<Course> selectCourses(Student s);

	public ArrayList<Course> selectAlternateCourses(Student s);

	public ArrayList<Course> viewEnrolledCourses(Student s);

	public ArrayList<Course> registerCourses(Student s);

	public boolean payFees(Student s);

	public void viewGrades(Student s);

}
