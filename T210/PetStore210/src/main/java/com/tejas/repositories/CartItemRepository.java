package com.tejas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejas.models.CartItem;
import com.tejas.models.Pet;
import com.tejas.models.User;
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>
{
    List<CartItem> findByUser(User user);
    Optional<CartItem> findByUserAndPet(User user, Pet pet);
    
}
