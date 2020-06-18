package com.flipkart.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.dao.CourseDao;
import com.flipkart.dao.CourseDaoImpl;
import com.flipkart.dao.GradeDao;
import com.flipkart.dao.GradeDaoImpl;
import com.flipkart.dao.ProfessorCourseDao;
import com.flipkart.dao.ProfessorCourseDaoImpl;
import com.flipkart.dao.RegistrationDaoImpl;
import com.flipkart.dao.StudentCourseDao;
import com.flipkart.dao.StudentCourseDaoImpl;
import com.flipkart.model.Course;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;

public class ProfessorOperation implements ProfessorInterface {

	StudentCourseDao studentCourseDBOperation = new StudentCourseDaoImpl();
	ProfessorCourseDao professorCourseDBOperation = new ProfessorCourseDaoImpl();
	CourseDao courseDBOperation = new CourseDaoImpl();
	GradeDao gradeDBOperation = new GradeDaoImpl();
	private static Logger logger = Logger.getLogger(RegistrationDaoImpl.class);

	public void DisplayCourses() {
		List<Course> courses = courseDBOperation.listAllCourses();
		courses.forEach(course -> logger.info("Name:" + course.getCourseTitle() + ", CourseCode " + course.getCourseCode()));
	}

	public void viewEnrolledStudents(String courseCode) {
		// TODO Auto-generated method stub
		List<Student> enrolledStudents = studentCourseDBOperation.enrolledStudents(courseCode);
		logger.info("LIST OF ENROLLED STUDENTS-----");
		enrolledStudents.forEach(
				student -> logger.info("Student Name: " + student.getName() + " Major: " + student.getMajor()));
		return;
	}

	@Override
	public void addGrades(Professor professor, String studentID, String courseID, int grade) {
		gradeDBOperation.addGrades(professor, studentID, courseID, grade + "");
	}

	public void addCourse(Professor professor, String courseCode) {
		professorCourseDBOperation.addCourse(professor, courseCode);
	}

	public void removeCourse(Professor professor, String courseCode) {
		professorCourseDBOperation.removeCourse(professor, courseCode);
	}

	public void taughtCourses(Professor professor) {
		List<Course> courses = professorCourseDBOperation.taughtCourse(professor);
		logger.info("List of Courses Taught-----");
		courses.forEach(course -> logger.info("name:" + course.getCourseTitle() + ", code " + course.getCourseCode()
				+ ", Professor: " + course.getProfessor()));

	}

	public void updateDetails(Professor professor) {
		professorCourseDBOperation.updateProfessorDetails(professor);
	}
}
