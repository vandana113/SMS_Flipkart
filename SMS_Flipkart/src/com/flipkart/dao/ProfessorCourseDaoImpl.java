package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.model.Course;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;
import com.flipkart.utils.DBUtil;
import com.sms.constant.SQLConstantQueries;

public class ProfessorCourseDaoImpl implements ProfessorCourseDao {
	Connection conn = DBUtil.getConnection();
	private static Logger logger = Logger.getLogger(ProfessorCourseDaoImpl.class);

	public void addCourse(Professor professor, String courseCode) {

		PreparedStatement stmt = null;
		try {

			stmt = conn.prepareStatement(SQLConstantQueries.ADD_COURSE_PROFESSOR);
			stmt.setString(1, professor.getProfID());
			stmt.setString(2, courseCode);
			int rows = stmt.executeUpdate();
			logger.info(rows + " Course Added");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeCourse(Professor professor, String courseCode) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(SQLConstantQueries.DELETE_COURSE_PROFESSOR);
			stmt.setString(1, courseCode);
			stmt.setString(2, professor.getProfID());
			int rows = stmt.executeUpdate();
			logger.info(rows + " Course Deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Course> taughtCourse(Professor professor) {
		PreparedStatement stmt = null;
		List<Course> courses = new ArrayList<Course>();
		try {

			stmt = conn.prepareStatement(SQLConstantQueries.GET_COURSES_TAUGHT);
			stmt.setString(1, professor.getProfID());
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

	public Professor updateProfessorDetails(Professor professor) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(SQLConstantQueries.UPDATE_PROFESSOR_DETAILS);
			stmt.setString(1, professor.getTitle());
			stmt.setString(2, professor.getProfID());

			int rows = stmt.executeUpdate();
			logger.info(rows + " Professor info updated");

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return professor;

	}

}
