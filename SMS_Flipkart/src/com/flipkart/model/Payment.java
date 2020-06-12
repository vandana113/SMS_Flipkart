package com.flipkart.model;

public class Payment {

	public Payment() {
		// TODO Auto-generated constructor stub
	}

	private int amount;
	private int studentID;
	private String method; // Scholarship/RegularPay

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

}
