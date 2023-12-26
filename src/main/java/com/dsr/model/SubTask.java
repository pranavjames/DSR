package com.dsr.model;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class SubTask {

	@Id
    private Integer taskId;
	private String taskName;
	
	@ManyToOne
	private Task task;
	
}
