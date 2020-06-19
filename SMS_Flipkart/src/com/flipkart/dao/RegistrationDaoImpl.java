package com.flipkart.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.flipkart.model.Student;
import com.flipkart.utils.DBUtil;
import com.sms.constant.SQLConstantQueries;

public class RegistrationDaoImpl implements RegistrationDao {
	Connection conn = DBUtil.getConnection();
	private static Logger logger = Logger.getLogger(RegistrationDaoImpl.class);

	public void registerStudents(UUID registrationID, Student student) {
		PreparedStatement stmt = null;

		try {

			stmt = conn.prepareStatement(SQLConstantQueries.ADD_REGISTRATION_DETAILS);
			stmt.setString(1, registrationID + "");
			stmt.setString(2, student.getStudentID() + "");

			int fees = 70000;
			int percentage = student.getPercentage();
			int scholarship = 0;

			// Percentage<60 not eligible for scholarship
			if (percentage >= 60 && percentage < 70)
				scholarship = 10;
			else if (percentage >= 70 && percentage < 80)
				scholarship = 20;
			else if (percentage >= 80 && percentage < 90)
				scholarship = 30;
			else if (percentage >= 90)
				scholarship = 40;
			logger.info("Fees: " + fees);
			logger.info("Scholarship: " + scholarship + "%");
			fees = fees + ((scholarship / 100) * fees);

			stmt.setInt(3, fees);
			stmt.setInt(4, scholarship);

			long millis = System.currentTimeMillis();
			Date date = new Date(millis);
			stmt.setDate(5, date);

			stmt.executeUpdate();
			logger.info("Student " + student.getStudentID() + " registered courses at " + date);

			stmt = conn.prepareStatement(SQLConstantQueries.SET_REGISTERED_TRUE);
			stmt.setString(1, student.getStudentID());
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Student> getRegisteredStudents() {
		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		List<Student> registeredStudents = new ArrayList<Student>();
		try {
			// List of students already registered from registration table
			stmt = conn.prepareStatement(SQLConstantQueries.GET_REGISTERED_STUDENTS);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Student student = new Student(rs.getString("studentID"), rs.getString("name"), rs.getString("gender"),
						rs.getString("major"), rs.getString("sem"), rs.getBoolean("isRegistered"),
						rs.getInt("percentage"));
				registeredStudents.add(student);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return registeredStudents;
	}

}
