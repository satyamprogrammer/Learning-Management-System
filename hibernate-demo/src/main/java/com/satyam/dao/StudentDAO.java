package com.satyam.dao;

import java.util.List;

import com.satyam.entity.Admin;
import com.satyam.entity.Student;

public interface StudentDAO {

	public List<Student> getStudents();

	public void saveStudent(Student theStudent);

	public Student getStudent(int theId);

	public void deleteStudent(int theId);

}
