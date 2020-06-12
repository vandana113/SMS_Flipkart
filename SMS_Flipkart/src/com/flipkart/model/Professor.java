package com.flipkart.model;

import java.util.ArrayList;

public class Professor extends User{

	public Professor(String name, int profID, String dept, String job_title, String specialisation) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.profID = profID;
		this.dept = dept;
		this.job_title = job_title;
		this.specialisation = specialisation;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProfID() {
		return profID;
	}
	public void setProfID(int profID) {
		this.profID = profID;
	} 
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getSpecialisation() {
		return specialisation;
	}
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}
	public ArrayList<String> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<String> courses) {
		this.courses = courses;
	}

	private String name;
	private int profID;
	private String dept;
	private String job_title;
	private String specialisation;
	private ArrayList<String> courses;
}
