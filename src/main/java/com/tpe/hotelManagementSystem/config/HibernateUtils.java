package com.tpe.hotelManagementSystem.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    //1. adım sessionFactory'i etkinleştirmem lazım
    private static SessionFactory sessionFactory;//okunabilir bir değer

    static {  //static Blok ile SessionFactory Başlatılıyor
        try {
            Configuration config = new Configuration().configure(); //Hibernate yapılandırma dosyasını (hibernate.cfg.xml) okur.
            //Bu dosyada veritabanı bağlantısı, kullanıcı adı, şifre gibi bilgiler yer alır.
            sessionFactory = config.buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Session factory build edilirken bir sorunla karşılaşıldı : " + e.getMessage());
        }
    }

    public static SessionFactory getSessionFactory() {//SessionFactory nesnesini uygulama genelinde kullanılabilir hale getirir
        return sessionFactory;
    }

    public static void shutDown() {   //Hibernate'in veritabanı bağlantı havuzunu kapatır. Kaynak sızıntılarını önlemek için kullanılır.
        getSessionFactory().close();
    }

}