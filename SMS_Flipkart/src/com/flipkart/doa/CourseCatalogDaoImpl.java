package com.flipkart.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.flipkart.utils.DBUtil;
import com.sms.constant.SQLConstantQueries;

public class CourseCatalogDaoImpl {

	Connection conn = DBUtil.getConnection();

	public void fetchCourseList() {
		PreparedStatement stmt = null;
		try {

			stmt = conn.prepareStatement(SQLConstantQueries.GET_COURSES_LIST);

			ResultSet rs = stmt.executeQuery(SQLConstantQueries.GET_COURSES_LIST);

			while (rs.next()) {
				// Retrieve by column name
				System.out.println("CourseID: " + rs.getString("courseCode") + ", name: " + rs.getString("")
						+ ", professor: " + rs.getString("professor") + ", credit: " + rs.getString("credit"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
