package com.tpe.hotelManagementSystem.repository;

import java.util.List;

//crud işlemleri için depo
public interface Repository <S,U>{

    //cread işlemi
    S save(S object);

    //read işlemi
    S findObjectById(U id);

    //update
    void update(S object);

    //delete
    void deleteById(U id);


    //tüm değerleri listeyelen method
    List<S> findAll();
}
