package com.flipkart.service;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.flipkart.dao.CourseDao;
import com.flipkart.dao.CourseDaoImpl;
import com.flipkart.dao.GradeDao;
import com.flipkart.dao.GradeDaoImpl;
import com.flipkart.dao.PaymentDao;
import com.flipkart.dao.PaymentDaoImpl;
import com.flipkart.dao.RegistrationDao;
import com.flipkart.dao.RegistrationDaoImpl;
import com.flipkart.dao.StudentCourseDao;
import com.flipkart.dao.StudentCourseDaoImpl;
import com.flipkart.exception.NotRegistered;
import com.flipkart.model.Course;
import com.flipkart.model.Grade;
import com.flipkart.model.Student;

public class StudentOperation implements StudentInterface {

	CourseDao courseDBOperation = new CourseDaoImpl();
	StudentCourseDao studentCourseDBOperation = new StudentCourseDaoImpl();
	RegistrationDao RegistrationDBOperation = new RegistrationDaoImpl();
	PaymentDao PaymentDBOperation = new PaymentDaoImpl();
	GradeDao gradeDBOperation = new GradeDaoImpl();

	private static Logger logger = Logger.getLogger(StudentOperation.class);

	@Override
	public void DisplayCourses(Student student) {
		// TODO Auto-generated method stub
		logger.info("List of courses in " + student.getMajor() + " " + student.getSem() + " semester");
		List<Course> courses = courseDBOperation.fetchCourseList(student);
		courses.forEach(course -> logger.info("Name:" + course.getCourseTitle() + ", CourseID: " + course.getCourseCode()
				+ ", Professor: " + course.getProfessor()));
	}

	@Override
	public void addCourse(Student student, String courseCode) {
		// TODO Auto-generated method stub
		studentCourseDBOperation.addCourse(student, courseCode);

	}

	@Override
	public void removeCourse(Student student, String courseCode) {
		// TODO Auto-generated method stub
		studentCourseDBOperation.removeCourse(student, courseCode);
	}

	@Override
	public List<Course> enrolledCourses(Student student) {
		List<Course> courses = null;
		try {
			courses = studentCourseDBOperation.enrolledCourses(student);
			logger.info("List of Enrolled Courses-----");
			courses.forEach(course -> logger.info("name:" + course.getCourseTitle() + ", code " + course.getCourseCode()
					+ ", Professor: " + course.getProfessor()));
		} catch (NotRegistered e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return courses;
	}

	public void registerCourses(Student student) {
		if (student.isRegistered()) {
			logger.info("Already Registered...");
			return;
		}

		List<Course> selectedCourses, invalidcourses;

		selectedCourses = studentCourseDBOperation.selectedCourses(student);
		invalidcourses = studentCourseDBOperation.invalidCourses(student);
		int no_of_courses = selectedCourses.size();
		if (no_of_courses == 4 && invalidcourses.size() == 0) {
			logger.info("LIST OF COURSES TO BE REGISTERED-----------");
			selectedCourses.forEach(courses -> logger
					.info("CourseName: " + courses.getCourseTitle() + ", CourseCode: " + courses.getCourseCode()));
			student.setRegistered(true);
			courseDBOperation.updateCourseStrength(student, selectedCourses);

			logger.debug("Adding details to Database");
			UUID registrationID = UUID.randomUUID();
			student.setRegistrationID(registrationID);
			RegistrationDBOperation.registerStudents(registrationID, student);

		} else {
			logger.info("LIST OF COURSES SELECTED-----------");
			selectedCourses.forEach(courses -> logger
					.info("CourseName: " + courses.getCourseTitle() + ", CourseCode: " + courses.getCourseCode()));
			if (invalidcourses.size() == 0) {
				logger.info("You have selected " + no_of_courses
						+ ". You need to select 4 courses.(To Add/Remove course Press 3/4 respectively.");

			} else {
				logger.info("Some courses got full. To add a new course Press 3");
				logger.info("Invalid Courses----");
				invalidcourses.forEach(courses -> logger
						.info("CourseName: " + courses.getCourseTitle() + ", CourseCode: " + courses.getCourseCode()));
				studentCourseDBOperation.DropOtherCourses(student, invalidcourses);
			}

		}

		return;

	}

	public void makePayment(Student student, String mode, String modeNumber) {
		try {
			PaymentDBOperation.addPaymentDetails(student, mode, modeNumber);
		} catch (NotRegistered r) {
			logger.info(r.getMessage());
		}
		logger.info("Payment Successful");
	}

	public void updateDetails(Student student) {
		studentCourseDBOperation.updateStudentDetails(student);
	}

	public void ViewGrades(Student student) {
		List<Grade> grades = gradeDBOperation.ViewGrades(student);
		grades.forEach(grade -> logger.info("CourseID: " + grade.getCourseID() + ", CourseName:" + grade.getCourseName()
				+ ", Grade: " + grade.getGrade() + ", Pass: " + grade.isPass()));
	}

}
