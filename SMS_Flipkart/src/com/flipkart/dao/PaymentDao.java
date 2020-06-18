package com.flipkart.dao;

import com.flipkart.exception.NotRegistered;
import com.flipkart.model.Student;

public interface PaymentDao {
	public void addPaymentDetails(Student student, String mode, String modeNumber) throws NotRegistered;
	

}
