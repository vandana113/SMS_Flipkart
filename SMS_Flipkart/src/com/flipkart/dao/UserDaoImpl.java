package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.apache.log4j.Logger;

import com.flipkart.exception.LoginFailException;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;
import com.flipkart.model.User;
import com.flipkart.utils.DBUtil;
import com.flipkart.utils.QueryUtil;
import com.sms.constant.SQLConstantQueries;

public class UserDaoImpl implements UserDao {

	Connection conn = DBUtil.getConnection();
	// QueryUtil query = new QueryUtil();
	private static Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Override
	public boolean validateLogin(User user) throws LoginFailException {
		// TODO Auto-generated method stub
		logger.info("Inside validate login");
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(SQLConstantQueries.GET_USER_DETAILS);
			stmt.setString(1, user.getUsername());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				if (user.getPassword().equals(rs.getString("password"))) {
					logger.debug("Correct username and password");

					// Adding details about user
					user.setUserID(rs.getString("userID"));
					user.setRole(rs.getString("roleID"));

					return true;
				} else {
					logger.debug("Login unsuccesful");
					throw new LoginFailException();
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return false;
	}

	// Get details like name,userID about User(Student/Professor/Admin)
	// Professor info: title,course
	// Student info: gender
	public Student getStudentDetails(User user) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Student student = null;
		try {

			stmt = conn.prepareStatement(SQLConstantQueries.GET_STUDENT_DETAILS);
			stmt.setString(1, user.getUserID());
			rs = stmt.executeQuery();
			while (rs.next()) {
				student = new Student(user, rs.getString("name"), rs.getString("gender"), rs.getString("major"),
						rs.getString("sem"), rs.getBoolean("isRegistered"), rs.getInt("percentage"));
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return student;

	}

	public Professor getProfessorDetails(User user) {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		Professor professor = null;
		try {
			stmt = conn.prepareStatement(SQLConstantQueries.GET_PROFESSOR_DETAILS);
			stmt.setString(1, user.getUserID());
			rs = stmt.executeQuery();
			while (rs.next()) {

				professor = new Professor(user, rs.getString("name"), rs.getString("title"));

			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return professor;
	}

	public void addLoginDate(User user) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(SQLConstantQueries.ADD_LOGIN_DATE);
			LocalDate localDate = LocalDate.now();
			stmt.setString(1, localDate + "");
			stmt.executeUpdate();
		} catch (SQLException se) {
			// Handle errors for JDBC
			logger.debug(se.getMessage());
		} catch (Exception e) {
			// Handle errors for Class.forName
			logger.debug(e.getMessage());
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
		}

	}

}
