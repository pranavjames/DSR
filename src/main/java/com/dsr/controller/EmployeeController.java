
package com.dsr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dsr.model.Employee;
import com.dsr.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
		employeeService.addEmployee(employee);
		return ResponseEntity.ok("added employee successfully");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok("deleted employee");
	}
	
	@DeleteMapping("/delete/{employeeId}/{projectId}")
	public ResponseEntity<String> removeProjectFromEmployee(@PathVariable Integer employeeId, 
			@PathVariable Integer projectId){
		employeeService.removeProjectfromEmployee(employeeId, projectId);
		return ResponseEntity.ok("removed project");
	}
	
	@PatchMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
		employeeService.updateEmployee(employee);
		return ResponseEntity.ok("updated employee");
	}
	
	
}
