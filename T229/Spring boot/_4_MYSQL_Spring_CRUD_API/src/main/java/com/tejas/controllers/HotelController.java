package com.tejas.controllers;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.entities.Hotel;
import com.tejas.services.HotelService;

@RestController
@RequestMapping("/api/v1")
public class HotelController {
	@Autowired
	HotelService hotelService;
	
	@GetMapping("/hotels")
	public Iterator<Hotel> getAllHotels()
	{
		return hotelService.getAllHotels();
	}
	
	@PostMapping("/hotels")
	public Hotel addHotel(@RequestBody Hotel hotel)
	{
		return hotelService.addHotel(hotel);
	}
	
	@GetMapping("/hotels/{id}")
	public Hotel getHotelById(@PathVariable("id") long id)
	{
		return hotelService.getHotelById(id);
	}
	
	@DeleteMapping("hotels/{id}")
	public String deleteHotelById(@PathVariable("id") long id)
	{
		return hotelService.deleteHotelById(id);
	}

	@PatchMapping("/hotels/{id}")
	public String updateHotelById(@PathVariable("id") long id, @RequestBody Hotel newHotelData)
	{
		return hotelService.updateHotelById(id, newHotelData);
	}
}
