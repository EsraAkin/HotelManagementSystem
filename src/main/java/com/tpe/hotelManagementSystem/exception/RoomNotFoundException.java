package com.tpe.hotelManagementSystem.exception;

public class RoomNotFoundException extends RuntimeException{
    public RoomNotFoundException(String s){
        super(s);
    }
}
