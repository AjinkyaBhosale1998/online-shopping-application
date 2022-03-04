package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;


@Controller
public class UserController {
	@Autowired
	public UserRepo userRepo;
	
	@GetMapping("/Adminhome1")
	public String home()
	{
		return "login";
	}
	 @GetMapping("/register")
	 public String singup( Model model) {
		
		 model.addAttribute("admin", new User());
		 return "SignupForm";
	}
	 
	 @PostMapping("/stddata")
	 public String storedatam(Model model ,User user)
	 {
		 BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		 String encodedPassword= encoder.encode(user.getPassword());
		 user.setPassword(encodedPassword);
		 userRepo.save(user);
		 return "redirect:/Adminhome1";
	 }
	 @GetMapping("/demo")
	 public String demo()
	 {
		 return "index";
	 }

}
