package com.flipkart.dao;

import java.util.List;

import com.flipkart.model.Course;
import com.flipkart.model.Professor;

public interface ProfessorCourseDao {
	public void addCourse(Professor professor, String courseCode);

	public void removeCourse(Professor professor, String courseCode);

	public List<Course> taughtCourse(Professor professor);

	public Professor updateProfessorDetails(Professor professor);

}
