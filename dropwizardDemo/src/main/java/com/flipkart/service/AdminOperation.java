package com.flipkart.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flipcard.bean.Course;
import com.flipcard.bean.Student;
import com.flipcard.bean.User;
import com.flipkart.dao.AdminDao;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.RegistrationDao;
import com.flipkart.dao.RegistrationDaoImpl;

public class AdminOperation implements AdminInterface {

	private static final Logger logger = LoggerFactory.getLogger(AdminOperation.class);
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

	public void updateCourse(Course course) {
		adminDBOperation.updateCourse(course);
	}

	@Override
	public void removeCourse(String courseCode) {
		// TODO Auto-generated method stub
		adminDBOperation.deleteCourse(courseCode);
	}

	public List<Student> getRegisteredStudents() {
		List<Student> registeredStudents = registrationDBOperation.getRegisteredStudents();
		logger.info("Inside Admin Operation");
		for (Student student : registeredStudents)
			logger.info("StudentID: " + student.getStudentID() + " name: " + student.getName() + " gender: "
					+ student.getGender());
		return registeredStudents;
	}

}
