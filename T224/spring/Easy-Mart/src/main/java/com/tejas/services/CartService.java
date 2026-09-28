package com.tejas.services;

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
import com.tejas.response_wrapper.UnivarsalResponse;

@Service
public class CartService {
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UnivarsalResponse response;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public ResponseEntity<?> addToCart(long customerId, long productId)
	{
		if(cartRepository.existsByCustomerIdAndProductId(customerId, productId))
		{
			return response.send("This product already in the cart", null, HttpStatus.FOUND);
		}
		else
		{
			Customer existingCustomer=customerRepository.findById(customerId).get();
			Product existingProduct=productRepository.findById(productId).get();
			Cart cart = new Cart();
			cart.setCustomer(existingCustomer);
			cart.setProduct(existingProduct);
			cart.setQuantity(1);
			Cart savedCart=cartRepository.save(cart);
			return response.send("Prouct added to the cart", savedCart, HttpStatus.OK);
		}
	}
	
	
	
	public ResponseEntity<?> getCartItems(long customerId)
	{
		Optional<Customer> existingCustomer=customerRepository.findById(customerId);
		if(existingCustomer.isPresent())
		{
			List<Cart> cartItems=cartRepository.findByCustomerId(customerId);
			return response.send("Follwoing cart items found", cartItems, HttpStatus.OK);
		}
		else
		{
			return response.send("Customer not exists", null, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<?> removeCartItem(long cartId)
	{
		Optional<Cart> existingCart=cartRepository.findById(cartId);
		if(existingCart.isPresent())
		{
			cartRepository.deleteById(cartId);
			return response.send("Cart item deleted", null, HttpStatus.OK);
		}
		else
		{
			return response.send("Cart itemcan not be removed", null, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<?> updateCartQuantity(long cartId, int quantity)
	{
		Optional<Cart> existingCart=cartRepository.findById(cartId);
		if(existingCart.isPresent())
		{
			Cart cart = existingCart.get();
			cart.setQuantity(quantity);
			cartRepository.save(cart);

			return response.send("Quantity Updated", cart, HttpStatus.OK);
		}
		else
		{
			return response.send("Cant update quantity", null, HttpStatus.NOT_FOUND);
		}

	}

}









