package com.example.demo.model;






import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Table(name="orderr")
@Data
@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	@Temporal(TemporalType.TIMESTAMP)
	
	private Date oderdate=new Date();
	
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String email;
	private String address;
     private String buildingName;
	  private String city;
	  private int postcode;
	      @OneToOne(cascade = CascadeType.ALL)
	  private Product product;
	

}
