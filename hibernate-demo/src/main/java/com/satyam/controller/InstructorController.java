package com.satyam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.satyam.dao.InstructorDAO;
import com.satyam.entity.Instructor;

@Controller
@RequestMapping("/instructor")
public class InstructorController {
	
	@Autowired
	private InstructorDAO instructorDAO;
	
	@RequestMapping("/instructors")
	public String listUsers(Model theModel) {
		
		List<Instructor> theInstructors = instructorDAO.getInstructors();
		
		theModel.addAttribute("instructors", theInstructors);
		
		return "list-instructors";
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
