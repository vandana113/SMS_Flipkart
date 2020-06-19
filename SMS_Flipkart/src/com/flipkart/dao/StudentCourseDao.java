package com.flipkart.dao;

import java.util.List;

import com.flipkart.exception.NotRegistered;
import com.flipkart.model.Course;
import com.flipkart.model.Student;

public interface StudentCourseDao {
	/**
	 * Add new selected course
	 * 
	 * @param student
	 * @param courseCode
	 */
	public void addCourse(Student student, String courseCode);

	/**
	 * Display enrolled Students in course using courseCode
	 * 
	 * @param courseCode
	 * @return
	 */
	public List<Student> enrolledStudents(String courseCode);

	/**
	 * Remove a selected course
	 * 
	 * @param student
	 * @param courseCode
	 */
	public void removeCourse(Student student, String courseCode);

	/**
	 * List of enrolled after registration
	 * 
	 * @param student
	 * @return
	 * @throws NotRegistered
	 */
	public List<Course> enrolledCourses(Student student) throws NotRegistered;

	/**
	 * list of selected courses
	 * 
	 * @param student
	 * @return
	 */
	public List<Course> selectedCourses(Student student);

	/**
	 * List courses with strength>=10
	 * 
	 * @param student
	 * @return
	 */
	public List<Course> invalidCourses(Student student);

	/**
	 * Drop invalid courses from student courses
	 * 
	 * @param student
	 * @param invalidCourses
	 */
	public void DropOtherCourses(Student student, List<Course> invalidCourses);

	/**
	 * Update Profile: Gender, Major, Semester
	 * 
	 * @param student
	 * @return
	 */
	public Student updateStudentDetails(Student student);
}
