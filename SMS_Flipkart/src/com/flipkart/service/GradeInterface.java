package com.flipkart.service;

public interface GradeInterface {

	public void addGrade(int courseId, int studentId, int grade);

	public void removeGrade(int courseId, int studentId, int grade);

	public void updateGrade(int courseId, int studentId, int grade);

}
