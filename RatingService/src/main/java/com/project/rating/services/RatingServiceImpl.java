package com.project.rating.services;

import com.project.rating.entity.Rating;
import com.project.rating.exceptions.ResourceNotFoundException;
import com.project.rating.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }


    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRatingsbyId(Long ratingId) {
        return ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("User with ID "+ ratingId +" not found!"));
    }

    @Override
    public List<Rating> getRatingbyUserId(Long userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingbyHotelId(Long hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public Rating updateRating(Long ratingId, Rating rating) {
        Rating ratingbyId =getRatingsbyId(ratingId);
        ratingbyId.setRating(rating.getRating());
        ratingbyId.setFeedback(rating.getFeedback());
        Rating updatedRating =ratingRepository.save(ratingbyId);
        return updatedRating;
    }

    @Override
    public void deleteHotel(Long ratingId) {
        ratingRepository.deleteById(ratingId);
    }
}
