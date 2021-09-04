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

public class EditEmployeeAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out.println("Inside edit action");

		EntityManager entityManager = HibernateUtilWithEntityManager.getEntityManagerFactory().createEntityManager();

		int id = Integer.parseInt(request.getParameter("id").toString());
		System.out.println("Id : " + id);

		String query = "from Employee emp where emp.id="+id;
		Query query2 = entityManager.createQuery(query);
		Employee employeeById = (Employee) query2.getResultList().get(0);
		request.setAttribute("employee", employeeById);

		Employee emp = new Employee();
		emp.setName(request.getParameter("name").toString());
		emp.setCompany(request.getParameter("company").toString());
		emp.setId(Integer.parseInt(request.getParameter("id").toString()));

		entityManager.getTransaction().begin();
		entityManager.merge(emp);
		entityManager.getTransaction().commit();

		System.out.println("updated...");

		Query query3 = entityManager.createQuery("select emp from Employee emp");
		List<Employee> empList = query3.getResultList();
		request.setAttribute("employees", empList);

		return mapping.findForward("success");
	}

}
