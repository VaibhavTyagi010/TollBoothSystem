package com.masai.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.masai.entity.Admin;
import com.masai.entity.CustomUserDetails;
import com.masai.entity.User;
import com.masai.exception.InvalidId;
import com.masai.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class CustomUserDetailsService implements UserDetailsService ,CustomUserDetailsServiceInterface{
	 
  
    private UserRepository userRepo;
     
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

	@Override
	public List<User> findall() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		  BCryptPasswordEncoder  passwordEncoder = new BCryptPasswordEncoder();
		    String encodedPassword = passwordEncoder.encode(user.getPassword());
		    user.setPassword(encodedPassword);
		     
		   
		return  userRepo.save(user);
	
	}

	@Override
	public User UpdateUser(User user, Long id) throws InvalidId {
		User fatchUser =userRepo.findById(id).orElseThrow(() -> new InvalidId("User with ID "+id+" does not exit.."));
		
		
		fatchUser.setEmail(user.getEmail());
		fatchUser.setFirstName(user.getFirstName());
		fatchUser.setLastName(user.getLastName());
		fatchUser.setMobile(user.getMobile());
		fatchUser.setPassword(user.getPassword());
		fatchUser.setVehicle(user.getVehicle());
		fatchUser.setVehicleNumber(user.getVehicleNumber());
		
		
		  BCryptPasswordEncoder  passwordEncoder = new BCryptPasswordEncoder();
		    String encodedPassword = passwordEncoder.encode(fatchUser.getPassword());
		    fatchUser.setPassword(encodedPassword);
		     
		   
		return  userRepo.save(fatchUser);
		
		
	}

	@Override
	public User DeleteUser(Long id) throws InvalidId {
		
		
	User fatchUser =userRepo.findById(id).orElseThrow(() -> new InvalidId("User with ID "+id+" does not exit.."));
	
	userRepo.deleteById(id);
		return fatchUser ;
		
	
	}
 
}

