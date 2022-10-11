package com.masai.service;

import com.masai.entity.Admin;
import com.masai.exception.InvalidId;

public interface AdminService {
	
	
	public Admin createAdmin(Admin admin);
	public Admin UpdateAdmin(Admin admin ,Long id) throws InvalidId;
	public Admin DeleteAdmin(Long id) throws InvalidId;
	
	
}
