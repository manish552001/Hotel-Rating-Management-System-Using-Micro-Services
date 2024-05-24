package com.manish.hotel_microservice.exceptions.exceptionHandler;

import com.manish.hotel_microservice.exceptions.HotelNtFoundException;
import com.manish.hotel_microservice.service.payload.apiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HotelNtFoundException.class)
    public ResponseEntity<apiResponse> hotelNotFound(HotelNtFoundException ex){
        String mess =ex.getMessage();
        apiResponse ap =apiResponse.builder().status(true).message(mess).httpStatus(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ap);
    }
}
