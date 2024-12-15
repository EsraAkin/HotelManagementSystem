package com.tpe.hotelManagementSystem.repository;

import com.tpe.hotelManagementSystem.config.HibernateUtils;
import com.tpe.hotelManagementSystem.exception.HotelNotFoundException;
import com.tpe.hotelManagementSystem.model.Hotel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class HotelRepository implements Repository<Hotel, Long> {


    @Override
    public Hotel save(Hotel object) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Transaction trs = session.beginTransaction();
            session.save(object);
            trs.commit();
            session.close();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            HibernateUtils.shutDown();
        }
    }

    @Override
    public Hotel findObjectById(Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        return session.get(Hotel.class, id);
    }

    @Override
    public void update(Hotel object) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction trs = session.beginTransaction();
        Hotel existingHotel = session.get(Hotel.class, object.getId()); //Güncelleyeceğim otelin id'sini çektim.
        if (existingHotel != null) {
            existingHotel.setName(object.getName());
            existingHotel.setLocation(object.getLocation());
            session.update(existingHotel);
        }
        trs.commit();
        session.close();
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction trs = session.beginTransaction();
        Hotel hotelToDelete = session.get(Hotel.class, id); //Sileceğim otelin id'sini çektim.
        if (hotelToDelete != null) {
            session.delete(hotelToDelete);
            trs.commit();

        } else {
            try {
                throw new HotelNotFoundException("Hotel not found " + id);
            } catch (HotelNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        session.close();

    }

    @Override
    public List<Hotel> findAll() {

        Session session = HibernateUtils.getSessionFactory().openSession();
        return session.createQuery("From Hotel", Hotel.class).getResultList();
    }

    //Room Repo ÖDEV!!!!!
    //todo Service + Controller ve eksik objeleri tamamlıcaz birde manytoone ve onetomany ilişkisine acıklıcam
}
