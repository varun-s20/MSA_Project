package com.project.user.service.entity;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hotel {

    private Long hotelId;
    private String name;
    private String location;
    private String about;
}
