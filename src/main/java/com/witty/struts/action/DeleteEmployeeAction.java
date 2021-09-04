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

public class DeleteEmployeeAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("Inside delete action");

		EntityManager entityManager = HibernateUtilWithEntityManager.getEntityManagerFactory().createEntityManager();

		int id = Integer.parseInt(request.getParameter("id").toString());
		System.out.println("Id : " + id);

		Employee emp = new Employee();
		emp.setId(id);

		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.contains(emp) ? emp : entityManager.merge(emp));
		entityManager.getTransaction().commit();

		System.out.println("deleted...");

		Query query = entityManager.createQuery("from Employee emp");
		List<Employee> empList = query.getResultList();
		request.setAttribute("employees", empList);

		return mapping.findForward("success");

	}

}
