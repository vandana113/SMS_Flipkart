package com.flipkart.dao;

import java.util.List;

import com.flipkart.exception.NotRegistered;
import com.flipkart.model.Course;
import com.flipkart.model.Student;

public interface StudentCourseDao {
	public void addCourse(Student student, String courseCode);

	public List<Student> enrolledStudents(String courseCode);

	public void removeCourse(Student student, String courseCode);

	public List<Course> enrolledCourses(Student student) throws NotRegistered;

	public List<Course> selectedCourses(Student student);

	public List<Course> invalidCourses(Student student);

	public void DropOtherCourses(Student student, List<Course> invalidCourses);

	public Student updateStudentDetails(Student student);
}
