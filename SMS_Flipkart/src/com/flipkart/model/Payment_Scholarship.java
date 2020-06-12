package com.flipkart.model;

public class Payment_Scholarship extends Payment {

	public Payment_Scholarship() {
		// TODO Auto-generated constructor stub
	}

	private int scholarID;
	private int scholarAmount;
	private int period; // Duration of Scholarship

	public int getScholarID() {
		return scholarID;
	}

	public void setScholarID(int scholarID) {
		this.scholarID = scholarID;
	}

	public int getScholarAmount() {
		return scholarAmount;
	}

	public void setScholarAmount(int scholarAmount) {
		this.scholarAmount = scholarAmount;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}



}
