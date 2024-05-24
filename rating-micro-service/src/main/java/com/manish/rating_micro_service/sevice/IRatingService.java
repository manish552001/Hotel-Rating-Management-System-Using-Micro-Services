package com.manish.rating_micro_service.sevice;


import com.manish.rating_micro_service.model.Rating;

import java.util.List;

public interface IRatingService {
    Rating saveRating(Rating rating);

    List<Rating> gatAllRatings();
    List<Rating> getRatingByUserId(Long userId);
    List<Rating> getRatingByHotelId(Long hotelId);
}