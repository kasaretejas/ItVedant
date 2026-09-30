package com.tejas.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.razorpay.Order;
import com.razorpay.RazorpayException;
import com.tejas.dtos.VerifyPaymentRequest;
import com.tejas.services.PaymentService;

@RestController
@RequestMapping("/api/v1")
public class PaymentController {
	 @Autowired
	 private PaymentService paymentService;


	 @PostMapping("/customer/create-order")
	 public ResponseEntity<String> createOrder(
	            @RequestParam("amount") int amount,
	            @RequestParam("currency") String currency,
	            @RequestParam("customerId") long customerId)
	            throws RazorpayException {
		 JSONObject order = paymentService.createOrder(amount, currency, customerId);
	        return ResponseEntity.ok(order.toString());
	    }
	
	 @PostMapping("/customer/verify-payment")
	 public ResponseEntity<?> verifyPayment(
	         @RequestBody VerifyPaymentRequest request)
	         throws RazorpayException {
	     return paymentService.verifyPayment(request);
	 }
}
