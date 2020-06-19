package com.flipkart.dao;

import java.rmi.server.UID;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.flipkart.exception.NotRegistered;
import com.flipkart.model.Student;
import com.flipkart.utils.DBUtil;
import com.sms.constant.SQLConstantQueries;

public class PaymentDaoImpl implements PaymentDao {
	Connection conn = DBUtil.getConnection();
	private static Logger logger = Logger.getLogger(PaymentDaoImpl.class);

	public void addPaymentDetails(Student student, String mode, String modeNumber) throws NotRegistered {
		//Payment can only be done by registered user
		if (!student.isRegistered())
			throw new NotRegistered();
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(SQLConstantQueries.ADD_PAYMENT_DETAILS);
			stmt.setString(1, mode);
			stmt.setString(2, modeNumber);
			stmt.setString(3, "Payment successful");
			//Current Date
			long millis = System.currentTimeMillis();
			Date paymentDate = new Date(millis);
			stmt.setDate(5, paymentDate);
			
			//Random number for registration
			UUID transactionID = UUID.randomUUID();
			stmt.setString(4, transactionID + "");
			stmt.setString(6, student.getRegistrationID() + "");
			stmt.executeUpdate();
			java.util.Date date1 = new java.util.Date();
			logger.info("Student " + student.getStudentID() + " made payment at " + date1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
