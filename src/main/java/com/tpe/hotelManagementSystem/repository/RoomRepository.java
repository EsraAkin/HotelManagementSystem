package com.tpe.hotelManagementSystem.repository;

import com.tpe.hotelManagementSystem.config.HibernateUtils;
import com.tpe.hotelManagementSystem.exception.RoomNotFoundException;
import com.tpe.hotelManagementSystem.model.Hotel;
import com.tpe.hotelManagementSystem.model.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoomRepository implements Repository<Room, Long> {
    @Override
    public Room save(Room object) {
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
    public Room findObjectById(Long id) {
       try (Session session = HibernateUtils.getSessionFactory().openSession()) {
           return session.get(Room.class, id);
       }
    }

    @Override
    public void update(Room object) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction trs = session.beginTransaction();
        Room existingRoom = session.get(Room.class, object.getId());
        if (existingRoom != null) {
            existingRoom.setId(object.getId());
            existingRoom.setCapacity(object.getCapacity());
            existingRoom.setNumber(object.getNumber());
        }
        trs.commit();
        session.close();
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction trs=session.beginTransaction();
        Room roomToDelete=session.get(Room.class, id);
        if(roomToDelete!=null){
            session.delete(roomToDelete);
            trs.commit();
        }else {
            try {
                throw new RoomNotFoundException("Room not found." +id);
            } catch (RoomNotFoundException e) {
                System.out.println("Oda bulunamadı!");
            }
        }
        session.close();
    }



    @Override
    public List<Room> findAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("From Room", Room.class).getResultList();
        }
    }
}
