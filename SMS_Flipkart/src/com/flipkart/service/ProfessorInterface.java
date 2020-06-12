package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.model.Course;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;

public interface ProfessorInterface {

	public ArrayList<Course> viewCourses(Professor p);

	public ArrayList<Student> viewEnrolledStudents(Professor p);

	public void markGrades(Student s);

}
