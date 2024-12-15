package com.tpe.hotelManagementSystem.exception;

public class HotelNotFoundException extends RuntimeException {

    public HotelNotFoundException(String s){
        super(s);
    }
}
