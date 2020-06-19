package com.flipkart.model;

public class Grade {
	//Grade of students

	public Grade() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param studentID
	 * @param courseID
	 * @param courseName
	 * @param grade
	 */

	public Grade(String studentID, String courseID, String courseName, int grade) {
		this.studentID = studentID;
		this.courseID = courseID;
		this.courseName = courseName;
		this.grade = grade;
		if (this.grade > 50)
			this.setPass(true);
	}

	private String studentID;
	private String courseID;
	private String courseName;
	private int grade;
	private boolean pass;

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public boolean isPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}

}
