package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.websecurity.Usercustomdetails;


public class UsercustomerServices implements UserDetailsService {

	@Autowired 
    private UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepo.findByUsername(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("user not found");
		}
		return new Usercustomdetails(user);
	}
}
