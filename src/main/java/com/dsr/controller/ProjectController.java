
package com.dsr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dsr.model.Employee;
import com.dsr.model.Project;
import com.dsr.service.EmployeeService;
import com.dsr.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ProjectService projectService;
	
	
	@GetMapping("/getall")
	public ResponseEntity<List<Project>> getAllProjects(){
		return new ResponseEntity<>(projectService.getAllProjects(),HttpStatus.OK);
	}
		

	@GetMapping("/set/{projectid}/{empid}")
	public ResponseEntity<String> addEmployeeToProject(@PathVariable Integer projectId,@PathVariable Integer empId ){
		
		projectService.addEmployeeToProject(projectId,empId);
		return new ResponseEntity<>("added",HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addProject(@RequestBody Project project){
		projectService.addProject(project);
		
		return ResponseEntity.ok("added");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProject(@PathVariable Integer id){
		System.out.println("Id : "+id);
		projectService.deleteProject(id);
		return ResponseEntity.ok("deleted");
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateProject(@RequestBody Project project){
		
		projectService.updateProject(project);
		return ResponseEntity.ok("updated");
	}

}
