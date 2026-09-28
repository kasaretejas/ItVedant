package com.tejas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.tejas.services.CartService;

@RestController
@RequestMapping("/api/v1")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/customer/{customerId}/cart/{productId}")
	public ResponseEntity<?> addToCart(
			@PathVariable("customerId") long customerId, 
			@PathVariable("productId") long productId)
	{
		return cartService.addToCart(customerId, productId);
	}
	
	
	@GetMapping("/customer/{customerId}/cart")
	public ResponseEntity<?> getCartItems(@PathVariable("customerId") long customerId)
	{
		return cartService.getCartItems(customerId);
	}
	
	@DeleteMapping("/customer/cart/{cartId}")
	public ResponseEntity<?> removeCartItem(@PathVariable("cartId") long cartId)
	{
		return cartService.removeCartItem(cartId);
	}
	
	@PutMapping("/customer/cart/{cartId}")
	public ResponseEntity<?> updateCartQuantity(@PathVariable("cartId")long cartId, @RequestParam("quantity") int quantity)
	{
		return cartService.updateCartQuantity(cartId, quantity);
	}

}
