package com.satyam.Test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.satyam.entity.Admin;
import com.satyam.entity.Assignment;
import com.satyam.entity.Course;
import com.satyam.entity.Instructor;
import com.satyam.entity.Quiz;
import com.satyam.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Admin.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Assignment.class)
				.addAnnotatedClass(Quiz.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
//        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
//          
//        SessionFactory factory=meta.getSessionFactoryBuilder().build();  
//        Session session=factory.openSession();  
          
         //session.beginTransaction();  
		try {
			// create session
//		Session session = factory.getCurrentSession();
//		
//			// use the session object to save Java object
//			System.out.println("Create new student object");
//			Student tempStudent = new Student("Ram", "Gupta", "ram.g16@gmail.com");
//			
//			// start a transaction
//			session.beginTransaction();
//			
//			// save the student object
//			System.out.println("Saving the student..");
//			session.save(tempStudent);
//			
//			// commit transaction
//			session.getTransaction().commit();
//			System.out.println("Done");
//			
//			System.out.println(tempStudent);
//			
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			Student mystudent = session.get(Student.class, tempStudent.getId());
//			System.out.println(mystudent);
//			
//			session.getTransaction().commit();
//			
//			System.out.println("Done");

			// ----------------------------------------------------------

//			session.clear();
			session.beginTransaction();
			System.out.println("||||||||||||||STUDENT||||||||||||||||||");
			List<Student> students = session.createQuery("from Student").getResultList();

			for (Student theStudent : students) {
				System.out.println(theStudent);

			}
			System.out.println("||||||||||||||||||||ADMIN||||||||||||||||");



			List<Admin> admins = session.createQuery("from Admin").getResultList();

			for (Admin theAdmin : admins) {
				System.out.println(theAdmin);
				System.out.println(theAdmin.getUserName());

			}
			System.out.println("|||||||||||||||||INSTRUCTOR||||||||||||||||||||");
			List<Instructor> instructors = session.createQuery("from Instructor").getResultList();

			for (Instructor theInstructor : instructors) {
				System.out.println(theInstructor);

			}
//			System.out.println("|||||||||||||||||||STUDENT|||||||||||||||||||||");
//			List<Student> students = session.createQuery("from Student").getResultList();
//
//			for (Student theStudent : students) {
//				System.out.println(theStudent);
//
//			}
			
			System.out.println("|||||||||||||||||||Assignment|||||||||||||||||||||");
			List<Assignment> assignments = session.createQuery("from Assignment").getResultList();

			for (Assignment theAssignment : assignments) {
				System.out.println(theAssignment);

			}
			
			System.out.println("|||||||||||||||||||Quiz|||||||||||||||||||||");
			List<Quiz> quizes = session.createQuery("from Quiz").getResultList();

			for (Quiz theQuiz : quizes) {
				System.out.println(theQuiz);

			}
			
			System.out.println("||||||||||||||||||||||||||||||||||||||||||");

			session.getTransaction().commit();
			System.out.println("Done");

		} finally {
		    
               
			session.close();
			factory.close();
		}
	}

}
