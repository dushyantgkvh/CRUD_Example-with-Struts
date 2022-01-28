/*
 * package com.witty.struts.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.witty.struts.entity.Employee; import
 * com.witty.struts.service.EmployeeService;
 * 
 * @RestController
 * 
 * @RequestMapping(path = "/employee") public class EmployeeController {
 * 
 * @Autowired private EmployeeService employeeService;
 * 
 * @PostMapping(path = "/create") public Employee createEmployee(@RequestBody
 * Employee employee) { return employeeService.createEmployee(employee); }
 * 
 * @GetMapping(path = "/get") public List<Employee> getAllEmployee() { return
 * employeeService.getAllEmployee(); }
 * 
 * @GetMapping(path = "/get/{id}") public Employee
 * getEmployeeById(@PathVariable("id") int id) { return
 * employeeService.getEmployeeById(id); }
 * 
 * @PutMapping(path = "/edit/{id}") public Employee
 * updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
 * return employeeService.updateEmployee(id, employee); }
 * 
 * @DeleteMapping(path = "/delete/{id}") public void
 * deleteEmployee(@PathVariable("id") int id) {
 * employeeService.deleteEmployee(id); }
 * 
 * }
 */