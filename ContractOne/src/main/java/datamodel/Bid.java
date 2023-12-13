package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE bid (
  id INT NOT NULL AUTO_INCREMENT,    
  jobPointer INT NOT NULL,   
  amount VARCHAR(30) NOT NULL,
  contractorPointer INT NOT NULL,
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "bid")
public class Bid {

   @Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id") // specify the column name. Without it, it will use method name
   private Integer id;
   @Column(name = "jobPointer")
   private Integer jobPointer;
   @Column(name = "amount")
   private String amount;
   @Column(name = "contractorPointer")
   private String contractorPointer;
   @Column(name = "status")
   private String status;
   
   public Bid() {
   }

   public Bid(Integer id, Integer jobPointer, String amount, String contractorPointer) {
      this.id = id;
      this.jobPointer = jobPointer;
      this.amount = amount;
      this.contractorPointer = contractorPointer;
      this.status = "open";
   }

   public Bid(Integer jobPointer, String amount, String contractorPointer) {
      this.jobPointer = jobPointer;
      this.amount = amount;
      this.contractorPointer = contractorPointer;
      this.status = "open";
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }
   
   public Integer getJobPointer() {
	   return jobPointer;
   }
   
   public void setJobPointer(Integer jobPointer) {
	   this.jobPointer = jobPointer;
   }
   
   public String getAmount() {
	   return amount;
   }
   
   public void setAmount(String amount) {
	   this.amount = amount;
   }
   
   public String getContractorPointer() {
	   return contractorPointer;
   }
   
   public void setContractorPointer(String contractorPointer) {
	   this.contractorPointer = contractorPointer;
   }
   
   public String getStatus() {
	   return this.status;
   }
   
   public void setStatus(String status) {
	   this.status = status;
   }
   
   @Override
   public String toString() {
      return "Bid: " + this.id + ", " + this.jobPointer + ", " + this.amount + ", " + this.contractorPointer + ", " + this.status;
   }
}