package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;
import com.example.demo.services.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
 @Autowired
 ProductRepo productRepo;
	@Override
	public List<Product> getAllProducts() {
		
		return productRepo.findAll();
	}

	@Override
	public void addProducts(Product product) {
		productRepo.save(product);
		
	}

	
	@Override
	public void removeProduct(long id) {
		// TODO Auto-generated method stub
		productRepo.deleteById(id);
	}

	@Override
	public List<Product> viewProductbyCategory(int id) {
		// TODO Auto-generated method stub
		return productRepo.findAllByCategory_id(id);
	}

	@Override
	public void updateProducts(Product product) {
		productRepo.save(product);
		
	}

	@Override
	public Optional<Product> getproductById(long id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id);
	}

}
