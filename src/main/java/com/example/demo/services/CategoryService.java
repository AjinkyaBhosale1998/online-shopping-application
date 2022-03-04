package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Category;
import com.example.demo.model.Order;

public interface CategoryService {
	public List<Category> getAllcategory();
   public void addcategory(Category category);
  public  void deletecategory(int id);
	public void update(int id);
	public Optional<Category> getCategoryById(int id);
}
