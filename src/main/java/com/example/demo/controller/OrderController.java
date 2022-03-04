package com.example.demo.controller;







import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.global.GlobalData;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.serviceImpl.OrderServiceImpl;
import com.example.demo.serviceImpl.ProductServiceImpl;


@Controller
@RequestMapping
public class OrderController {
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	@Autowired
	ProductServiceImpl productServiceImpl;
	
	@GetMapping("/get")
	  public String adminHome() 
	{
		return "checkout";
	}
	@GetMapping("/add")
	  public String addorder(Model model)   
	  {
		 Order order=new Order();
		  model.addAttribute("order",new Order());
          model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		  return "checkout";
	  }
	 @PostMapping("/order/add") //to post category
	  public String postcategories(@ModelAttribute("order") Order order )
	  {
		 //customer.getFirstName();
		orderServiceImpl.savecustomer(order);
	//	GlobalData.cart.add(productServiceImpl.getproductById(id).get());
		  return "redirect:/get/all";
	  }
	

	@GetMapping("/get/all")
	public String displayorders(Model model)
	{
		
		 model.addAttribute("order",orderServiceImpl.getAllcustomer());
		 model.addAttribute("total1",GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		 model.addAttribute("cart", GlobalData.cart);
		 
		 return "orderPlaced";
	}
//	@PutMapping("/update")
//	public void update(@RequestBody Order order)
//	{
//		orderServiceImpl.update(order);
//	}
	@GetMapping("/del/{id}")
	public String delet(@PathVariable int id)
	{
		orderServiceImpl.deleteorderById(id);
		return "redirect:/shop";
	}
	
}

