package com.masai.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.masai.entity.Admin;
import com.masai.exception.InvalidId;
import com.masai.repository.AdminRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class AdminServiceImp implements AdminService {
	
	
	private AdminRepository adminrepo;

	@Override
	public Admin createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		 BCryptPasswordEncoder  passwordEncoder = new BCryptPasswordEncoder();
		    String encodedPassword = passwordEncoder.encode(admin.getPassword());
		    admin.setPassword(encodedPassword);
		return adminrepo.save(admin) ;
	}

	@Override
	public Admin UpdateAdmin(Admin admin, Long id) throws InvalidId {
		Admin fatchadmin = adminrepo.findById(id).orElseThrow(() -> new InvalidId("Admin with ID "+id+" does not exit.."));
		fatchadmin.setEmail(admin.getEmail());
		fatchadmin.setFirstName(admin.getFirstName());
		fatchadmin.setLastName(admin.getLastName());
		fatchadmin.setPassword(admin.getPassword());
		fatchadmin.setMobile(admin.getMobile());
		
		 BCryptPasswordEncoder  passwordEncoder = new BCryptPasswordEncoder();
		    String encodedPassword = passwordEncoder.encode(fatchadmin.getPassword());
		    fatchadmin.setPassword(encodedPassword);
		
		
		
		return adminrepo.save(fatchadmin);
	}

	@Override
	public Admin DeleteAdmin(Long id) throws InvalidId {
		// TODO Auto-generated method stub
		Admin fatchadmin = adminrepo.findById(id).orElseThrow(() -> new InvalidId("Admin with ID "+id+" does not exit.."));
		
		adminrepo.deleteById(id);
		return fatchadmin ;
	}
	
	

	

	
	
}
