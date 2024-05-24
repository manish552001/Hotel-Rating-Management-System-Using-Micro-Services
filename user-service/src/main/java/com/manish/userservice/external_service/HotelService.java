package com.manish.userservice.external_service;

import com.manish.userservice.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("hotel/{hotelId}")
    Hotel getHotelById(@PathVariable Long hotelId);
}