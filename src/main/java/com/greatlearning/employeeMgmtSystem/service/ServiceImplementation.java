package com.greatlearning.employeeMgmtSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeeMgmtSystem.entity.Employee;
import com.greatlearning.employeeMgmtSystem.repository.EmployeeRepository;

@Service
public class ServiceImplementation implements ServiceInterface {

	@Autowired
	EmployeeRepository empRepo;

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(int empId) {
		return empRepo.findById(empId).get();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return empRepo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee, int empId) {
		Employee employee2 = getEmployeeById(empId);
		employee2.setFirstName(employee.getFirstName());
		employee2.setLastName(employee.getLastName());
		employee2.setEmail(employee.getEmail());
		return saveEmployee(employee);
	}

	@Override
	public void deleteEmployeeById(int empId) {
		empRepo.deleteById(empId);
	}

}
