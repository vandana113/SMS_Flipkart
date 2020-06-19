package com.flipkart.dao;

import com.flipkart.model.Course;
import com.flipkart.model.User;

public interface AdminDao {
	
	//Creating new User
	/**
	 * 
	 * @param user
	 * @param role
	 */
	public void addUser(User user, String role);

	//Removal of user
	/**
	 * 
	 * @param username
	 */
	public void deleteUser(String username);

	public void logOut();

	//Adding of course 
	/**
	 * 
	 * @param course
	 */
	public void addCourse(Course course);

	//Deletion of course
	/**
	 * 
	 * @param courseCode
	 */
	public void deleteCourse(String courseCode);
	
	//Adding professor to professor DB
	/**
	 * 
	 * @param user
	 */
	public void addProfessor(User user);

}
