package com.witty.struts.form;

import javax.persistence.EntityManager;

import com.witty.struts.entity.Employee;
import com.witty.struts.util.HibernateUtilWithEntityManager;

public class EntityManagerTest {

	public static void main(String[] args) {

		EntityManager manager = HibernateUtilWithEntityManager.getEntityManagerFactory().createEntityManager();

		Employee emp = new Employee();
		emp.setName("Aman");
		emp.setCompany("Witty");

		manager.getTransaction().begin();
		manager.persist(emp);
		manager.getTransaction().commit();
		
		Employee employee = manager.find(Employee.class, 2);
		System.out.println(employee);

		manager.close();
	}

}
