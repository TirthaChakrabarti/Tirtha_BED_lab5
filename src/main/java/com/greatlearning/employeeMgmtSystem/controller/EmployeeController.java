package com.greatlearning.employeeMgmtSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.employeeMgmtSystem.entity.Employee;
import com.greatlearning.employeeMgmtSystem.service.ServiceImplementation;

@Controller
public class EmployeeController {

	@Autowired
	ServiceImplementation service;
	
	@RequestMapping("/")
	public String start() {
		return "homepage";
	}

	@GetMapping("/employees")
	private String listEmployees(Model model) {
		model.addAttribute("employees", service.getAllEmployees());
		return "employees";
	}

	@GetMapping("/employees/new")
	private String createEmployee(Model model) {
		Employee employee = new Employee();

		model.addAttribute("employee", employee);
		return "create_employee";
	}

	@PostMapping("/employees")
	private String saveEmployees(@ModelAttribute("employee") Employee employee) {

		service.saveEmployee(employee);
		return "redirect:/employees";
	}

	@GetMapping("/employees/edit/{id}")
	private String editEmployee(@PathVariable int id, Model model) {

		model.addAttribute("employee", service.getEmployeeById(id));
		return "edit_employee";
	}

	@PostMapping("/employees/{id}")
	private String updateEmployee(@PathVariable int id, @ModelAttribute("employee") Employee employee, Model model) {
		service.updateEmployee(employee, id);
		return "redirect:/employees";
	}

	@GetMapping("/employees/{id}")
	private String deleteEmployee(@PathVariable int id) {
		service.deleteEmployeeById(id);
		return "redirect:/employees";
	}
}
