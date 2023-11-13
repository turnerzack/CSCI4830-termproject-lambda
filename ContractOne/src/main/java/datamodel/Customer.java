package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE customer (
  id INT NOT NULL AUTO_INCREMENT,    
  name VARCHAR(30) NOT NULL,   
  address VARCHAR(30) NOT NULL,
  phone VARCHAR(30) NOT NULL,
  email VARCHAR(30) NOT NULL,
  description VARCHAR(1000) NOT NULL,
  password VARCHAR(30) NOT NULL,   
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "customer")
public class Customer {

   @Id  // primary key
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id") // specify the column name. Without it, it will use method name
   private Integer id;
   @Column(name = "name")
   private String name;
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

   public Customer() {
   }

   public Customer(Integer id, String name, String address, String phone, String email, String description, String password) {
      this.id = id;
      this.name = name;
      this.address = address;
      this.phone = phone;
      this.email = email;
      this.description = description;
      this.password = password;
   }

   public Customer(String name, String address, String phone, String email, String description, String password) {
      this.name = name;
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

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
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
      return "Customer: " + this.id + ", " + this.name + ", " + this.address + ", " + this.phone + 
    		  ", " + this.email + ", " + this.description + ", " + this.password;
   }
}