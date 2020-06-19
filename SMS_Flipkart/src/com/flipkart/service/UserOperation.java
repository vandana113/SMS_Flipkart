package com.flipkart.service;

import org.apache.log4j.Logger;

import com.flipkart.dao.UserDao;
import com.flipkart.dao.UserDaoImpl;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;
import com.flipkart.model.User;

public class UserOperation implements UserInterface {

	private static Logger logger = Logger.getLogger(UserOperation.class);
	UserDao UserDBOperation = new UserDaoImpl();

	public User Login(String username, String password) {
		// TODO Auto-generated method stub

		// Check credentials from database
		return login(username, password);

	}

	public Student getStudent(User user) {
		//Student object
		return UserDBOperation.getStudentDetails(user);
	}

	public Professor getProfessor(User user) {
		//Professor object
		return UserDBOperation.getProfessorDetails(user);

	}

}
