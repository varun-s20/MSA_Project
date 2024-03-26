package com.project.rating.services;

import com.project.rating.entity.Rating;

import java.util.List;

public interface RatingService {

    //create operation
    Rating create(Rating rating);

    //read operation - using id
    List<Rating> getRatings();

    //get by rating Id
    Rating getRatingsbyId(Long ratingId);

    //get all by User id
    List<Rating> getRatingbyUserId(Long userId);

    //get all by hotel id
    List<Rating> getRatingbyHotelId(Long hotelId);

    //update operation
    Rating updateRating(Long ratingId, Rating rating);

    //delete operation
    void deleteHotel(Long ratingId);
}
