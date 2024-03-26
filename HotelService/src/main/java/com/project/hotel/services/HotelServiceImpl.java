package com.project.hotel.services;

import com.project.hotel.entity.Hotel;
import com.project.hotel.exceptions.ResourceNotFoundException;
import com.project.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(Long hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel with ID "+ hotelId +" not found!"));
    }

    @Override
    public Hotel updateHotel(Long hotelId, Hotel hotel) {
        Hotel hotelbyId =getHotel(hotelId);
        hotelbyId.setName(hotel.getName());
        hotelbyId.setLocation(hotel.getLocation());
        hotelbyId.setAbout(hotel.getAbout());
        Hotel updatedHotel =hotelRepository.save(hotelbyId);
        return updatedHotel;
    }

    @Override
    public void deleteHotel(Long hotelId) {
        hotelRepository.deleteById(hotelId);
    }
}
