package com.flipkart.exception;

public class NotRegistered extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "You need to register first, to view enrolled courses";

	}
}
