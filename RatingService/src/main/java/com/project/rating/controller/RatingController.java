package com.project.rating.controller;

import com.project.rating.entity.Rating;
import com.project.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    //create operation
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    //read operation - get all users
    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){
        return ResponseEntity.ok(ratingService.getRatings());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsbyUserId(@PathVariable Long userId){
        return ResponseEntity.ok(ratingService.getRatingbyUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsbyHotelId(@PathVariable Long hotelId){
        return ResponseEntity.ok(ratingService.getRatingbyHotelId(hotelId));
    }

    //update operation
    @PutMapping("/{ratingId}")
    private ResponseEntity updateById(@PathVariable Long ratingId, @RequestBody Rating rating){
        Rating updateRating = ratingService.updateRating(ratingId, rating);
        return new ResponseEntity(updateRating, HttpStatus.OK);
    }

    //delete operation
    @DeleteMapping("/{ratingId}")
    public ResponseEntity deletebyId(@PathVariable("ratingId") Long ratingId){
        try{
            ratingService.deleteHotel(ratingId);
        } catch (Exception exception)
        {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("Rating deleted with id: "+ratingId, HttpStatus.OK);
    }
}
