package com.project.user.service.services;

import com.project.user.service.entity.Hotel;
import com.project.user.service.entity.Rating;
import com.project.user.service.entity.User;
import com.project.user.service.exceptions.ResourceNotFoundException;
import com.project.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long userId) {
        //get user from database with repo
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with ID "+ userId +" not found!"));

        //fetch rating from RATING SERVICE
        Rating[] ratingOfUser =restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);

        List<Rating> ratings = Arrays.stream(ratingOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call to HOTEL SERVICE to get hotel
            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = forEntity.getBody();

            rating.setHotel(hotel);

            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user;
    }

    @Override
    public User updateUser(Long userId, User user) {
        User userbyId =getUser(userId);
        userbyId.setName(user.getName());
        userbyId.setEmail(user.getEmail());
        userbyId.setAbout(user.getAbout());
        User updatedUser =userRepository.save(userbyId);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
