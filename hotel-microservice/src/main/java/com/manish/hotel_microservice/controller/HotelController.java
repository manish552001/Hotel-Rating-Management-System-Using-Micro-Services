package com.manish.hotel_microservice.controller;

import com.manish.hotel_microservice.model.Hotel;
import com.manish.hotel_microservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;
    @PostMapping
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.saveHotel(hotel));
    }
    @GetMapping
    public ResponseEntity<List<Hotel>> getAll(){
        return ResponseEntity.ok(hotelService.getAllHotel());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getById(@PathVariable Long id){
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }
}
