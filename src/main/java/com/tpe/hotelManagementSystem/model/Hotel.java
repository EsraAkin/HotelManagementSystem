package com.tpe.hotelManagementSystem.model;

//2. Adım Hotel isimli bir class oluşturalım.


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tbl_hotels")
public class Hotel {

    //3.adım primarykey yani id oluşturalım.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//id degerinin otomatik olarak artmasını saglar
    private  Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @OneToMany //burayı tekrar edeceğiz!!!
    private List<Room> rooms=new ArrayList();

    //5. adım Değer atamasını kolaylaştırmak için paramlı cons. fetch için de paramsız cons.

    public Hotel() {
    }

    public Hotel(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }


    //4. adım getter-setter


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
