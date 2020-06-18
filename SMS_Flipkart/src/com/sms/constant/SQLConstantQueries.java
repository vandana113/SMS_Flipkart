package com.sms.constant;

public class SQLConstantQueries {
	// Get info about user like role and userID
	public static final String GET_USER_DETAILS = "select * from user where username=?";
	public static final String GET_STUDENT_DETAILS = "select * from student where studentID=?";
	public static final String GET_PROFESSOR_DETAILS = "select * from professor where professorID=?";

	public static final String GET_COURSES_LIST = "SELECT * from course inner join coursecatalog as cc on course.catalogID=cc.catalogID where cc.catalogName=? and cc.sem=? and course.strength<10";
	public static final String GET_COURSES_CATALOG = "select cc.catalogID,c.courseID,c.courseName,c.strength from course as c inner join coursecatalog as cc on cc.catalogID=c.catalogID";

	public static final String ADD_LOGIN_DATE = "UPDATE user set loginDate=? where username=?";

	public static final String ADD_COURSE = "insert into studentcourses values(?,?)";
	public static final String DELETE_COURSE = "DELETE from studentcourses where courseID=? and studentID=?";
	public static final String GET_ENROLLED_COURES_BY_STUDENT = "Select * from course inner join studentcourses as sc on sc.courseID=course.courseID where sc.studentID=?";
	public static final String GET_ENROLLED_STUDENTS = "select s.name,s.major from student as s inner join studentcourses as sc on sc.studentID=s.studentID where sc.courseID=?";
	public static final String GET_STRENGTH = "select strength from course where courseID=?";
	public static final String UPDATE_COURSE = "update course set strength=? where courseID=?";

	public static final String ADD_COURSE_PROFESSOR = "insert into professorcourses values(?,?)";
	public static final String DELETE_COURSE_PROFESSOR = "DELETE from professorcourses where courseID=? and professorID=?";
	public static final String GET_COURSES_TAUGHT = "Select * from course inner join professorcourses as pc on pc.courseID=course.courseID where pc.professorID=?";

	public static final String GET_INVALID_SELECTEDCOURSES = "Select * from course inner join studentcourses as sc on sc.courseID=course.courseID where sc.studentID=? and course.strength>=10";
	public static final String DROP_STUDENT_COURSES = "Delete from studentcourses where courseID=? and studentID=?";

	public static final String ADD_REGISTRATION_DETAILS = "insert into registration values(?,?,?,?,?)";
	public static final String SET_REGISTERED_TRUE = "update student set isRegistered=1 where studentID=?";

	public static final String ADD_PAYMENT_DETAILS = "insert into payment values(?,?,?,?,?,?)";
	public static final String ADD_REGISTRATIONID_TO_PAYMENT = "insert into payment values(null,null,null,null,null,?)";

	public static final String ADD_GRADES = "insert into grade values(?,?,?,?)";

	public static final String ADD_COURSE_CATALOG = "insert into course values (?,?,?,?,?,?)";
	public static final String DELETE_COURSE_CATALOG = "Delete from course where courseID=?";

	public static final String DELETE_USER = "Delete from user where username=?";
	public static final String ADD_USER = "insert into user values(?,?,?,?)";
	public static final String ADD_STUDENT = "insert into student values(?,?,null,null,null,0,null)";
	public static final String ADD_PROFESSOR = "insert into professor values(?,null,?)";
	public static final String ADD_ADMIN = "insert into admin values(?,?,null)";
	public static final String UPDATE_STUDENT_DETAILS = "update student set gender=?,major=?,sem=?,percentage=? where studentID=?";
	public static final String UPDATE_PROFESSOR_DETAILS = "update professor set title=? where professorID=?";

	public static final String GET_STUDENT_ENROLLEDCOURSES = "select courseName from course where course IN(select courseID from where studentID=?)";

	public static final String CHECK_REGISTERED_STUDENT = "select * from registration where studentID=?";
	public static final String VIEW_GRADES = "select c.courseID,c.courseName,g.grade from grade as g inner join course as c on c.courseID=g.courseID where studentID=?";

	public static final String GET_REGISTERED_STUDENTS = "select * from student inner join registration on student.studentID=registration.studentID";
}
