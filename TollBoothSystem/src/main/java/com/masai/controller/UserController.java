package com.masai.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.User;
import com.masai.service.CustomUserDetailsServiceInterface;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class UserController {
	
	private CustomUserDetailsServiceInterface Customuser;
	
	
	@PostMapping("/process_register")
	public User processRegister(@Valid @RequestBody User user) {   
	    return Customuser.createUser(user); 
	}

	@PutMapping("/updateUser/{id}")
	public User updateUser(@Valid @RequestBody User user, @PathVariable("id")long id)
	{
		return Customuser.UpdateUser(user, id);
	}
	@DeleteMapping("/DeleteUser/{id}")
	public User deleteUser(@PathVariable("id")long id)
	{
		return Customuser.DeleteUser(id);
	}
	
	
}
