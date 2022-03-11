package com.satyam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.satyam.dao.StudentDAO;
import com.satyam.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	// inject studentDAO
	@Autowired
	private StudentDAO studentDAO;

//	@Override
	@Transactional
	public List<Student> getStudents() {

		return studentDAO.getStudents();
	}

}
