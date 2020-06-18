package com.flipkart.dao;

import com.flipkart.model.Course;
import com.flipkart.model.User;

public interface AdminDao {
	public void addUser(User user, String role);

	public void deleteUser(String username);

	public void logOut();

	public void addCourse(Course course);

	public void deleteCourse(String courseCode);

	public void addProfessor(User user);

}
