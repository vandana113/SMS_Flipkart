package com.flipkart.model;

public class Admin extends User {

	public Admin() {

	}

	// Intialisation of admin
	public Admin(String name, String adminID, String description) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.adminID = adminID;
		this.description = description;
	}

	private String name;
	private String adminID;
	// Describing admin privileges
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdminID() {
		return adminID;
	}

	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
