package com.flipkart.dao;

import com.flipkart.exception.LoginFailException;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;
import com.flipkart.model.User;

public interface UserDao {

	// Check credentials of user
	boolean validateLogin(User user) throws LoginFailException;

	public Student getStudentDetails(User user);

	public Professor getProfessorDetails(User user);

}
