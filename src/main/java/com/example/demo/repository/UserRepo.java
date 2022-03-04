package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.model.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	@Query(" select u from User u where u.username=?1")
	  User findByUsername(String username);
}
