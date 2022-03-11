package com.satyam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.satyam.dao.CourseDAO;
import com.satyam.entity.Course;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseDAO courseDAO;
	
	@RequestMapping("/courses")
	public String listCourses(Model theModel) {
		
		List<Course> theCourses = courseDAO.getCourses();
		
		theModel.addAttribute("courses", theCourses);
		
		return "list-courses";
	}
	
//	@RequestMapping("/admins")
//	public String listAdmins(Model theModel) {
//		
//		List<Student> theStudents = studentDAO.getAdmins();
//		
//		theModel.addAttribute("students", theStudents);
//		
//		return "list-users";
//	}

}
