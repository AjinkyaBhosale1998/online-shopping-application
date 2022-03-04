package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepo;
import com.example.demo.services.OrderService;
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
     private OrderRepo orderRepo;
	@Override
	public List<Order> getAllcustomer() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}

	@Override
	public void savecustomer(Order customer) {
		this.orderRepo.save(customer);
		
	}

	@Override
	public Order getcustomerById(int id) {
		// TODO Auto-generated method stub
		return orderRepo.getById(id);
	}

	@Override
	public void deleteorderById(@PathVariable int id)
	{
	   orderRepo.deleteById(id);
		
	}

	@Override
	public void update(Order customer) {
		// TODO Auto-generated method stub
		
	}

	


//
//	@Override
//	public void update(Order customer) {
//	  this.customerRepo.save(customer);
//		
//	}

}
