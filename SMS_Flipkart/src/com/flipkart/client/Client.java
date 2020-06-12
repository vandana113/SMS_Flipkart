package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.doa.UserDaoImpl;
import com.flipkart.service.UserInterface;
import com.flipkart.service.UserOperation;

public class Client {
	private static Logger logger = Logger.getLogger(UserDaoImpl.class);

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		UserInterface useroperation = new UserOperation();
		logger.error("Login------ ");
		logger.info("Username: ");
		String username = s.next();
		String password = s.next();
		useroperation.login(username, password);

	}

}
