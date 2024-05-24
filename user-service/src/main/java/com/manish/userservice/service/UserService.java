package com.manish.userservice.service;

import com.manish.userservice.external_service.HotelService;
import com.manish.userservice.external_service.RatingService;
import com.manish.userservice.model.Hotel;
import com.manish.userservice.model.Rating;
import com.manish.userservice.model.UserEntity;
import com.manish.userservice.repository.UserRepo;
import com.manish.userservice.service.exceptions.userNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    private RatingService ratingServiceClient;

    @Autowired
    private HotelService hotelServiceClient;

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserEntity saveUser(UserEntity user) {
        return userRepo.save(user);
    }

    public List<UserEntity> getAllUser() {
        List<UserEntity> userEntityList = userRepo.findAll();
        for (UserEntity user : userEntityList) {
            List<Rating> ratings = ratingServiceClient.getRatingsByUserId(user.getUserId());
            for (Rating rating : ratings) {
                Hotel hotel = hotelServiceClient.getHotelById(rating.getHotelId());
                rating.setHotel(hotel);
            }
            user.setRatingList(ratings);
        }
        return userEntityList;
    }

    public UserEntity findUserById(Long id) {
        UserEntity user = userRepo.findById(id).orElseThrow(() -> new userNotFoundException("User not found "));

        List<Rating> ratings = ratingServiceClient.getRatingsByUserId(user.getUserId());
        for (Rating rating : ratings) {
            Hotel hotel = hotelServiceClient.getHotelById(rating.getHotelId());
            rating.setHotel(hotel);
        }

        user.setRatingList(ratings);
        return user;
    }
}
