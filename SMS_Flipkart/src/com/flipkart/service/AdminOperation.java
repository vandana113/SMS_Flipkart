package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.dao.AdminDao;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.RegistrationDao;
import com.flipkart.dao.RegistrationDaoImpl;
import com.flipkart.model.Course;
import com.flipkart.model.Student;
import com.flipkart.model.User;

public class AdminOperation implements AdminInterface {
	
	//Logger Intialisation
	private static Logger logger = Logger.getLogger(AdminOperation.class);
	
	//Creating DBoperation object to perform operations in database
	AdminDao adminDBOperation = new AdminDaoImpl();
	RegistrationDao registrationDBOperation = new RegistrationDaoImpl();

	
	public void addUser(User user, String role) {
		//Configuring user table
		adminDBOperation.addUser(user, role);
	}

	public void removeUser(String username) {
		//Deleting user using username
		adminDBOperation.deleteUser(username);
	}

	public void addCourse(Course course) {
		// Course added by admin to database 
		adminDBOperation.addCourse(course);
	}

	@Override
	public void removeCourse(String courseCode) {
		// Course deleted by admin using courseID
		adminDBOperation.deleteCourse(courseCode);
	}

	public List<Student> getRegisteredStudents() {
		//List of already registered students
		List<Student> registeredStudents = registrationDBOperation.getRegisteredStudents();
		logger.info("Inside Admin Operation");
		registeredStudents.forEach(student -> logger.info("StudentID: " + student.getStudentID() + " name: "
				+ student.getName() + " gender: " + student.getGender()));
		return registeredStudents;
	}

}
