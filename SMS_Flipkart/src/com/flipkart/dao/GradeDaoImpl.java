package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.flipkart.model.Grade;
import com.flipkart.model.Professor;
import com.flipkart.model.Student;
import com.flipkart.utils.DBUtil;
import com.sms.constant.SQLConstantQueries;

public class GradeDaoImpl implements GradeDao {
	Connection conn = DBUtil.getConnection();
	StudentCourseDao courseDBOperation = new StudentCourseDaoImpl();
	private static Logger logger = Logger.getLogger(GradeDaoImpl.class);

	public void addGrades(Professor professor, String studentID, String courseID, String grade) {
		// Insert grades into course_student_grade table
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(SQLConstantQueries.ADD_GRADES);
			//Adding parameter values
			stmt.setString(1, courseID);
			stmt.setString(2, studentID);
			stmt.setString(4, professor.getProfID());
			stmt.setString(3, grade);
			//no of rows effected
			int rows = stmt.executeUpdate();
			logger.info(rows + " student grades added");
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Grade> ViewGrades(Student student) {
		List<Grade> grades = new ArrayList<Grade>();
		PreparedStatement stmt = null;

		try {
			//Query to view grades using studentID
			stmt = conn.prepareStatement(SQLConstantQueries.VIEW_GRADES);
			stmt.setString(1, student.getStudentID());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				grades.add(new Grade(student.getStudentID(), rs.getString("courseID"), rs.getString("courseName"),
						rs.getInt("grade")));
			}
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return grades;
	}

}
