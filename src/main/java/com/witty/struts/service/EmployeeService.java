/*
 * package com.witty.struts.service;
 * 
 * import java.util.List;
 * 
 * import javax.persistence.EntityManager; import javax.persistence.Query;
 * 
 * import org.hibernate.Session; import org.springframework.stereotype.Service;
 * 
 * import com.witty.struts.entity.Employee; import
 * com.witty.struts.util.HibernateUtil; import
 * com.witty.struts.util.HibernateUtilWithEntityManager;
 * 
 * @Service public class EmployeeService {
 * 
 * EntityManager entityManager =
 * HibernateUtilWithEntityManager.getEntityManagerFactory().createEntityManager(
 * ); //Session session = HibernateUtil.getSessionFactory().openSession();
 * public Employee createEmployee(Employee employee) {
 * 
 * // session.getTransaction().begin(); // session.remove(employee);
 * entityManager.getTransaction().begin(); entityManager.persist(employee);
 * entityManager.getTransaction().commit(); return employee;
 * 
 * }
 * 
 * public List<Employee> getAllEmployee() { Query query =
 * entityManager.createQuery("from Employee emp"); List list =
 * query.getResultList(); return list; }
 * 
 * public Employee getEmployeeById(int id) {
 * 
 * String query = "from Employee emp where emp.id=" + id; Query query2 =
 * entityManager.createQuery(query); Employee employeeById = (Employee)
 * query2.getResultList().get(0);
 * 
 * return employeeById; }
 * 
 * public Employee updateEmployee(int id, Employee employee) {
 * 
 * String query = "from Employee emp where emp.id=" + id; Query query2 =
 * entityManager.createQuery(query); Employee employeeById = (Employee)
 * query2.getResultList().get(0);
 * 
 * employeeById.setName(employee.getName());
 * employeeById.setCompany(employee.getCompany());
 * 
 * entityManager.getTransaction().begin(); entityManager.merge(employeeById);
 * entityManager.getTransaction().commit(); return employeeById; }
 * 
 * public void deleteEmployee(int id) {
 * 
 * String query = "from Employee emp where emp.id=" + id; Query query2 =
 * entityManager.createQuery(query); Employee employeeById = (Employee)
 * query2.getResultList().get(0);
 * 
 * entityManager.getTransaction().begin(); entityManager.remove(employeeById);
 * entityManager.getTransaction().commit();
 * 
 * }
 * 
 * }
 */