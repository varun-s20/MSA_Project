package com.project.user.service;

import com.project.user.service.entity.Hotel;
import com.project.user.service.entity.Rating;
import com.project.user.service.entity.User;
import com.project.user.service.repository.UserRepository;
import com.project.user.service.services.UserService;
import com.project.user.service.services.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RestTemplate restTemplate;

    @Test
    void getUser(){

        User dummyUser = User.builder()
                .userId(1L)
                .name("Test")
                .email("test@mail.com")
                .about("Dummy User").build();
        Mockito.when(userRepository.findById(Mockito.any())).thenReturn(Optional.of(dummyUser));

        Rating dummyRating = Rating.builder()
                .ratingId(1L)
                .hotelId(1L)
                .rating(1)
                .feedback("Demo, was good")
                .userId(1L)
                .build();
        Rating[] ratingArray = new Rating[1];
        ratingArray[0] = dummyRating;
        String url = "http://RATINGSERVICE/ratings/users/1"; // Replace with your actual URL
        Mockito.when(restTemplate.getForObject(url, Rating[].class)).thenReturn(ratingArray);


        Hotel dummyHotel = Hotel.builder()
                .hotelId(1L)
                .about("Dummy Hotel")
                .location("Test Loc")
                .name("TestHotel")
                .build();
        String url1 = "http://HOTELSERVICE/hotels/1"; // Replace with your actual URL
        Mockito.when(restTemplate.getForEntity(url1, Hotel.class)).thenReturn(ResponseEntity.ok(dummyHotel));

        User returnUser = userService.getUser(1L);
        Assertions.assertEquals(dummyUser.getName(), returnUser.getName());
        Assertions.assertEquals(dummyUser.getUserId(), returnUser.getUserId());

    }

    @BeforeEach
    void init(){
        userService = new UserServiceImpl();
        MockitoAnnotations.openMocks(this);
    }
}
