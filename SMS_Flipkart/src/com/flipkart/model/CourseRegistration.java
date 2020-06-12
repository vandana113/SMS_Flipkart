package com.flipkart.model;

public class CourseRegistration {

	public CourseRegistration() {
		// TODO Auto-generated constructor stub
	}

	private int courseID;
	private int registrationID;
	private int dateofRegister;
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public int getRegistrationID() {
		return registrationID;
	}
	public void setRegistrationID(int registrationID) {
		this.registrationID = registrationID;
	}
	public int getDateofRegister() {
		return dateofRegister;
	}
	public void setDateofRegister(int dateofRegister) {
		this.dateofRegister = dateofRegister;
	}

}
