package com.tejas.entities;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "orders")   // 'order' is a reserved SQL keyword
@Data
public class Order {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ManyToOne
   @JoinColumn(name = "customer_id")
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
   private Customer customer;
   private double totalAmount;
   private String paymentId;         // Razorpay Payment ID
   private String razorpayOrderId;   // Razorpay Order ID
   private String paymentStatus;     // PAID, FAILED, PENDING
   private LocalDateTime orderDate;
}
