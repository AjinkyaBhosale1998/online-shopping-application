package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Order;
import com.example.demo.model.Product;

public interface ProductService {
	List<Product> getAllProducts();
    void addProducts(Product product);
	Optional<Product> getproductById(long id);
	void removeProduct(long id);
	public List<Product>viewProductbyCategory(int id);
	public void updateProducts(Product product);
	//List<Customer> getcustomerByLocation(String location);

}
