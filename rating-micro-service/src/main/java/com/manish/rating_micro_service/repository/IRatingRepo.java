package com.manish.rating_micro_service.repository;

import com.manish.rating_micro_service.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRatingRepo extends JpaRepository<Rating,Long> {
    List<Rating> findByUserId(Long userId);

    List<Rating> findByHotelId(Long hotelId);
}