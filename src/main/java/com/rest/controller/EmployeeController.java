package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Employee;
import com.rest.service.EmployeeService;

@RestController
@CrossOrigin(origins = { "*" })
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@PostMapping("/save")
	public String save(@RequestBody Employee employee)
	{
		Employee e1=employeeService.saveEmployee(employee);
		String message=null;
		if(e1!=null)
		{
			message="Data Inserted Successfully....";
		}
		else {
			message="Data failed";
		}
		return message;
	}
	@GetMapping("/get/{eid}")
	public Employee getEmp(@PathVariable int eid)
	{
		Employee getOneEmployee=employeeService.getEmployee(eid);
		return getOneEmployee;
	}
	@GetMapping("/getAll")
	public List<Employee> getAllEmps() {
		List<Employee> employeeList=employeeService.getAllEmployee();
		return employeeList;
	}
	@DeleteMapping("/delete/{eid}")
	public void delete(@PathVariable int eid)
	{
		employeeService.deleteEmployee(eid);
		String message="record deleted";
	}
	@PutMapping("/update/{eid}")
	public Employee update(@RequestBody Employee employee,
			@PathVariable int eid)
	{
		Employee update=employeeService.updateEmployee(employee, eid);
		return update; 
	}
}
