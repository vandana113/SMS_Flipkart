package com.flipkart.model;

public class Course {
	
	/**
	 * @param courseID
	 * @param courseTitle
	 * @param professor
	 * @param credit
	 */
	public Course(String courseID, String courseTitle, String professor, int credit) {
		this.courseTitle = courseTitle;
		this.courseID = courseID;
		this.professor = professor;
		this.credit = credit;
	}

	public Course() {

	}

	String courseTitle;

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseCode() {
		return courseID;
	}

	public void setCourseCode(String courseCode) {
		this.courseID = courseCode;
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

	String courseID;
	String professor;
	boolean primary;
	int credit;
	private String catalogID;
	private int strength;

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getCatalogID() {
		return catalogID;
	}

	public void setCatalogID(String catalogID) {
		this.catalogID = catalogID;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

}
