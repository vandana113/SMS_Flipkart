package com.flipkart.dao;

import java.util.List;

import com.flipkart.model.Course;
import com.flipkart.model.Student;

public interface CourseDao {
	
	//Fetching courseList from course table
	/**
	 * 
	 * @param student
	 * @return
	 */
	public List<Course> fetchCourseList(Student student);

	//Update strength of student in course
	/**
	 * 
	 * @param student
	 * @param selectedCourses
	 */
	public void updateCourseStrength(Student student, List<Course> selectedCourses);

	//List of all courses
	/**
	 * 
	 * @return
	 */
	public List<Course> listAllCourses();

}
