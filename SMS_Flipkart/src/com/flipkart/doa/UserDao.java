package com.flipkart.doa;

import com.flipkart.exception.LoginFailException;
import com.flipkart.model.User;

public interface UserDao {

	// Check credentials of user
	boolean validateLogin(String username, String password) throws LoginFailException;
}
