package com.flipkart.service;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;

import com.flipkart.dao.UserDao;
import com.flipkart.dao.UserDaoImpl;
import com.flipkart.exception.LoginFailException;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;
import com.flipkart.model.User;

public interface UserInterface {
	static Logger logger = Logger.getLogger(UserInterface.class);
	UserDao UserDBOperation = new UserDaoImpl();

	default public User login(String username, String password) {
		User user = new User(username, password);
		try {
			// If login fails return null user
			// else return user
			if (!UserDBOperation.validateLogin(user))
				return null;
		} catch (LoginFailException e) {

			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	//Get student object
	public Student getStudent(User user);

	//Get professor object
	public Professor getProfessor(User user);

	//Logout
	default public void logout(int role) {
		// TODO Auto-generated method stub
		LocalDateTime localDateTime = LocalDateTime.now();
		String result = "";
		switch (role) {
		case 1:
			result += "Student";
			break;
		case 2:
			result += "Professor";
			break;
		case 3:
			result += "Admin";
		}
		logger.debug(result + " logged out at" + localDateTime);

	}

}
