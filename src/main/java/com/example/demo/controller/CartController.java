package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.global.GlobalData;
import com.example.demo.model.Product;
import com.example.demo.serviceImpl.ProductServiceImpl;

@Controller
public class CartController {
	@Autowired
	ProductServiceImpl productServiceImpl;
	@GetMapping("/addToCart/{id}")
	public String addToCart(@PathVariable int id)
	{
		GlobalData.cart.add(productServiceImpl.getproductById(id).get());
		return "redirect:/shop";
	}
	@GetMapping("/cart")
	public String showCart(Model model)
	{
		model.addAttribute("cartCount",GlobalData.cart.size());
		model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		model.addAttribute("cart", GlobalData.cart);
		return "cart";
	}
	  @GetMapping("/cart/removeItem/{index}")
	  public String removefromCart(@PathVariable int index)
	  {
		  GlobalData.cart.remove(index);
		  return "redirect:/cart";
	  }
	  @GetMapping("/checkout")
	  public String checkout(Model model)
	  {
			model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
			return "checkout";
	  }
	
	

}
