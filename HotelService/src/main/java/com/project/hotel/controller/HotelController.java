package com.project.hotel.controller;

import com.project.hotel.entity.Hotel;
import com.project.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    //create operation
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    //read operation - get single user
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getSingleUser(@PathVariable Long hotelId){
        Hotel hotel = hotelService.getHotel(hotelId);
        return ResponseEntity.ok(hotel);
    }

    //read operation - get all users
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllUser(){
        List<Hotel> allHotel = hotelService.getAll();
        return ResponseEntity.ok(allHotel);
    }

    //update operation
    @PutMapping("/{hotelId}")
    private ResponseEntity updateById(@PathVariable Long hotelId, @RequestBody Hotel hotel){
        Hotel updateHotel = hotelService.updateHotel(hotelId, hotel);
        return new ResponseEntity(updateHotel, HttpStatus.OK);
    }

    //delete operation
    @DeleteMapping("/{hotelId}")
    public ResponseEntity deletebyId(@PathVariable("hotelId") Long hotelId){
        try{
            hotelService.deleteHotel(hotelId);
        } catch (Exception exception)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("Hotel deleted with id: "+hotelId, HttpStatus.OK);
    }
}
