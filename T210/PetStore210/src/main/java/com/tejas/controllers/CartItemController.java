package com.tejas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.services.CartItemService;

@RestController
@RequestMapping("/api/v1")
public class CartItemController 
{
	@Autowired
	CartItemService cartItemService;
	
	@PostMapping("/customer/add-to-cart/{userId}/{petId}")
	public ResponseEntity<?> addToCart(@PathVariable("userId") long userId, 
			@PathVariable("petId") long petId)
	{
		return cartItemService.addToCart(userId, petId);
	}
	
	@GetMapping("/customer/{userId}")
	public ResponseEntity<?> getAllCartItemsForPerticularUser(@PathVariable("userId") long userId)
	{
		return cartItemService.getAllCartItemsForPerticularUser(userId);
	}
		
}
