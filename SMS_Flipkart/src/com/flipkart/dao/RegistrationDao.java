package com.flipkart.dao;

import java.util.List;
import java.util.UUID;

import com.flipkart.model.Student;

public interface RegistrationDao {
	public void registerStudents(UUID registrationID, Student student);

	

	public List<Student> getRegisteredStudents();
}
