package com.tejas.entities;

import java.time.Instant;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private double price;
	private int quantity;
	private String description;
	private String brand;
	private String imageName;
	
	@ManyToOne
	@JoinColumn(name="subcategory_id")
	private SubCategory subCategory;
	
	@ManyToOne
	@JoinColumn(name="vendor_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Vendor vendor;
	
	@CreatedDate
	private Instant createdAt;
	@LastModifiedDate
	private Instant updatedAt;
	
}
