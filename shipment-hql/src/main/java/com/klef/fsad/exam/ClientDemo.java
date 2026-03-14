package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ClientDemo
{
public static void main(String[] args)
{

SessionFactory factory = new Configuration().configure().buildSessionFactory();
Session session = factory.openSession();

Transaction tx = session.beginTransaction();

Shipment s = new Shipment(1,"Laptop","2026-03-11","Delivered");

session.save(s);

tx.commit();

System.out.println("Record Inserted");

Transaction tx2 = session.beginTransaction();

Query q = session.createQuery("delete from Shipment where id=:id");

q.setParameter("id",1);

q.executeUpdate();

tx2.commit();

System.out.println("Record Deleted");

session.close();

}
}