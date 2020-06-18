package com.flipkart.model;

import org.apache.log4j.Logger;

public class Professor extends User {
	private static Logger logger = Logger.getLogger(Professor.class);

	public Professor(User user, String name, String title) {
		// TODO Auto-generated constructor stub
		super(user.getUsername(), user.getUsername());
		this.name = name;
		this.profID = user.getUserID();
		this.title = title;
	}

	public Professor() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfID() {
		return profID;
	}

	public void setProfID(String profID) {
		this.profID = profID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String name;
	private String profID;
	private String title;
}
