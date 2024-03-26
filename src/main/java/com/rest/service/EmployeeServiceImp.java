package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.model.Employee;
import com.rest.repo.EmployeeRepo;

@Service
public class EmployeeServiceImp implements EmployeeService 
{
	@Autowired
	private EmployeeRepo repo;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		Employee emp=repo.save(employee);
		return emp;
	}

	@Override
	public Employee getEmployee(int eid) {
		Employee get=repo.findById(eid).get();
		return get;
	}
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employeeList=repo.findAll();
		return employeeList;
	}
	@Override
	public void deleteEmployee(int eid) {
		repo.deleteById(eid);
	}


	@Override
	public Employee updateEmployee(Employee employee, int eid) {
		Employee oldRecord=repo.findById(eid).get();
		oldRecord.setEmpName(employee.getEmpName());
		oldRecord.setSalary(employee.getSalary());
		oldRecord.setDesignation(employee.getDesignation());
		return repo.save(oldRecord);
	}

	

	

	

}
