package com.flipkart.dao;

import java.util.List;
import java.util.UUID;

import com.flipkart.model.Student;

public interface RegistrationDao {
	/**
	 * 
	 * @param registrationID
	 * @param student
	 */
	//Register student
	public void registerStudents(UUID registrationID, Student student);

	/**
	 * 
	 * @return
	 */
	//List of registered students
	public List<Student> getRegisteredStudents();
}
