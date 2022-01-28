
package com.witty.struts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.witty.struts.entity.Employee;
import com.witty.struts.exception.NotFoundException;
import com.witty.struts.repository.EmployeeRepository;

@Service
public class EmployeeServiceWithJpa {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee createEmployee(Employee employee) {
		if (employee.getName().matches("^[A-Za-z]{1,29}") && employee.getCompany().matches("^[A-Za-z]{1,29}")) {
			return employeeRepository.save(employee);
		} else {
			throw new NotFoundException("Please enter a valid name and company");
		}
	}

	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();

	}

	public Employee getEmployeeById(int id) {
		Optional<Employee> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new NotFoundException("No employee record exist for given id");
		}
	}

	public Employee updateEmployee(int id, Employee employee) {
		Optional<Employee> employeeFindById = employeeRepository.findById(id);

		if (employeeFindById.isPresent()) {
			Employee newEmployee = employeeFindById.get();
			newEmployee.setName(employee.getName());
			newEmployee.setCompany(employee.getCompany());

			newEmployee = employeeRepository.save(newEmployee);
			return newEmployee;
		} else {
			throw new NotFoundException("No employee record exist for given id");
		}

	}

	public void deleteEmployeeById(int id) {
		Optional<Employee> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {
			employeeRepository.deleteById(id);
		} else {
			throw new NotFoundException("No employee found for given id");
		}
	}

}
