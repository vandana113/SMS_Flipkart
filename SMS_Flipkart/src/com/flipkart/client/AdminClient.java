package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.model.Course;
import com.flipkart.model.User;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminOperation;

public class AdminClient {
	private static Logger logger = Logger.getLogger(StudentClient.class);

	public static void menu() {
		Scanner s = new Scanner(System.in);
		logger.info("Admin MENU:");
		logger.info("1. Add user\n2. Delete User\n3. Add Course\n4. Delete Course\n5. Registered Students\n6. LogOut");
		AdminInterface adminOperation = new AdminOperation();
		int choice;
		do {
			logger.info("Choice:");
			choice = s.nextInt();
			switch (choice) {
			case 1:
				logger.info("Username");
				String username = s.next();
				logger.info("password");
				String password = s.next();
				logger.info("Role(Student/Professor/Admin)");
				String role = s.next();
				User user = new User(username, password);
				logger.info("UserID: ");
				user.setUserID(s.next());
				logger.debug(user.getUserID());
				s.nextLine();
				switch (role) {
				case "Student":
					logger.debug("Adding student....");
					adminOperation.addUser(user, "1");
					break;
				case "Professor":
					adminOperation.addUser(user, "2");
					break;
				case "Admin":
					adminOperation.addUser(user, "3");
					break;
				}
				break;
			case 2:
				logger.info("Username");
				String username1 = s.next();
				adminOperation.removeUser(username1);
				break;
			case 3:
				Course c = new Course();
				s.nextLine();
				logger.info("CourseName");
				c.setCourseTitle(s.nextLine());
				logger.info("CourseCode");
				c.setCourseCode(s.nextLine());
				logger.info("Professor");
				c.setProfessor(s.nextLine());
				logger.info("Credit");
				c.setCredit(s.nextInt());
				logger.info("CatalogID");
				c.setCatalogID(s.next());
				adminOperation.addCourse(c);
				break;
			case 4:
				logger.info("Code of course to be deleted");
				String courseCode = s.next();
				adminOperation.removeCourse(courseCode);
				break;
			case 5:
				adminOperation.getRegisteredStudents();
				break;
			default:
				return;
			}
		} while (choice < 6);

	}

}
