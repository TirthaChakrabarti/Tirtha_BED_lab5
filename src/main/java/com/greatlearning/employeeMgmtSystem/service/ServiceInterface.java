package com.greatlearning.employeeMgmtSystem.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.greatlearning.employeeMgmtSystem.entity.Employee;

@Component
public interface ServiceInterface {

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(int empId);

	public Employee saveEmployee(Employee employee);

	public Employee updateEmployee(Employee employee, int empId);

	public void deleteEmployeeById(int empId);
}
