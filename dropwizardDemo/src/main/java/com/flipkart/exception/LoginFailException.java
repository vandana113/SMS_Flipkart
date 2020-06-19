package com.flipkart.exception;

public class LoginFailException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String username, password;

	public LoginFailException() {
		// TODO Auto-generated constructor stub
	}

	// Message when password does not match
	public String getMessage() {
		return "Invalid  login: Username and Password does not match";
	}


}
