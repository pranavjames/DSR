package com.dsr.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@NoArgsConstructor
public class CustomerTeam {
	
	@Id
	private Integer customerId;
	private String  customerName; 

}
