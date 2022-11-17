package com.hibernate.MavenHibernate;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{											// for image reader
    public static void main( String[] args ) throws IOException
    {
        System.out.println( " Session Started" );
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        //System.out.println(factory);
        
        //Make objects for student
		/*
		 * student st = new student(); st.setName("Mujassam"); st.setCity("Patna");
		 * 
		 * System.out.println(st);
		 */
        Address add = new Address();
        add.setStreet("Bari Path");
        add.setCity("Patna");
        add.setOpen(true);
        add.setX(11.22);
        add.setAddedDate(new Date());
        
        //reading image data
        FileInputStream fis = new FileInputStream("src/main/java/Mujassam.jpg");
        //create byte array and size is this
        byte bt[] = new byte[fis.available()];
        //read the file
        fis.read(bt);
        //finally set to the Address class
        add.setImage(bt);
        
        
        System.out.println(add);
        
        //to start session we start the session
        Session session = factory.openSession();
        //Session session = factory.getCurrentSession();
        
        Transaction tx = session.beginTransaction();
        
        //it will save the data inside the database
        session.save(add);
        tx.commit();
        session.close();
    }
}
