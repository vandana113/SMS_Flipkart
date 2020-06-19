package com.flipkart.service;

import java.util.List;

import com.flipcard.bean.Course;
import com.flipcard.bean.Student;
import com.flipcard.bean.User;

public interface AdminInterface {
	public void addUser(User user, String role);

	public void addCourse(Course course);

	public void updateCourse(Course course);

	public void removeUser(String username);

	public void removeCourse(String courseCode);

	public List<Student> getRegisteredStudents();

}
