package com.TechMahindra.SmartCommute.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TechMahindra.SmartCommute.Domain.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUserName(String userName);
	
}

