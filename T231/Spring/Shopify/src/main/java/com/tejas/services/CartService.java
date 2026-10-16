package com.tejas.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tejas.entities.Cart;
import com.tejas.entities.Customer;
import com.tejas.entities.Product;
import com.tejas.repositories.CartRepository;
import com.tejas.repositories.CustomerRepository;
import com.tejas.repositories.ProductRepository;
import com.tejas.response_wrapper.CustomResponse;
import com.tejas.response_wrapper.Response;

@Service
public class CartService 
{
	@Autowired
	CartRepository cartRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	Response response;
	
	public ResponseEntity<CustomResponse> addToCart(long customerId, long productId)
	{
		if(cartRepository.existsByCustomerIdAndProductId(customerId, productId))
		{
			return response.send("This product already in the cart", null, HttpStatus.FOUND);
		}
		else
		{
			Optional<Customer> existingCustomer=customerRepository.findById(customerId);
			Optional<Product> existingProduct=productRepository.findById(productId);
			if(existingCustomer.isPresent() && existingProduct.isPresent())
			{
				Cart cart = new Cart();
				cart.setQunatity(1);
				cart.setCustomer(existingCustomer.get());
				cart.setProduct(existingProduct.get());
				Cart savedCart=cartRepository.save(cart);
				return response.send("Product added to the cart", null, HttpStatus.OK);
			}
			else
			{
				return response.send("Add to cart failed!", null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	
	public ResponseEntity<CustomResponse> getCartItems(long customerId)
	{
		List<Cart> cartItems=cartRepository.findByCustomerId(customerId);
		//cartItems ----> cartItem -----> {id, product_id, customer_id, quantity} ---> here we get only product id, not product
		return response.send("Following cart items found", cartItems, HttpStatus.OK);
	}
	
	public ResponseEntity<CustomResponse> deleteCartItem(long cartId)
	{
		try
		{
			cartRepository.deleteById(cartId);
			return response.send("Product Deleted!", null, HttpStatus.OK);
		}
		catch(Exception exception)
		{
			return response.send("Product Deletion failed!", null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<CustomResponse> changeQuantity(long cartId, int quantity)
	{
		Cart existingCart=cartRepository.findById(cartId).get();
		existingCart.setQunatity(quantity);
		cartRepository.save(existingCart);
		return response.send("Quantity Updated", null, HttpStatus.OK);
		
	}
}

















