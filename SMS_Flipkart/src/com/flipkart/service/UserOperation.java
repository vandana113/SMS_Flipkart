package com.flipkart.service;

import java.util.logging.Logger;

import com.flipkart.doa.UserDao;
import com.flipkart.doa.UserDaoImpl;
import com.flipkart.exception.LoginFailException;
import com.flipkart.model.User;

public class UserOperation implements UserInterface {

	UserDao UserDBOperation = new UserDaoImpl();

	@Override
	public void login(String username, String password) {
		// TODO Auto-generated method stub

		// Check credentials from database
		try {
			boolean loginSuccess = UserDBOperation.validateLogin(username, password);
		} catch (LoginFailException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
