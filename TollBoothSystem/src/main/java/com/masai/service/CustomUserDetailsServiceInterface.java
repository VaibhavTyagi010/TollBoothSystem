package com.masai.service;

import java.util.List;

import com.masai.entity.User;
import com.masai.exception.InvalidId;

public interface CustomUserDetailsServiceInterface {

	
	public User createUser(User user);
	public List<User> findall();
	public User UpdateUser(User admin ,Long id) throws InvalidId;
	public User DeleteUser(Long id) throws InvalidId;
	
}
