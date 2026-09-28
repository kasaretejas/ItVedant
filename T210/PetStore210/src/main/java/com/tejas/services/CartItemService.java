package com.tejas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejas.models.CartItem;
import com.tejas.models.Pet;
import com.tejas.models.User;
import com.tejas.repositories.CartItemRepository;
import com.tejas.repositories.PetRepository;
import com.tejas.repositories.UserRepository;
import com.tejas.responsewrapper.MyResponseWrapper;

@Service
public class CartItemService 
{
	@Autowired
	CartItemRepository cartItemRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PetRepository petRepository;
	
	@Autowired
	MyResponseWrapper responseWrapper;
	
	private ResponseEntity<?> universalResponse(String message, Object data, HttpStatus httpStatus)
	{
		responseWrapper.setMessage(message);
		responseWrapper.setData(data);
		return new ResponseEntity<> (responseWrapper,httpStatus);
	}
	
	public ResponseEntity<?> addToCart(long userId, long petId)
	{
		Optional<User> user=userRepository.findById(userId);
		Optional<Pet> pet=petRepository.findById(petId);
		if(user.isPresent() && pet.isPresent())
		{
			Optional<CartItem> cartItem=cartItemRepository.findByUserAndPet(user.get(), pet.get());
			if(cartItem.isPresent())
			{
				//already exists
				return universalResponse("Pet Already in cart", null, HttpStatus.FOUND);
			}
			else
			{
				//add to cart
				CartItem item = new CartItem();
				item.setUser(user.get());
				item.setPet(pet.get());
				item.setQuantity(1);
				CartItem savedCartItem=cartItemRepository.save(item);
				return universalResponse("Pet added in cart", savedCartItem, HttpStatus.CREATED);

			}
		}
		else
		{
			return universalResponse("Something went wrong", null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	public ResponseEntity<?> getAllCartItemsForPerticularUser(long userId)
	{
		Optional<User> user=userRepository.findById(userId);
		if(user.isPresent())
		{
			List<CartItem> cartItems=cartItemRepository.findByUser(user.get());
			
			return universalResponse("Following cart items found", cartItems, HttpStatus.OK);
			
		}
		else
		{
			return universalResponse("User not exists", null, HttpStatus.NOT_FOUND);

		}
	}
	
	
	
	
	
	
}
