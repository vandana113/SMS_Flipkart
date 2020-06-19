package com.flipkart.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryUtil {

	public void updateQuery(PreparedStatement stmt) {

		try {
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
		} // end try
	}

	public ResultSet selectQuery(PreparedStatement stmt) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
			//stmt.close();
			return rs;
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
		} // end try
		return rs;

	}

}
