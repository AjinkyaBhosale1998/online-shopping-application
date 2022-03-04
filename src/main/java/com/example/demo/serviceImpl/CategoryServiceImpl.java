package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepo;
import com.example.demo.services.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
   @Autowired
  private CategoryRepo categoryRepo;
	@Override
	public List<Category> getAllcategory() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}

	@Override
	public void addcategory(Category category) {
		categoryRepo.save(category);
		
	}

	@Override
	public void deletecategory(int id) {
		categoryRepo.deleteById(id);
		
	}

	@Override
	public void update(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Category> getCategoryById(int id) {
		// TODO Auto-generated method stub
		return categoryRepo.findById(id);
	}

	
	

}
