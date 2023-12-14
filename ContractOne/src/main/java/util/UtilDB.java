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
	            if (job.getStatus().equals("open"))
	            {
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
	          if (contractor.getEmail().equals(keyword)) {
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
   
   public static Contractor getContractor(String keyword) {
	   Contractor result = null;;
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   try {
		   tx = session.beginTransaction();
	       System.out.println((Contractor)session.get(Contractor.class, 1)); // use "get" to fetch data
	       List<?> contractors = session.createQuery("FROM Contractor").list();
	       for (Iterator<?> iterator = contractors.iterator(); iterator.hasNext();) {
	          Contractor contractor = (Contractor) iterator.next();
	          if (contractor.getEmail().equalsIgnoreCase(keyword)) {
	             result = contractor;
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
	   return result;
   }
   
   public static Customer getCustomer(String keyword) {
	   Customer result = null;;
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   try {
		   tx = session.beginTransaction();
	       System.out.println((Customer)session.get(Customer.class, 1)); // use "get" to fetch data
	       List<?> customers = session.createQuery("FROM Customer").list();
	       for (Iterator<?> iterator = customers.iterator(); iterator.hasNext();) {
	          Customer customer = (Customer) iterator.next();
	          if (customer.getEmail().equals(keyword)) {
	             result = customer;
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
	   return result;
   }

   public static List<Job> listAllJobs() {
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
   
   public static List<Job> listPersonalJobs(String email) {
	   List<Job> resultList = new ArrayList<Job>();
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;  // each process needs transaction and commit the changes in DB.
	      try {
	         tx = session.beginTransaction();
	         List<?> jobs = session.createQuery("FROM Job").list();
	         for (Iterator<?> iterator = jobs.iterator(); iterator.hasNext();) {
	            Job job = (Job) iterator.next();
	            if(job.getEmail().equalsIgnoreCase(email))
	            {
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
	            if (bid.getContractorPointer().equals(keyword)) {
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
   
   public static List<Bid> listBids(Integer jobPointer) {

	      List<Bid> resultList = new ArrayList<Bid>();
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         System.out.println((Bid)session.get(Bid.class, 1)); // use "get" to fetch data
	         List<?> bids = session.createQuery("FROM Bid").list();
	         for (Iterator<?> iterator = bids.iterator(); iterator.hasNext();) {
	            Bid bid = (Bid) iterator.next();
	            if (bid.getJobPointer() == jobPointer) {
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
   
   public static List<Job> listJobs(String keyword) {

	      List<Job> resultList = new ArrayList<Job>();
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         System.out.println((Job)session.get(Job.class, 1)); // use "get" to fetch data
	         List<?> jobs = session.createQuery("FROM Job").list();
	         for (Iterator<?> jobIterator = jobs.iterator(); jobIterator.hasNext();) 
	         {
	        	 boolean hit = true;
	        	 Job job = (Job) jobIterator.next();
	            List<Bid> bids = listBids(job.getId());
	            for (Bid bid : bids)
		        {
		        	 if(bid.getContractorPointer().equals(keyword) || !(job.getStatus().equalsIgnoreCase("open")))
		        	 {
		        		 hit = false;
		        		 break;
		        	 }
		        }
	 	        if(hit && job.getStatus().equalsIgnoreCase("open"))
	 	        {
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

   public static List<Bid> sortBidsByValue() {

	      List<Bid> resultList = new ArrayList<Bid>();
	      Session session = getSessionFactory().openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         System.out.println((Bid)session.get(Bid.class, 1)); // use "get" to fetch data
	         List<?> bids = session.createQuery("FROM Bid").list();
	         Bid currentBid = null;
	         Bid previousBid = null;
	         Bid bid = null;
	         for (Iterator<?> iterator1 = bids.iterator(); iterator1.hasNext();)
	         {
	        	 for (Iterator<?> iterator2 = bids.iterator(); iterator2.hasNext();) {
	        		 bid = (Bid) iterator2.next();
	        		 if (currentBid == null)
	        		 {
	        			 currentBid = bid;
	        		 }
	        		 else if (previousBid == null)
	        		 {
	        			 if (Integer.parseInt(bid.getAmount()) < Integer.parseInt(currentBid.getAmount()))
	        			 {
	        				 currentBid = bid;
	        			 }
	        		 }
	        		 else if (Integer.parseInt(bid.getAmount()) > Integer.parseInt(previousBid.getAmount()) && Integer.parseInt(bid.getAmount()) < Integer.parseInt(currentBid.getAmount())) {
	        			 currentBid = bid;
	        		 }
	        		 if (Integer.parseInt(bid.getAmount()) > Integer.parseInt(previousBid.getAmount()) && Integer.parseInt(previousBid.getContractorPointer()) == Integer.parseInt(bid.getContractorPointer())){
	        			 currentBid = bid;
	        		 }
	        	 }
	        	 resultList.add(bid);
	        	 previousBid = bid;
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

   public static void createBid(Integer jobPointer, String amount, String contractorPointer) {
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
   
   public static void updateJob(Integer jobPointer, String status)
   {
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   List<Job> jobs = listJobs();
	   for (Iterator<?> iterator = jobs.iterator(); iterator.hasNext();) {
           Job job = (Job) iterator.next(); 
           if (job.getId() == jobPointer)
           {
        	   try {  
      	         tx = session.beginTransaction();
      	         Job current = (Job) session.get(Job.class, jobPointer);
      	         current.setStatus(status);
      	         session.update(current);
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
   }
   
   public static void updateBid(Integer bidPointer)
   {
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   List<Bid> bids = listBids();
	   for (Iterator<?> iterator = bids.iterator(); iterator.hasNext();) {
           Bid bid = (Bid) iterator.next(); 
           if (bid.getId() == bidPointer)
           {
        	   try {  
      	         tx = session.beginTransaction();
      	         Bid current = (Bid) session.get(Bid.class, bidPointer);
      	         current.setStatus("Accepted");
      	         session.update(current);
      	         tx.commit();
      	      } catch (HibernateException e) {
      	         if (tx != null)
      	            tx.rollback();
      	         e.printStackTrace();
      	      } finally {

      	      }
           }
           else
           {
        	   try {  
        	         tx = session.beginTransaction();
        	         Bid current = (Bid) session.get(Bid.class, bid.getId());
        	         current.setStatus("Rejected");
        	         session.update(current);
        	         tx.commit();
        	      } catch (HibernateException e) {
        	         if (tx != null)
        	            tx.rollback();
        	         e.printStackTrace();
        	      } finally {

        	      } 
           }
	   }
	   session.close();
   }
   
   public static void updateBid(Integer bidID, String status)
   {
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   List<Bid> bids = listBids();
	   for (Iterator<?> iterator = bids.iterator(); iterator.hasNext();) {
           Bid bid = (Bid) iterator.next(); 
           if (bid.getId() == bidID)
           {
        	   try {  
      	         tx = session.beginTransaction();
      	         Bid current = (Bid) session.get(Bid.class, bidID);
      	         current.setStatus(status);
      	         session.update(current);
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
   }
   
   public static void updateCustomer(Customer customer, String email)
   {
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   List<Customer> customers = listCustomers();
	   for (Iterator<?> iterator = customers.iterator(); iterator.hasNext();) {
           Customer currentCustomer = (Customer) iterator.next(); 
           if (currentCustomer.getEmail().equalsIgnoreCase(email))
           {
        	   try {  
        		   tx = session.beginTransaction();
        		   Customer current = (Customer) session.get(Customer.class, currentCustomer.getId());
        		   current.setName(customer.getName());
        		   current.setAddress(customer.getAddress());
        		   current.setPhone(customer.getPhone());
        		   current.setEmail(customer.getEmail());
        		   current.setDescription(customer.getDescription());
        		   session.update(current);
        		   tx.commit();
      	      } catch (HibernateException e) {
      	         if (tx != null)
      	            tx.rollback();
      	         e.printStackTrace();
      	      } finally {

      	      }
           }
	   }
	   session.close();
   }
   
   public static void updateContractor(Contractor contractor, String email)
   {
	   Session session = getSessionFactory().openSession();
	   Transaction tx = null;
	   List<Contractor> contractors = listContractors();
	   for (Iterator<?> iterator = contractors.iterator(); iterator.hasNext();) {
		   Contractor currentContractor = (Contractor) iterator.next(); 
           if (currentContractor.getEmail().equalsIgnoreCase(email))
           {
        	   try {  
        		   tx = session.beginTransaction();
        		   Contractor current = (Contractor) session.get(Contractor.class, currentContractor.getId());
        		   current.setBusiness(contractor.getBusiness());
        		   current.setAddress(contractor.getAddress());
        		   current.setPhone(contractor.getPhone());
        		   current.setEmail(contractor.getEmail());
        		   current.setDescription(contractor.getDescription());
        		   session.update(current);
        		   tx.commit();
      	      } catch (HibernateException e) {
      	         if (tx != null)
      	            tx.rollback();
      	         e.printStackTrace();
      	      } finally {

      	      }
           }
	   }
	   session.close();
   }
   
   public static boolean validateEmail(String email)
   {
	   boolean validEmail = true;
	   List<Customer> customers = listCustomers();
	   for (Customer customer : customers)
	   {
		   if(customer.getEmail().equalsIgnoreCase(email))
		   {
			   validEmail = false;
		   }
	   }
	   List<Contractor> contractors = listContractors();
	   for (Contractor contractor : contractors)
	   {
		   if(contractor.getEmail().equalsIgnoreCase(email))
		   {
			   validEmail = false;
		   }
	   }
	   return validEmail;
   }
}
