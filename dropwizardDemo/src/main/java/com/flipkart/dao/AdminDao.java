package com.flipkart.dao;

import com.flipcard.bean.Course;
import com.flipcard.bean.User;

public interface AdminDao {
	public void addUser(User user, String role);

	public void deleteUser(String username);

	public void logOut();

	public void addCourse(Course course);

	public void deleteCourse(String courseCode);

	public void addProfessor(User user);

	public void updateCourse(Course course);
}
