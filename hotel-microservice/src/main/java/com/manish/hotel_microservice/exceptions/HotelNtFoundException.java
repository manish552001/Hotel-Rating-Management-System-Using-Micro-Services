package com.manish.hotel_microservice.exceptions;

public class HotelNtFoundException extends RuntimeException {

    public HotelNtFoundException( ) {
        super("Hotel not found ..");
    }
    public HotelNtFoundException(String message) {
        super(message);
    }
}
