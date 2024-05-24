package com.manish.userservice.model;


import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Rating {
    private Long ratingId;
    private Long userId;
    private Long hotelId;
    private Integer rating;
    private String feedback;
    @Transient
    private Hotel hotel;
}