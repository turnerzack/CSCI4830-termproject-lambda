package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE job (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(30) NOT NULL,
  customerPointer INT NOT NULL,
  jobDescription VARCHAR(1000) NOT NULL,
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "job")
public class Job {

   @Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id") // specify the column name. Without it, it will use method name
   private Integer id;
   @Column(name = "title")
   private String title;
   @Column(name = "customerPointer")
   private Integer customerPointer;
   @Column(name = "jobDescription")
   private String jobDescription;
   
   public Job() {
   }

   public Job(Integer id, String title, Integer customerPointer, String jobDescription) {
	   this.id = id;
       this.title = title;
       this.customerPointer = customerPointer;
       this.jobDescription = jobDescription;
   }

   public Job(String title, Integer customerPointer, String jobDescription) {
	   this.title = title;
	   this.customerPointer = customerPointer;
	   this.jobDescription = jobDescription;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }
   
   public String getTitle() {
	   return title;
   }
   
   public void setTitle(String title) {
	   this.title = title;
   }
   
   public Integer getCustomerPointer() {
	   return customerPointer;
   }
   
   public void setCustomerPointer(Integer customerPointer) {
	   this.customerPointer = customerPointer;
   }
   
   public String getJobDescription() {
	   return jobDescription;
   }
   
   public void setJobDescription(String jobDescription) {
	   this.jobDescription = jobDescription;
   }
   
   @Override
   public String toString() {
      return "Bid: " + this.id + ", " + this.title + ", " + this.customerPointer + ", " + this.jobDescription;
   }
}