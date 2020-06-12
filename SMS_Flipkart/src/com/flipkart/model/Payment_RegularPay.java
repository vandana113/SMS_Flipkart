package com.flipkart.model;

public class Payment_RegularPay {

	public Payment_RegularPay() {
		// TODO Auto-generated constructor stub
	}

	private String payment_mode; // Cash,Cheque,Card
	private int amount;
	private int regID;
	private int transID;

	public int getTransID() {
		return transID;
	}

	public void setTransID(int transID) {
		this.transID = transID;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getRegID() {
		return regID;
	}

	public void setRegID(int regID) {
		this.regID = regID;
	}
}
