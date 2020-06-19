package com.flipkart.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DBUtil {
	private static final Logger logger = LoggerFactory.getLogger(DBUtil.class);

	private static Connection connection = null;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/sms_db";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "Vandana@98";

	public static Connection getConnection() {

		if (connection != null)
			return connection;
		else {
			try {
				Class.forName("com.mysql.jdbc.Driver");

				// Step 4 make/open a connection

				logger.debug("Connecting to database...");
				connection = DriverManager.getConnection(DB_URL, USER, PASS);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}

	}

	public static void closeConnection(Connection conn) {

	}

}
