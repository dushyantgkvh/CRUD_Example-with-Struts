package com.witty.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.witty.struts.entity.Student;
import com.witty.struts.form.HelloForm;
import com.witty.struts.util.HibernateUtil;

public class HelloAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HelloForm hf = (HelloForm) form;
		ActionForward fw = mapping.getInputForward();

		if (hf != null && hf.getUsername().equalsIgnoreCase("Java") && hf.getPassword().equals("1234")) {
			fw = mapping.findForward("success");
		} else {
			ActionErrors errs = new ActionErrors();
			errs.add("", new ActionMessage("hello.msg.err"));
			saveErrors(request, errs);
		}

		Student student = new Student("Ankita", "Kumari", "ankitkumar347@gmail.com");
		saveStudent(student);
		getStudents();
//		print();

		return fw;
	}

	public static void saveStudent(Student student) {
		Transaction transaction = null;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {

			// start a transaction
			transaction = session.beginTransaction();

			// save the student object
			session.save(student);

			session.save(null);

			// commit transaction
//			 transaction.commit();

			if (transaction.getStatus().equals(TransactionStatus.ACTIVE)) {
				transaction.commit();
			}

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (transaction.getStatus().equals(TransactionStatus.ACTIVE)) {
				transaction.commit();
			}
			session.close();
		}

	}

	public static List<Student> getStudents() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("Select s From Student s", Student.class).list();
		}
	}

	public static void print() {
		StudentDaoAction studentDao = new StudentDaoAction();
		Student student = new Student("Ankita", "Kumari", "ankitkumar347@gmail.com");
		studentDao.saveStudent(student);

		List<Student> students = studentDao.getStudents();
		students.forEach(s -> System.out.println(s.getFirstName()));
		students.forEach(s -> System.out.println(s.getLastName()));
	}

}
