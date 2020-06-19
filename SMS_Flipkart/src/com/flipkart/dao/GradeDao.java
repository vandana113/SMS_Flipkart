package com.flipkart.dao;

import java.util.List;

import com.flipkart.model.Grade;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;

public interface GradeDao {

	// Add Student Grades
	/**
	 * 
	 * @param professor
	 * @param studentID
	 * @param courseID
	 * @param grade
	 */
	public void addGrades(Professor professor, String studentID, String courseID, String grade);

	// View Grades of student
	/**
	 * 
	 * @param student
	 * @return
	 */
	public List<Grade> ViewGrades(Student student);
}
