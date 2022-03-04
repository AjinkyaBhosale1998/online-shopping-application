package com.example.demo.services;
import java.util.List;


import com.example.demo.model.Order;

public interface OrderService {
	List<Order> getAllcustomer();
    void savecustomer(Order customer);
	Order getcustomerById(int id);
	void deleteorderById(int id);
	public void update(Order customer);
	//List<Customer> getcustomerByLocation(String location);
//	List<Customer> getAllcustomer();
//    void savecustomer(Customer customer);
//	Customer getcustomerById(long id);
//	void deletecustomerById(long id);
//	public void update(Customer customer);

}
