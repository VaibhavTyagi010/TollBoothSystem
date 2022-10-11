package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Admin;
import com.masai.entity.User;
import com.masai.service.AdminService;
import com.masai.service.CustomUserDetailsServiceInterface;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class AdminController {
	
	private AdminService adminService;
	private CustomUserDetailsServiceInterface Customuser;

	
	@PostMapping("/createAdmin")
	public Admin CreateAdmin(@Valid @RequestBody Admin admin)
	{
		return adminService.createAdmin(admin);
	}
	
	@PutMapping("/upadteAdmin/{id}")
	public Admin updateAdmin(@Valid @RequestBody Admin admin,@PathVariable("id")Long id)
	{
		return adminService.UpdateAdmin(admin, id);
	}
	
	@DeleteMapping("/deleteAdmin/{id}")
	public Admin DeleteAdminbyid(@PathVariable("id")Long id)
	{
		return adminService.DeleteAdmin(id);
		
	}
   

	@GetMapping("/users")
	public List<User> listUsers(Model model) {
	    List<User> listUsers = Customuser.findall();
	    model.addAttribute("listUsers", listUsers);
	     
	    return listUsers ;
	}
	
}
