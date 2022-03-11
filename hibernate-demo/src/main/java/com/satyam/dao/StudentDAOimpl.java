package com.satyam.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.satyam.entity.Student;

@Repository
public class StudentDAOimpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public StudentDAOimpl() {

	}

	@Override
	@Transactional
	public List<Student> getStudents() {
		List<Student> students;

		try {

			Session session = sessionFactory.getCurrentSession();

			System.out.println(session);

			System.out.println("||||||||||||||STUDENT||||||||||||||||||");
			students = session.createQuery("from Student order by lastName", Student.class).getResultList();

			for (Student theStudent : students) {
				System.out.println(theStudent);

			}
		}

		finally {

		}

		return students;
	}

	@Override
	@Transactional
	public void saveStudent(Student theStudent) {
		try {

			Session session = sessionFactory.getCurrentSession();

			System.out.println(session);

			System.out.println(theStudent);
			session.saveOrUpdate(theStudent);
			System.out.println("Saved!!");

		} finally {

		}
	}

	@Override
	@Transactional
	public Student getStudent(int theId) {
		Student student;
		try {

			Session session = sessionFactory.getCurrentSession();

			System.out.println(session);

			student = session.get(Student.class, theId);

		} finally {

		}
		return student;
	}

	@Override
	@Transactional
	public void deleteStudent(int theId) {

		try {

			Session session = sessionFactory.getCurrentSession();
			
			Query theQuery = session.createQuery("delete from Student where id=:studentId");
			theQuery.setParameter("studentId", theId);
			
			theQuery.executeUpdate();
			

		} finally {

		}
	}
}
