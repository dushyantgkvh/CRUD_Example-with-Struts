package com.witty.struts.action;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.witty.struts.entity.Employee;
import com.witty.struts.util.HibernateUtilWithEntityManager;

public class NewEmployeeAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("Inside new action");

		EntityManager entityManager = HibernateUtilWithEntityManager.getEntityManagerFactory().createEntityManager();

		Employee emp = new Employee();
		emp.setName(request.getParameter("name").toString());
		emp.setCompany(request.getParameter("company").toString());

		entityManager.getTransaction().begin();
		entityManager.persist(emp);
		entityManager.getTransaction().commit();

		System.out.println("inserted...");

		Query query = entityManager.createQuery("select emp from Employee emp");
		List<Employee> empList = query.getResultList();
		request.setAttribute("employees", empList);

		return mapping.findForward("success");
	}

}
