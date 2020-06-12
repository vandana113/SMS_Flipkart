package com.flipkart.model;

public class Admin extends User{
	
	public Admin() {

	}

	public Admin(String name, int adminID) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.adminID = adminID;
	}

	private String name;
	private int adminID;
	private String userPrivileges;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getUserPrivileges() {
		return userPrivileges;
	}

	public void setUserPrivileges(String userPrivileges) {
		this.userPrivileges = userPrivileges;
	}

}
