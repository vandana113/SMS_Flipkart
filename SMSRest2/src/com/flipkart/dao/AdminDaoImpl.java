package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import com.flipkart.constants.SQLConstantQueries;
import com.flipkart.model.Course;
import com.flipkart.model.User;
import com.flipkart.utils.DBUtil;
import com.flipkart.utils.QueryUtil;

public class AdminDaoImpl implements AdminDao {
	Connection conn = DBUtil.getConnection();
	private static Logger logger = Logger.getLogger(AdminDaoImpl.class);

	public void addUser(User user, String role) {
		PreparedStatement stmt = null;
		try {
			logger.info("Creating user..");
			stmt = conn.prepareStatement(SQLConstantQueries.ADD_USER);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, role);
			stmt.setString(4, user.getUserID());
			stmt.executeUpdate();
			logger.debug("User Added to Database..");
			switch (role) {
			case "1":
				stmt = conn.prepareStatement(SQLConstantQueries.ADD_STUDENT);
				stmt.setString(1, user.getUserID());
				stmt.setString(2, user.getUsername());
				stmt.executeUpdate();
				stmt.close();
				break;
			case "2":
				addProfessor(user);
				break;
			case "3":
				addAdmin(user);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addProfessor(User user) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(SQLConstantQueries.ADD_PROFESSOR);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getUserID());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addAdmin(User user) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(SQLConstantQueries.ADD_ADMIN);
			stmt.setString(1, user.getUserID());
			stmt.setString(2, user.getUsername());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteUser(String username) {
		PreparedStatement stmt = null;
		try {

			stmt = conn.prepareStatement(SQLConstantQueries.DELETE_USER);
			stmt.setString(1, username);
			stmt.executeUpdate();
			logger.info("User Deleted");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addCourse(Course course) {
		PreparedStatement stmt = null;
		try {

			stmt = conn.prepareStatement(SQLConstantQueries.ADD_COURSE_CATALOG);
			stmt.setString(1, course.getCourseID());
			stmt.setString(2, course.getCourseTitle());
			stmt.setString(3, course.getProfessor());
			stmt.setString(4, course.getCredit() + "");
			stmt.setString(5, course.getCatalogID());
			stmt.setInt(6, 0);
			stmt.executeUpdate();
			logger.info("Course Added");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCourse(String courseCode) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(SQLConstantQueries.DELETE_COURSE_CATALOG);
			stmt.setString(1, courseCode);
			QueryUtil query = new QueryUtil();
			query.updateQuery(stmt);
			logger.info("Course Deleted");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateCourse(Course course) {
		PreparedStatement stmt = null;
		try {

			stmt = conn.prepareStatement(SQLConstantQueries.UPDATE_COURSE_DETAILS);
			stmt.setString(1, course.getCourseTitle());
			stmt.setString(2, course.getProfessor());
			stmt.setString(3, course.getCredit() + "");
			stmt.setInt(4, course.getStrength());
			stmt.setString(5, course.getCourseID());
			stmt.executeUpdate();
			logger.info("Course Added");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void logOut() {
		// TODO Auto-generated method stub

	}

}
