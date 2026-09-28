package com.tejas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejas.entities.Customer;
import com.tejas.entities.User;
import com.tejas.entities.Vendor;
import com.tejas.repositories.CustomerRepository;
import com.tejas.repositories.UserRepository;
import com.tejas.repositories.VendorRepository;
import com.tejas.responsewrapper.CustomResponse;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	VendorRepository vendorRepository;
	
	@Autowired
	CustomResponse response;
	
	public ResponseEntity<CustomResponse> register(User user)
	{
		String role = user.getRole().name();
		User registeredUser=userRepository.save(user);
		if(role.equals("CUSTOMER"))
		{
			Customer customer = new Customer();
			customer.setUser(registeredUser);
			customerRepository.save(customer);
		}
		else
		{
			Vendor vendor = new Vendor();
			vendor.setUser(registeredUser);
			vendorRepository.save(vendor);
		}
		
		response.setMessage("Registration success");
		response.setData(registeredUser.getUsername());
		
		return new ResponseEntity(response, HttpStatus.OK);
			
	}

}
