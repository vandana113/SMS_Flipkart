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

public class CourseDaoImpl implements CourseDao {

	Connection conn = DBUtil.getConnection();
	private static Logger logger = Logger.getLogger(CourseDaoImpl.class);

	public List<Course> fetchCourseList(Student student) {
		PreparedStatement stmt = null;
		List<Course> courses = new ArrayList<Course>();
		try {
			stmt = conn.prepareStatement(SQLConstantQueries.GET_COURSES_LIST);
			//getting list of courses based on major and semester of student
			stmt.setString(1, student.getMajor());
			stmt.setString(2, student.getSem());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Retrieve by column name
				Course c = new Course();
				c.setCourseCode(rs.getString("courseID"));
				c.setCourseTitle(rs.getString("courseName"));
				c.setProfessor(rs.getString("professor"));
				c.setCredit(Integer.parseInt(rs.getString("credit")));
				c.setCatalogID(rs.getString("catalogID"));
				//adding to course to list
				courses.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	public void updateCourseStrength(Student student, List<Course> selectedCourses) {
		PreparedStatement stmt = null;
		try {
			for (Course course : selectedCourses) {
				//Getting current strength of course
				stmt = conn.prepareStatement(SQLConstantQueries.GET_STRENGTH);
				stmt.setString(1, course.getCourseCode());
				ResultSet rs = stmt.executeQuery();
				int strength = 0;
				//Retrieve by column name
				while (rs.next()) {
					strength = rs.getInt("strength");
				}
				//Updating strength off course by 1
				stmt = conn.prepareStatement(SQLConstantQueries.UPDATE_COURSE);
				stmt.setInt(1, strength + 1);
				stmt.setString(2, course.getCourseCode());
				stmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/// List all the courses available in all catalog
	public List<Course> listAllCourses() {
		PreparedStatement stmt = null;
		List<Course> courses = new ArrayList<Course>();
		try {
			//Getting all courses in course table
			stmt = conn.prepareStatement(SQLConstantQueries.GET_COURSES_CATALOG);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Course c = new Course();
				c.setCourseCode(rs.getString("courseID"));
				c.setCourseTitle(rs.getString("courseName"));
				c.setCatalogID(rs.getString("catalogID"));
				c.setStrength(rs.getInt("strength"));
				courses.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;

	}

	public void addCourse(Course course) {
		PreparedStatement stmt = null;
		try {
			//Add course to course table
			stmt = conn.prepareStatement(SQLConstantQueries.ADD_COURSE_CATALOG);
			stmt.setString(1, course.getCourseCode());
			stmt.setString(2, "IT");
			stmt.setString(3, course.getCourseTitle());
			stmt.setString(4, course.getProfessor());
			stmt.setString(5, course.getCredit() + "");
			stmt.executeUpdate();
			logger.info("Course Added");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
