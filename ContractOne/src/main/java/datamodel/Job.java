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
  email VARCHAR(30) NOT NULL,
  jobDescription VARCHAR(1000) NOT NULL,
  status VARCHAR(30) NOT NULL,
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
   @Column(name = "email")
   private String email;
   @Column(name = "jobDescription")
   private String jobDescription;
   @Column (name = "status")
   private String status;
   
   public Job() {
   }

   public Job(Integer id, String title, String email, String jobDescription) {
	   this.id = id;
       this.title = title;
       this.email = email;
       this.jobDescription = jobDescription;
       this.status = "open";
   }

   public Job(String title, String email, String jobDescription) {
	   this.title = title;
	   this.email = email;
	   this.jobDescription = jobDescription;
	   this.status = "open";
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
   
   public String getEmail() {
	   return email;
   }
   
   public void setEmail(String email) {
	   this.email = email;
   }
   
   public String getJobDescription() {
	   return jobDescription;
   }
   
   public void setJobDescription(String jobDescription) {
	   this.jobDescription = jobDescription;
   }
   
   public String getStatus()
   {
	   return this.status;
   }
   
   public void setStatus(String status)
   {
	   this.status = status;
   }
   
   
   @Override
   public String toString() {
      return "Job: " + this.id + ", " + this.title + ", " + this.email + ", " + this.jobDescription + ", " + this.status;
   }
}