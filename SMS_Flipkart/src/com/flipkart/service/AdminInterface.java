package com.flipkart.service;

import com.flipkart.model.Account;
import com.flipkart.model.Course;

public interface AdminInterface {
	public Course addCourse();

	public int removeCourse(Course course);

	public void DeclareResult();

	public void manageAccount(Account acc);
	// Add Professor, Student

	public void GenerateAdminCard();

}
