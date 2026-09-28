package com.tejas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tejas.entities.Hotel;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long>{

}
