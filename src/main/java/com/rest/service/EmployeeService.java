package com.rest.service;
import java.util.*;
import com.rest.model.Employee;

public interface EmployeeService {
public Employee saveEmployee(Employee employee);
public Employee updateEmployee(Employee employee,int eid);
public void deleteEmployee(int eid);
public Employee getEmployee(int eid);
public List<Employee> getAllEmployee();
}
