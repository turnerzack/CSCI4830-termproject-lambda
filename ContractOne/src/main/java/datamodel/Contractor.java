package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE contractor (
  id INT NOT NULL AUTO_INCREMENT,    
  business VARCHAR(30) NOT NULL,   
  address VARCHAR(30) NOT NULL,
  phone VARCHAR(30) NOT NULL,
  email VARCHAR(30) NOT NULL,
  description VARCHAR(1000) NOT NULL,
  password VARCHAR(30) NOT NULL,   
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "contractor")
public class Contractor {

   @Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id") // specify the column name. Without it, it will use method name
   private Integer id;
   @Column(name = "business")
   private String business;
   @Column(name = "address")
   private String address;
   @Column(name = "phone")
   private String phone;
   @Column(name = "email")
   private String email;
   @Column(name = "description")
   private String description;
   @Column(name = "password")
   private String password;

   public Contractor() {
   }

   public Contractor(Integer id, String business, String address, String phone, String email, String description, String password) {
      this.id = id;
      this.business = business;
      this.address = address;
      this.phone = phone;
      this.email = email;
      this.description = description;
      this.password = password;
   }

   public Contractor(String business, String address, String phone, String email, String description, String password) {
      this.business = business;
      this.address = address;
      this.phone = phone;
      this.email = email;
      this.description = description;
      this.password = password;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getBusiness() {
      return business;
   }

   public void setBusiness(String business) {
      this.business = business;
   }
   
   public String getAddress() {
	   return address;
   }
   
   public void setAddress(String address) {
	   this.address = address;
   }
   
   public String getPhone() {
	   return this.phone;
   }
   
   public void setPhone(String phone) {
	   this.phone = phone;
   }
   
   public String getEmail() {
	   return this.email;
   }
   
   public void setEmail(String email) {
	   this.email = email;
   }
   
   public String getDescription() {
	   return this.description;
   }
   
   public void setDescription(String description) {
	   this.description = description;
   }
   
   public String getPassword() {
	   return this.password;
   }
   
   public void setPassword(String password) {
	   this.password = password;
   }

   @Override
   public String toString() {
      return "Contractor: " + this.id + ", " + this.business + ", " + this.address + ", " + this.phone + 
    		  ", " + this.email + ", " + this.description + ", " + this.password;
   }
}