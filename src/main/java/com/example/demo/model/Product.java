package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Product {
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 private Long id;
 private String name;
	
   @ManyToOne(fetch =FetchType.LAZY)
   @JoinColumn(name="category_id",referencedColumnName = "category_id")
   private Category category;
   private double price;
   private String color;
   private String specification;
  private String manufacuturer;
   private int quantity;
   private String imageName;
}
