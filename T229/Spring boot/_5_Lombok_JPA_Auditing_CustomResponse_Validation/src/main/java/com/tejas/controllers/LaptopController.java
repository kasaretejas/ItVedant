package com.tejas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.custom_response.CustomResponse;
import com.tejas.entities.Laptop;
import com.tejas.services.LaptopService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class LaptopController {
	
	@Autowired
	LaptopService laptopService;
	
	@GetMapping("/laptops")
	public CustomResponse getAllLaptops()
	{
		return laptopService.getAllLaptops();
	}
	
	@PostMapping("/laptops")
	public CustomResponse addLaptop(@RequestBody @Valid Laptop laptop)
	{
		return laptopService.addLaptop(laptop);
	}
	
	
	@DeleteMapping("/laptops/{id}")
	public ResponseEntity<CustomResponse> deleteLaptop(@PathVariable("id") long id)
	{
		return laptopService.deleteLaptop(id);
	}

	@GetMapping("/laptops/price-less-than/{price}")
	public ResponseEntity<CustomResponse> findByPriceLessThan(@PathVariable("price") double price)
	{
		return laptopService.findByPriceLessThan(price);
	}
	
	
	@GetMapping("/laptops/name-and-brand")
	public ResponseEntity<CustomResponse> findByNameAndBrand(
			@RequestParam("name") String name, 
			@RequestParam("brand") String brand)
	{
		return laptopService.findByNameAndBrand( name, brand);
	}
	
	
	@GetMapping("/laptops/price-between")
	public ResponseEntity<CustomResponse> findByPriceBetween(
			@RequestParam("fromPrice") double fromPrice, 
			@RequestParam("toPrice") double toPrice)
	{
		return laptopService.findByPriceBetween(fromPrice,toPrice);
	}
	
	
	
	
	
	
	
	
	
}

