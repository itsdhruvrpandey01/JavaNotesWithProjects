package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
//        Create
        Student st = new Student();
        st.setId(1);
        st.setName("Dhruv");
        st.setCity("Mumbai");
        System.out.println(st);
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st);
        tx.commit();
        session.close();
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
    }
}
