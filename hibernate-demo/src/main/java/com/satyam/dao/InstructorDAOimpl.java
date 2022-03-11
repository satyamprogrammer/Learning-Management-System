package com.satyam.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.satyam.entity.Admin;
import com.satyam.entity.Instructor;
import com.satyam.entity.Student;

@Repository
public class InstructorDAOimpl implements InstructorDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public InstructorDAOimpl() {

	}

	@Override
	@Transactional
	public List<Instructor> getInstructors() {
		List<Instructor> instructors;

		try {

			Session session = sessionFactory.getCurrentSession();

			System.out.println(session);

			System.out.println("||||||||||||||INSTRUCTOR||||||||||||||||||");
			instructors = session.createQuery("from Instructor", Instructor.class).getResultList();

			for (Instructor theInstructor : instructors) {
				System.out.println(theInstructor);

			}
		}

		finally {

		}

		return instructors;
	}

}
