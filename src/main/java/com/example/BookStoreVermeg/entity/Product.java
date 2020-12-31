package com.example.BookStoreVermeg.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity 
@Data 
@AllArgsConstructor 
@NoArgsConstructor

public class Product {
	 @Id 
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    
	 private Long id;
	   
	 @Column( updatable = false)
	  
	 private Date date = new Date();
	  
	// private boolean windedUp = false;
	  
	 @ManyToOne
	  
	 private User user;

}
