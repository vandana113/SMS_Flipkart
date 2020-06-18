package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.model.Grade;
import com.flipkart.model.Student;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentOperation;

public class StudentClient {

	Student student;

	StudentClient(Student student) {
		this.student = student;
	}

	private static Logger logger = Logger.getLogger(StudentClient.class);

	public void menu() {
		Scanner s = new Scanner(System.in);
		logger.info("Student MENU:");
		logger.info(
				"1. View Courses\n2. Register Course\n3. Add Course\n4. Remove Course\n5. ViewEnrolledCourses\n6. Make Payment\n7. Update Profile\n8. View Grades\n9. LogOut");
		StudentInterface studentOperation = new StudentOperation();
		logger.info("Student ID: " + student.getStudentID());
		int choice;
		do {
			logger.info("Enter choice:");
			choice = s.nextInt();
			switch (choice) {
			case 1:
				studentOperation.DisplayCourses(student);
				break;
			case 2:
				studentOperation.registerCourses(student);
				break;
			case 3:
				logger.info("CourseCode: ");
				String courseCode = s.next();
				studentOperation.addCourse(student, courseCode);
				break;
			case 4:
				logger.info("CourseCode: ");
				courseCode = s.next();
				studentOperation.removeCourse(student, courseCode);
				break;
			case 5:
				studentOperation.enrolledCourses(student);
				break;
			case 6:
				logger.info("Mode");
				String mode = s.next();
				logger.info("ModeNumber");
				String modeNumber = s.next();
				studentOperation.makePayment(student, mode, modeNumber);
				break;
			case 7:
				logger.info("Enter Details---");
				logger.info("Gender:");
				student.setGender(s.next());
				logger.info("Semester:");
				student.setSem(s.next());
				logger.info("Major");
				student.setMajor(s.next());
				logger.info("Percentage");
				student.setPercentage(s.nextInt());
				studentOperation.updateDetails(student);
				break;
			case 8:
				studentOperation.ViewGrades(student);
				break;
			case 9:
				return;
			}
		} while (choice < 9);
	}
}
