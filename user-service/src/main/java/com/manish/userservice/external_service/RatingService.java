package com.manish.userservice.external_service;

import com.manish.userservice.model.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("/rating/user/{userId}")
    List<Rating> getRatingsByUserId(@PathVariable Long userId);


}