package com.satyam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.satyam.dao.StudentDAO;
import com.satyam.entity.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentDAO studentDAO;

//	@Autowired
//	private StudentService studentService;

	@GetMapping("/students")
	public String listUsers(Model theModel) {

		List<Student> theStudents = studentDAO.getStudents();
//		List<Student> theStudents = studentService.getStudents();

		theModel.addAttribute("students", theStudents);

		return "list-users";
	}

	@GetMapping("/showFormForAddStudent")
	public String showFormForAddStudent(Model theModel) {

		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);

		return "student-form";
	}

	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student theStudent) {

		studentDAO.saveStudent(theStudent);

		return "redirect:/student/students";
	}

	@GetMapping("/showFormForUpdateStudent")
	public String showFormForUpdateStudent(@RequestParam("studentId") int theId, Model theModel) {

		// get student from db
		Student student = studentDAO.getStudent(theId);
		// set student as a model attribute to pre-populate the form
		theModel.addAttribute("student", student);
		// send over to our form

		return "student-form";
	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int theId) {
		
		studentDAO.deleteStudent(theId);

		return "redirect:/student/students";
	}

}
