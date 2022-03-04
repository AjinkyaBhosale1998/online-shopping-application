package com.example.demo.dto;

import com.example.demo.model.Category;

import lombok.Data;

@Data
public class ProductDTO {
	private Long id;
	 private String name;
	  private int categoryId;
	   private double price;
	   private String color;
	   private String specification;
	  private String manufacuturer;
	  private int quantity;
	   private String imageName;
}
