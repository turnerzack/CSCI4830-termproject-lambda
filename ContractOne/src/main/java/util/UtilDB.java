/**
 */
package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import datamodel.Customer;
import datamodel.Contractor;
import datamodel.Job;
import datamodel.Bid;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @since JavaSE-1.8
 */
public class UtilDB {
   static SessionFactory sessionFactory = null;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory != null) {
         return sessionFactory;
      }
      Configuration configuration = new Configuration().configure();
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
      sessionFactory = configuration.buildSessionFactory(builder.build());
      return sessionFactory;
   }

   public static List<Customer> listCustomers() {

      List<Customer> resultList = new ArrayList<Customer>();
      Session session = getSessionFactory().openSession();
      Transaction tx = null;  // each process needs transaction and commit the changes in DB.
      try {
         tx = session.beginTransaction();
         List<?> customers = session.createQuery("FROM Customer").list();
         for (Iterator<?> iterator = customers.iterator(); iterator.hasNext();) {
            Customer customer = (Customer) iterator.next();
            resultList.add(customer);
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }

   public static List<Contractor> listContractors() {
	      List<Contractor> resultList = new ArrayList<Contractor>();
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;  // each process needs transaction and commit the changes in DB.
	      try {
	         tx = session.beginTransaction();
	         List<?> contractors = session.createQuery("FROM Contractor").list();
	         for (Iterator<?> iterator = contractors.iterator(); iterator.hasNext();) {
	            Contractor contractor = (Contractor) iterator.next();
	            resultList.add(contractor);
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	      return resultList;
	   }

   public static List<Job> listJobs() {

	      List<Job> resultList = new ArrayList<Job>();
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;  // each process needs transaction and commit the changes in DB.
	      try {
	         tx = session.beginTransaction();
	         List<?> jobs = session.createQuery("FROM Job").list();
	         for (Iterator<?> iterator = jobs.iterator(); iterator.hasNext();) {
	            Job job = (Job) iterator.next();
	            resultList.add(job);
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	      return resultList;
	   }

   public static List<Bid> listBids() {

	      List<Bid> resultList = new ArrayList<Bid>();
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;  // each process needs transaction and commit the changes in DB.
	      try {
	         tx = session.beginTransaction();
	         List<?> bids = session.createQuery("FROM Bid").list();
	         for (Iterator<?> iterator = bids.iterator(); iterator.hasNext();) {
	            Bid bid = (Bid) iterator.next();
	            resultList.add(bid);
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	      return resultList;
	   }

   public static List<Customer> listCustomers(String keyword) {

      List<Customer> resultList = new ArrayList<Customer>();
      Session session = getSessionFactory().openSession();
      Transaction tx = null;
      try {
         tx = session.beginTransaction();
         System.out.println((Customer)session.get(Customer.class, 1)); // use "get" to fetch data
         List<?> customers = session.createQuery("FROM Customer").list();
         for (Iterator<?> iterator = customers.iterator(); iterator.hasNext();) {
            Customer customer = (Customer) iterator.next();
            if (customer.getEmail().startsWith(keyword)) {
               resultList.add(customer);
            }
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx != null)
            tx.rollback();
         e.printStackTrace();
      } finally {
         session.close();
      }
      return resultList;
   }
  
   public static List<Contractor> listContractors(String keyword) {
	   List<Contractor> resultList = new ArrayList<Contractor>();
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   try {
		   tx = session.beginTransaction();
	       System.out.println((Contractor)session.get(Contractor.class, 1)); // use "get" to fetch data
	       List<?> contractors = session.createQuery("FROM Contractor").list();
	       for (Iterator<?> iterator = contractors.iterator(); iterator.hasNext();) {
	          Contractor contractor = (Contractor) iterator.next();
	          if (contractor.getEmail().startsWith(keyword)) {
	             resultList.add(contractor);
	          }
	       }
	       tx.commit();
	   } catch (HibernateException e) {
	       if (tx != null)
	          tx.rollback();
	       e.printStackTrace();
	   } finally {
	       session.close();
	   }
	   return resultList;
   }

   public static List<Job> listJobs(String keyword) {

	      List<Job> resultList = new ArrayList<Job>();
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         System.out.println((Job)session.get(Job.class, 1)); // use "get" to fetch data
	         List<?> jobs = session.createQuery("FROM Job").list();
	         for (Iterator<?> iterator = jobs.iterator(); iterator.hasNext();) {
	            Job job = (Job) iterator.next();
	            if (job.getTitle().startsWith(keyword)) {
	               resultList.add(job);
	            }
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	      return resultList;
	   }

   public static List<Bid> listBids(String keyword) {

	      List<Bid> resultList = new ArrayList<Bid>();
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         System.out.println((Bid)session.get(Bid.class, 1)); // use "get" to fetch data
	         List<?> bids = session.createQuery("FROM Bid").list();
	         for (Iterator<?> iterator = bids.iterator(); iterator.hasNext();) {
	            Bid bid = (Bid) iterator.next();
	            if (bid.getAmount().startsWith(keyword)) {
	               resultList.add(bid);
	            }
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
	      return resultList;
	   }
  
   public static void createCustomer(String name, String address, String phone, String email, String description, String password) {
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;
	      try {  
	         tx = session.beginTransaction();
	         session.save(new Customer(name, address, phone, email, description, password));
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
   }
      
   public static void createContractor(String business, String address, String phone, String email, String description, String password) {
          Session session = getSessionFactory().openSession();
          Transaction tx = null;
          try {  
             tx = session.beginTransaction();
             session.save(new Contractor(business, address, phone, email, description, password));
             tx.commit();
          } catch (HibernateException e) {
             if (tx != null)
                tx.rollback();
             e.printStackTrace();
          } finally {
             session.close();
          }
   }

   public static void createJob(String title, String email, String jobDescription) {
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;
	      try {  
	         tx = session.beginTransaction();
	         session.save(new Job(title, email, jobDescription));
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
   }

   public static void createBid(Integer jobPointer, String amount, Integer contractorPointer) {
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;
	      try {  
	         tx = session.beginTransaction();
	         session.save(new Bid(jobPointer, amount, contractorPointer));
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx != null)
	            tx.rollback();
	         e.printStackTrace();
	      } finally {
	         session.close();
	      }
   }

}
