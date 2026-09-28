package com.tejas.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String accountNumber;
	private String bankName;
	
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;
}
