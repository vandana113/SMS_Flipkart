package com.flipkart.service;

import java.util.List;

import com.flipkart.model.Course;
import com.flipkart.model.Student;
import com.flipkart.model.User;

public interface AdminInterface {
	
	//Adding user according to their role
	public void addUser(User user, String role);

	//Adding course 
	public void addCourse(Course course);
	
	//Deleting user
	public void removeUser(String username);

	//Deleting course
	public void removeCourse(String courseCode);

	//Displaying all the registered Students
	public List<Student> getRegisteredStudents();

}
