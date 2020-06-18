package com.flipkart.dao;

import java.util.List;

import com.flipkart.model.Grade;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;

public interface GradeDao {

	public void addGrades(Professor professor, String studentID, String courseID, String grade);

	public List<Grade> ViewGrades(Student student);
}
