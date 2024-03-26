package com.project.user.service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="micro_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="email", unique=true, nullable = false)
    private String email;

    @Column(name="about")
    private String about;

    @Transient //not store in database
    private List<Rating> ratings = new ArrayList<>();
}
