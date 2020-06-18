package com.flipkart.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.model.Professor;
import com.flipkart.service.ProfessorOperation;

public class ProfessorClient {
	Professor professor;

	ProfessorClient(Professor professor) {
		this.professor = professor;
	}

	private static Logger logger = Logger.getLogger(ProfessorClient.class);

	public void menu() {
		Scanner s = new Scanner(System.in);
		logger.info("Professor MENU:");
		logger.info(
				"1. View Courses\n2. ViewEnrolledStudents\n3. Add Grades\n4. Add Course\n5. Remove Course\n6. View Courses Taught\n7. Update Profile\n8. LogOut");
		ProfessorOperation professorOperation = new ProfessorOperation();
		int choice;
		String courseCode;
		do {
			logger.info("Enter choice: ");
			choice = s.nextInt();
			switch (choice) {
			case 1:
				professorOperation.DisplayCourses();
				break;
			case 2:
				logger.info("CourseCode: ");
				courseCode = s.next();
				professorOperation.viewEnrolledStudents(courseCode);
				break;
			case 3:
				logger.info("StudentID of student for which grades need to be added");
				String studentID = s.next();
				logger.info("CourseID");
				String courseID = s.next();
				logger.info("Grade: ");
				int grade = s.nextInt();
				professorOperation.addGrades(professor, studentID, courseID, grade);
				break;
			case 4:
				logger.info("CourseID");
				courseCode = s.next();
				professorOperation.addCourse(professor, courseCode);
				break;
			case 5:
				logger.info("CourseID:");
				courseCode = s.next();
				professorOperation.removeCourse(professor, courseCode);
				break;
			case 6:
				professorOperation.taughtCourses(professor);
				break;
			case 7:
				logger.info("Enter Details-----");
				logger.info("Title");
				String title = s.next();

				professor.setTitle(title);
				professorOperation.updateDetails(professor);
				break;
			default:
				return;
			}
		} while (choice < 8);

	}

}
