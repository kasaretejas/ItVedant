package com.tejas.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.tejas.entities.Hotel;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    @BeanMapping(
    		nullValuePropertyMappingStrategy =
            NullValuePropertyMappingStrategy.IGNORE
    )
    void updateHotel(Hotel source, @MappingTarget Hotel target);

}





