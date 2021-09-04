package com.witty.struts.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.witty.struts.entity.Student;
import com.witty.struts.util.HibernateUtil;

public class StudentDaoAction {

	public void saveStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start a transaction
			transaction = session.beginTransaction();

			// save the student object
			session.save(student);

			// commit transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Student> getStudents() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("Select s From Student s", Student.class).list();
		}
	}

	public static void main(String[] args) {
		StudentDaoAction studentDao = new StudentDaoAction();
		Student student = new Student("Ankit", "Kumar", "ankitkumar347@gmail.com");
		studentDao.saveStudent(student);

		List<Student> students = studentDao.getStudents();
		students.forEach(s -> System.out.println(s.getFirstName()));
		students.forEach(s -> System.out.println(s.getLastName()));
	}
}
