package com.tejas.services;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tejas.entities.Hotel;
import com.tejas.mappers.HotelMapper;
import com.tejas.repositories.HotelRepository;

import tools.jackson.databind.ObjectMapper;

@Service
public class HotelService 
{
	@Autowired
	HotelRepository hotelRepository;
	
	
	public Iterator<Hotel> getAllHotels()
	{
		Iterator<Hotel> hotels=hotelRepository.findAll().iterator(); //findAll() = select * from hotel;
		return hotels;
	}
	
	public Hotel addHotel(Hotel hotel)
	{
		Hotel savedHotel=hotelRepository.save(hotel); //insert into hotel .......
		return savedHotel;
	}
	
	public Hotel getHotelById(long id)
	{
		Optional<Hotel> existingHotel=hotelRepository.findById(id); //select * from hotel where id=.....
		if(existingHotel.isPresent())
		{
			return existingHotel.get(); //since hotel is present, get() is used to retrive its data
		}
		else
		{
			return null;
		}
	}
	
	public String deleteHotelById(long id)
	{
		Optional<Hotel> existingHotel=hotelRepository.findById(id); //select * from hotel where id=.....
		if(existingHotel.isPresent())
		{
			hotelRepository.deleteById(id); //delete from hotel where id= .........
			return "Hotel deleted!";
		}
		else
		{
			return "There is no hotel with id "+id;
		}
	}
	
	
	@Autowired
	private HotelMapper hotelMapper;
	public String updateHotelById(long id, Hotel newHotelData)
	{
		Optional<Hotel> optionalHotel=hotelRepository.findById(id); //select * from hotel where id=.....
		if(optionalHotel.isPresent())
		{

			Hotel existingHotel=optionalHotel.get();
			//code for update hotel data using ObjectMapper
			newHotelData.setId(id);
			 hotelMapper.updateHotel(newHotelData, existingHotel);
			 hotelRepository.save(existingHotel);
			return "Hotel Updated!";
		}
		else
		{
			return "There is no hotel with id "+id;
		}
	}
	
	
	
}








