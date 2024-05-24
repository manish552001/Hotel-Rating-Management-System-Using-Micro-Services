package com.manish.hotel_microservice.repository;

import com.manish.hotel_microservice.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHotelRepo extends JpaRepository<Hotel,Long> {
}
