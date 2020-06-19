package com.flipkart.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.crypto.URIReferenceException;

import org.apache.log4j.Logger;

import com.flipkart.model.Course;

import com.flipkart.model.Student;
import com.flipkart.model.User;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminOperation;

@Path("/admin")
public class AdminController {

	private static Logger logger = Logger.getLogger(AdminController.class);
	AdminInterface adminOperation = new AdminOperation();

	// http://localhost:8080/SMSRest2/rest/admin/registeredjson

	@GET
	@Path("/registeredjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getRegisteredStudentDetails() {
		System.out.println("Hello");
		logger.debug("Getting Student Details..");
		List<Student> students = adminOperation.getRegisteredStudents();
		return students;
	}

	@POST
	@Path("/addUser")
	@Consumes("application/json")
	// @Produces(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {
		logger.debug("UserID: " + user.getUserID() + " Role: " + user.getRole());
		adminOperation.addUser(user, user.getRole());
		return Response.status(200).entity("User " + user.getUserID() + " successfully added").build();
	}

	@DELETE
	@Path("/deleteUser/{username}")
	public Response deleteUser(@PathParam("username") String username) throws URIReferenceException {
		logger.debug("User to be deleted +" + username);
		adminOperation.removeUser(username);
		return Response.status(200).entity("User: " + username + " successfully deleted").build();
	}

	@POST
	@Path("/addCourse")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(Course course) {
		logger.debug("CourseID: " + course.getCourseID() + " CourseName: " + course.getCourseTitle());
		adminOperation.addCourse(course);
		return Response.status(200).entity("Course " + course.getCourseTitle() + " successfully added").build();
	}

	@DELETE
	@Path("/deleteCourse/{courseCode}")
	public Response deleteCourse(@PathParam("courseCode") String courseCode) throws URIReferenceException {
		logger.debug("Course to be deleted +" + courseCode);
		adminOperation.removeCourse(courseCode);
		return Response.status(200).entity("Course " + courseCode + " successfully deleted").build();
	}

	@PUT
	@Path("/updateCourse")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Course updateCourse(Course course) {
		logger.debug("CourseID: " + course.getCourseID() + " CourseName: " + course.getCourseTitle());
		adminOperation.updateCourse(course);
		return course;
	}

}
