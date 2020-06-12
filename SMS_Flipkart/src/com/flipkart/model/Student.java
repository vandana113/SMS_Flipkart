package com.flipkart.model;

import java.util.ArrayList;

public class Student extends User{

	public Student(String name, String studentID, String email) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.studentID = studentID;
		this.email = email;
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

	public int getMarks() {
		return cumulative_marks;
	}

	public void setMarks(int cumulative_marks) {
		this.cumulative_marks = cumulative_marks;
	}
	
	public String getEmail() {
		return email;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public int getCumulative_marks() {
		return cumulative_marks;
	}

	public void setCumulative_marks(int cumulative_marks) {
		this.cumulative_marks = cumulative_marks;
	}

	private String name;
	private String email;
	private String DOB;

	private String studentID;
	private String major;
	private int cumulative_marks;

}
