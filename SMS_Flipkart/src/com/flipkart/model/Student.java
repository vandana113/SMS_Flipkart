package com.flipkart.model;

import java.util.UUID;

public class Student extends User {

	public Student() {

	}

	public Student(String username, String password) {
		this.setUserID(username);
		this.setPassword(password);
		this.isRegistered = false;
	}

	public Student(User user, String name, String gender, String major, String sem, boolean isRegistered,
			int percentage) {
		// TODO Auto-generated constructor stub
		super(user.getUsername(), user.getPassword());
		this.name = name;
		this.studentID = user.getUserID();
		this.gender = gender;
		this.major = major;
		this.sem = sem;
		this.isRegistered = isRegistered;
		this.percentage = percentage;
	}

	public Student(String studentID, String name, String gender, String major, String sem, boolean isRegistered,
			int percentage) {
		// TODO Auto-generated constructor stub

		this.name = name;
		this.studentID = studentID;
		this.gender = gender;
		this.major = major;
		this.isRegistered = isRegistered;
		this.percentage = percentage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	private String name;
	private String gender;
	private String major;
	private String sem;
	private boolean isRegistered;
	private int percentage;
	private UUID registrationID;

	public String getSem() {
		return sem;
	}

	public void setSem(String sem) {
		this.sem = sem;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public boolean isRegistered() {
		return isRegistered;
	}

	public void setRegistered(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	public UUID getRegistrationID() {
		return registrationID;
	}

	public void setRegistrationID(UUID registrationID) {
		this.registrationID = registrationID;
	}

	private String studentID;

}
