package com.dsr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsr.model.Employee;
import com.dsr.model.Project;
import com.dsr.repo.EmployeeRepo;
import com.dsr.repo.ProjectRepo;

@Service
public class ProjectService {
	@Autowired
	ProjectRepo projectRepo;
	
	@Autowired
	EmployeeRepo employeeRepo;

	public List<Project> getAllProjects() {
		return projectRepo.findAll();
	}
	/**
	 * first param : projectId
	 * second param : empId
	 * */
	public void addEmployeeToProject(Integer projectId, Integer empId) {
		Project project = projectRepo.findById(projectId).get();
		project.getEmployeeList().add(employeeRepo.findById(empId).get());
		projectRepo.save(project);
	}
	
	public void deleteProject(Integer projectId) {
		projectRepo.delete(projectRepo.findById(projectId).get());
	}
	
	public void addProject(Project project) {
		projectRepo.save(project);
	}
	
	public void updateProject(Project project) {
		projectRepo.save(project);
	}
	
}
