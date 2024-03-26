package com.project.rating.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user_ratings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rating_id")
    private Long ratingId;

    @Column(name="user_id")
    private Long userId;

    @Column(name="hotel_id")
    private Long hotelId;

    @Column(name="rating")
    private int rating;

    @Column(name="feedback")
    private String feedback;
}
