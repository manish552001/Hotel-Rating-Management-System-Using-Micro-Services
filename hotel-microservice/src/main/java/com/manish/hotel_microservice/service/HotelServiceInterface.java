package com.manish.hotel_microservice.service;

import com.manish.hotel_microservice.model.Hotel;

import java.util.List;

public interface HotelServiceInterface {
    Hotel saveHotel(Hotel hotel);
    List<Hotel> getAllHotel();
    Hotel getHotelById(Long id);
}
