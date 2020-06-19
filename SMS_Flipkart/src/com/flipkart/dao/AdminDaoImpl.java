package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.flipkart.model.Course;
import com.flipkart.model.User;
import com.flipkart.utils.DBUtil;
import com.flipkart.utils.QueryUtil;
import com.sms.constant.SQLConstantQueries;

public class AdminDaoImpl implements AdminDao {
	Connection conn = DBUtil.getConnection();
	private static Logger logger = Logger.getLogger(AdminDaoImpl.class);


	public void addUser(User user, String role) {
		PreparedStatement stmt = null;
		try {
			logger.info("Creating user..");
			stmt = conn.prepareStatement(SQLConstantQueries.ADD_USER);
			//Assigning parameters to statement
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, role);
			stmt.setString(4, user.getUserID());
			//Adding user to userDB
			stmt.executeUpdate();
			logger.debug("User Added to Database..");
			//After adding to userDB
			//Adding user to their respective DBs acc to role
			switch (role) {
			case "1":
				//Adding user to studentDB
				stmt = conn.prepareStatement(SQLConstantQueries.ADD_STUDENT);
				stmt.setString(1, user.getUserID());
				stmt.setString(2, user.getUsername());
				stmt.executeUpdate();
				stmt.close();
				break;
			case "2":
				//Adding user to professorDB
				addProfessor(user);
				break;
			case "3":
				//Adding user to AdminDB
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
			//Query to add user to professorDB
			stmt = conn.prepareStatement(SQLConstantQueries.ADD_PROFESSOR);
			//Bind values into parameters
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getUserID()); 
			//Update Query to insert into professor table
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addAdmin(User user) {
		PreparedStatement stmt = null;
		try {
			//Query to add to admin table
			stmt = conn.prepareStatement(SQLConstantQueries.ADD_ADMIN);
			//Bind values into parameters
			stmt.setString(1, user.getUserID());
			stmt.setString(2, user.getUsername());
			//Update Query to insert into admin table
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteUser(String username) {
		PreparedStatement stmt = null;
		try {
			//Query to delete user from user and their respective table using username
			stmt = conn.prepareStatement(SQLConstantQueries.DELETE_USER);
			//Bind values into parameters
			stmt.setString(1, username);
			stmt.executeUpdate();
			//User deleted successfully
			logger.info("User Deleted");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addCourse(Course course) {
		PreparedStatement stmt = null;
		try {
			//Query to add course and details are obtained from the user 
			stmt = conn.prepareStatement(SQLConstantQueries.ADD_COURSE_CATALOG);
			//Bind values into parameters
			stmt.setString(1, course.getCourseCode());
			stmt.setString(2, course.getCourseTitle());
			stmt.setString(3, course.getProfessor());
			stmt.setString(4, course.getCredit() + "");
			stmt.setString(5, course.getCatalogID());
			stmt.setInt(6, 0);
			//Update course table from details obtained course object
			stmt.executeUpdate();
			//Course successfully added
			logger.info("Course Added");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCourse(String courseCode) {
		PreparedStatement stmt = null;
		try {
			//Query to delete course using courseID of course
			stmt = conn.prepareStatement(SQLConstantQueries.DELETE_COURSE_CATALOG);
			stmt.setString(1, courseCode);
			QueryUtil query = new QueryUtil();
			//Add
			query.updateQuery(stmt);
			logger.info("Course Deleted");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void logOut() {
		// TODO Auto-generated method stub

	}

}
