package com.flipkart.dao;

import java.util.List;

import com.flipkart.model.Course;
import com.flipkart.model.Student;

public interface CourseDao {
	public List<Course> fetchCourseList(Student student);

	public void updateCourseStrength(Student student, List<Course> selectedCourses);

	public List<Course> listAllCourses();

}
