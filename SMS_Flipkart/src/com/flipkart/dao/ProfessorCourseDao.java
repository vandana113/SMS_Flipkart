package com.flipkart.dao;

import java.util.List;

import com.flipkart.model.Course;
import com.flipkart.model.Professor;

public interface ProfessorCourseDao {
	/**
	 * 
	 * @param professor
	 * @param courseCode
	 */
	//Add new course taught by professor
	public void addCourse(Professor professor, String courseCode);

	/**
	 * 
	 * @param professor
	 * @param courseCode
	 */
	//Remove course from professorcourses table
	public void removeCourse(Professor professor, String courseCode);

	/**
	 * 
	 * @param professor
	 * @return
	 */
	//View taught courses
	public List<Course> taughtCourse(Professor professor);

	/**
	 * 
	 * @param professor
	 * @return
	 */
	//update professor profile
	public Professor updateProfessorDetails(Professor professor);

}
