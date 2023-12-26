package com.dsr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsr.model.Employee;
import com.dsr.model.Project;
import com.dsr.repo.EmployeeRepo;
import com.dsr.repo.ProjectRepo;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
	ProjectRepo projectRepo;

	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}
	
	public void addEmployee(Employee employee) {
		employeeRepo.save(employee);
	}
	
	public void deleteEmployee(Integer id) {
		employeeRepo.deleteById(id);
	}
	
	public void updateEmployee(Employee employee) {
		employeeRepo.save(employee);
	}
	
	/**
	 * remove project from employee
	 * */
	public void removeProjectfromEmployee(Integer employeeId, Integer projectId) {
		Employee employee = employeeRepo.findById(employeeId).get();
		
		Project project = projectRepo.findById(projectId).get();
		employee.getProjectList().remove(project);
		employeeRepo.save(employee);
		
	}
}
