package com.project.hotel.services;

import com.project.hotel.entity.Hotel;

import java.util.List;

public interface HotelService {

    //create operation
    Hotel create(Hotel hotel);

    //read operation - all
    List<Hotel> getAll();

    //read operation - using id
    Hotel getHotel(Long hotelId);

    //update operation
    Hotel updateHotel(Long hotelId, Hotel hotel);

    //delete operation
    void deleteHotel(Long hotelId);
}
