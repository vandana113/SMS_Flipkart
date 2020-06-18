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

	private static Logger logger = Logger.getLogger(AdminOperation.class);
	AdminDao adminDBOperation = new AdminDaoImpl();
	RegistrationDao registrationDBOperation = new RegistrationDaoImpl();

	public void addUser(User user, String role) {
		adminDBOperation.addUser(user, role);
	}

	public void removeUser(String username) {
		adminDBOperation.deleteUser(username);
	}

	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		adminDBOperation.addCourse(course);
	}

	@Override
	public void removeCourse(String courseCode) {
		// TODO Auto-generated method stub
		adminDBOperation.deleteCourse(courseCode);
	}

	public List<Student> getRegisteredStudents() {
		List<Student> registeredStudents = registrationDBOperation.getRegisteredStudents();
		logger.info("Inside Admin Operation");
		registeredStudents.forEach(student -> logger.info("StudentID: " + student.getStudentID() + " name: "
				+ student.getName() + " gender: " + student.getGender()));
		return registeredStudents;
	}

}
