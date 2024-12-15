package com.tpe.hotelManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//6.adım
@Entity
@Table(name = "tbl_rooms")
public class Room {

    @Id
    private Long id;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private Integer capacity;

    private Hotel hotel;


    public Room(Long id, String number, Integer capacity, Hotel hotel) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
        this.hotel = hotel;
    }

    public Room() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", capacity=" + capacity +
                ", hotel=" + hotel +
                '}';
    }
}