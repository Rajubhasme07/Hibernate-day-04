package com.temp.Hibernate_day_4;

import java.util.List;
import java.util.Scanner;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.temp.Hibernate_day_4.model.Customer;

public class App 
{
    public static void main( String[] args )
    {
      Configuration cfg=new Configuration();
      cfg.configure("hibernate.cfg.xml");
      
      
      SessionFactory factory=cfg.buildSessionFactory();
      Session session=factory.openSession();
      
      Scanner sc=new Scanner(System.in);
      Customer c1=new Customer();
      int i=1;
      while (i==1){
    	  
     
      System.out.println("Enter Your Choice:");
      System.out.println("Press 1 For Insert:");
      System.out.println("Press 2 For Show all Details:");
      System.out.println("Press 3 for Delete Details");
     
      System.out.println("Press 0 Exit");
      int choice=Integer.parseInt(sc.nextLine());
     
      
      switch(choice){
      
      case 1:
      
     
      System.out.println("Enter the Customer Name");
      String cname=sc.nextLine();
      System.out.println("Enter The Customer Address");
      String cadd=sc.nextLine();
      Transaction tx=session.beginTransaction();
     c1=new Customer(cname,cadd);
      session.save(c1);
      tx.commit();
      System.out.println("Data Inserted");
    
      break;
      
      case 2:
    	  Transaction tx1=session.beginTransaction();
    	  Query query=session.createQuery("from Customer");
    	  List<Customer> list=query.list();
    	  for(Customer c2:list){
    		  System.out.println(c2);
    	  }
    	  if(list==null){
    		  
    		  System.out.println("Please Enter Data First");
    	  }
    	  tx1.commit();
          break;
      case 3:
    	  Transaction tx2=session.beginTransaction();
    	  System.out.println("Enter the Entry Id you want to delete");
    	  int n=Integer.parseInt(sc.nextLine());
    	  Query query1=session.createQuery("delete from Customer where id="+n+"");
    	  query1.executeUpdate();
    	  tx2.commit();
    	  System.out.println("Deleted Successfully");
    	  break;
     
      }
      
      }
      factory.close();
      session.close();
    }
}
