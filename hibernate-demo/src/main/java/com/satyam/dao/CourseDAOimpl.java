package com.satyam.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.satyam.entity.Course;

@Repository
public class CourseDAOimpl implements CourseDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CourseDAOimpl() {

	}

	@Override
	@Transactional
	public List<Course> getCourses() {
		List<Course> courses;

		try {

			Session session = sessionFactory.getCurrentSession();

			System.out.println(session);

			System.out.println("||||||||||||||COURSE||||||||||||||||||");
			courses = session.createQuery("from Course", Course.class).getResultList();

			for (Course theCourse : courses) {
				System.out.println(theCourse);

			}
		}

		finally {

		}

		return courses;
	}

}
