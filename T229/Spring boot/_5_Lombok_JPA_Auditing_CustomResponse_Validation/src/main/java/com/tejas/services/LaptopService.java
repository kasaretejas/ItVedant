package com.tejas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejas.custom_response.CustomResponse;
import com.tejas.entities.Laptop;
import com.tejas.repositories.LaptopRepository;

@Service
public class LaptopService {
	
	@Autowired
	LaptopRepository laptopRepository;
	
	@Autowired
	CustomResponse customResponse;
	
	public CustomResponse getAllLaptops()
	{
		List<Laptop> laptops=laptopRepository.findAll();
		customResponse.setMessage("Following laptops found");
		customResponse.setData(laptops);
		return customResponse;
	}
	
	public CustomResponse addLaptop(Laptop laptop)
	{
		Laptop savedLaptop=laptopRepository.save(laptop);
		customResponse.setMessage("Laptop added successfully!");
		customResponse.setData(savedLaptop);
		return customResponse;
	}
	
	public ResponseEntity<CustomResponse> deleteLaptop(long id)
	{
		Optional<Laptop> existingLaptop=laptopRepository.findById(id);
		if(existingLaptop.isPresent())
		{
			laptopRepository.deleteById(id);
			customResponse.setMessage("Laptop deleted successfully!");
			customResponse.setData(null);
			return new ResponseEntity<>(customResponse, HttpStatus.OK);
		}
		else
		{
			customResponse.setMessage("Laptop with id "+id+" is not exists!");
			customResponse.setData(null);
			return new ResponseEntity<>(customResponse, HttpStatus.NOT_FOUND);
		}
			
	}
	
	public ResponseEntity<CustomResponse> findByPriceLessThan(double price)
	{
		List<Laptop> laptops=laptopRepository.findByPriceLessThan(price);
		if(laptops.size()>0)
		{
			customResponse.setMessage("Following laptops found with price less than "+price);
			customResponse.setData(laptops);
			return new ResponseEntity<>(customResponse, HttpStatus.FOUND);
		}
		else
		{
			customResponse.setMessage("There are no laptops found with price less than "+price);
			customResponse.setData(null);
			return new ResponseEntity<>(customResponse, HttpStatus.NOT_FOUND);
		}
	}
	
	
	public ResponseEntity<CustomResponse> findByNameAndBrand(String name, String brand)
	{
		Optional<Laptop> optionalLaptop=laptopRepository.findByNameAndBrand(name, brand);
		if(optionalLaptop.isPresent())
		{
			Laptop existingLaptop=optionalLaptop.get();
			customResponse.setMessage("Following laptop found! ");
			customResponse.setData(existingLaptop);
			return new ResponseEntity<>(customResponse, HttpStatus.FOUND);
		}
		else
		{
			customResponse.setMessage("There is no laptop found ! ");
			customResponse.setData(null);
			return new ResponseEntity<>(customResponse, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<CustomResponse> findByPriceBetween(double fromPrice, double toPrice)
	{
		List<Laptop> laptops=laptopRepository.findByPriceBetween(fromPrice, toPrice);
		if(laptops.size()>0)
		{
			customResponse.setMessage("Following laptops found ! ");
			customResponse.setData(laptops);
			return new ResponseEntity<>(customResponse, HttpStatus.FOUND);
		}
		else
		{
			customResponse.setMessage("There are no laptops found! ");
			customResponse.setData(null);
			return new ResponseEntity<>(customResponse, HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
