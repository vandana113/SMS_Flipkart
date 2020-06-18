package com.flipkart.service;

import java.util.List;

import com.flipkart.model.Course;
import com.flipkart.model.Student;
import com.flipkart.model.User;

public interface AdminInterface {
	public void addUser(User user, String role);

	public void addCourse(Course course);

	public void updateCourse(Course course);

	public void removeUser(String username);

	public void removeCourse(String courseCode);

	public List<Student> getRegisteredStudents();

}
