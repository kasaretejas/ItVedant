package com.tejas.entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Vendor 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String email;
	
	private String phone;
	
	private String companyName;
	
	private String address;
	
	@OneToMany(mappedBy = "vendor")
	private List<Product> products;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
}
