package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.model.Professor;
import com.flipkart.model.User;
import com.flipkart.service.UserInterface;
import com.flipkart.service.UserOperation;

public class SMSClient {
	private static Logger logger = Logger.getLogger(SMSClient.class);

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		do {
			UserInterface useroperation = new UserOperation();
			logger.info("Login------ ");
			logger.info("Username: ");
			String username = s.next();
			logger.info("Password: ");
			String password = s.next();
			User user = useroperation.login(username, password);
			if (user != null) {
				switch (user.getRole()) {
				case "1":
					StudentClient studentclient = new StudentClient(useroperation.getStudent(user));
					studentclient.menu();
					break;
				case "2":
					Professor professor = useroperation.getProfessor(user);
					ProfessorClient professorclient = new ProfessorClient(professor);
					professorclient.menu();
					break;
				case "3":
					AdminClient.menu();
				}
			}
		} while (true);
		// System.out.println(System.getProperty("java.runtime.version"));
	}

}
