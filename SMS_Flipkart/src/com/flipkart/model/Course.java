package com.flipkart.model;

public class Course {
	int courseTitle;

	public int getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(int courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public boolean isPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

	String courseCode;
	String professor;
	boolean primary;
	int credit;

}
