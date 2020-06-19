package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.exception.NotRegistered;
import com.flipkart.model.Course;
import com.flipkart.model.Student;
import com.flipkart.utils.DBUtil;
import com.sms.constant.SQLConstantQueries;

public class StudentCourseDaoImpl implements StudentCourseDao {
	// Creating connection
	Connection conn = DBUtil.getConnection();
	static int course = 0;
	private static Logger logger = Logger.getLogger(StudentCourseDaoImpl.class);

	// Adding course to student courses table
	public void addCourse(Student student, String courseCode) {

		if (student.isRegistered()) {
			logger.info("Already Registered");
			return;
		}
		PreparedStatement stmt = null;
		try {
			// Add course based on courseCode
			stmt = conn.prepareStatement(SQLConstantQueries.ADD_COURSE);
			stmt.setString(1, student.getStudentID() + "");
			stmt.setString(2, courseCode);
			// No of rows effected
			int rows = stmt.executeUpdate();
			logger.info(rows + " Course Added");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeCourse(Student student, String courseCode) {
		if (student.isRegistered()) {
			logger.info("Already Registered");
			return;
		}
		PreparedStatement stmt = null;
		try {
			// Remove course based on CourseCode
			stmt = conn.prepareStatement(SQLConstantQueries.DELETE_COURSE);
			stmt.setString(1, courseCode);
			stmt.setString(2, student.getStudentID());
			//No of rows effected
			int rows = stmt.executeUpdate();
			logger.info(rows + " Course Deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Student> enrolledStudents(String courseCode) {
		PreparedStatement stmt = null;
		//Get enrolled courses
		List<Student> enrolStudents = new ArrayList<Student>();
		try {

			stmt = conn.prepareStatement(SQLConstantQueries.GET_ENROLLED_STUDENTS);
			stmt.setString(1, courseCode);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Student s = new Student();
				s.setName(rs.getString("name"));
				s.setMajor(rs.getString("major"));
				enrolStudents.add(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return enrolStudents;
	}

	public List<Course> enrolledCourses(Student student) throws NotRegistered {
		if (!student.isRegistered())
			throw new NotRegistered();
		//List of enrolled courses from student courses table
		PreparedStatement stmt = null;
		List<Course> courses = new ArrayList<Course>();
		try {

			stmt = conn.prepareStatement(SQLConstantQueries.GET_ENROLLED_COURES_BY_STUDENT);
			stmt.setString(1, student.getStudentID());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				courses.add(new Course(rs.getString("courseID"), rs.getString("courseName"), rs.getString("professor"),
						Integer.parseInt(rs.getString("credit"))));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	public List<Course> selectedCourses(Student student) {
		PreparedStatement stmt = null;
		List<Course> courses = new ArrayList<Course>();
		try {
			// list of selectedcourses from student courses table
			stmt = conn.prepareStatement(SQLConstantQueries.GET_ENROLLED_COURES_BY_STUDENT);
			stmt.setString(1, student.getStudentID());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				courses.add(new Course(rs.getString("courseID"), rs.getString("courseName"), rs.getString("professor"),
						Integer.parseInt(rs.getString("credit"))));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	public List<Course> invalidCourses(Student student) {
		PreparedStatement stmt = null;
		List<Course> courses = new ArrayList<Course>();
		try {
			//list of invalid courses with strength>=10
			stmt = conn.prepareStatement(SQLConstantQueries.GET_INVALID_SELECTEDCOURSES);
			stmt.setString(1, student.getStudentID());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				courses.add(new Course(rs.getString("courseID"), rs.getString("courseName"), rs.getString("professor"),
						Integer.parseInt(rs.getString("credit"))));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	public void DropOtherCourses(Student student, List<Course> invalidCourses) {
		PreparedStatement stmt = null;
		try {
			//Drop invalid courses
			for (Course course : invalidCourses) {
				stmt = conn.prepareStatement(SQLConstantQueries.DROP_STUDENT_COURSES);
				stmt.setString(1, course.getCourseCode());
				stmt.setString(2, student.getStudentID() + "");
				stmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Student updateStudentDetails(Student student) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(SQLConstantQueries.UPDATE_STUDENT_DETAILS);
			// update details in student table
			stmt.setString(1, student.getGender());
			stmt.setString(2, student.getMajor());
			stmt.setString(3, student.getSem());
			stmt.setInt(4, student.getPercentage());
			stmt.setString(5, student.getStudentID());

			int rows = stmt.executeUpdate();
			logger.info(rows + " Student info updated");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return student;

	}
}
