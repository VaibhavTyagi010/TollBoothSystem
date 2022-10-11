package com.masai.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Tolls;
import com.masai.service.Tollservice;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class TollsController {

	private Tollservice tollservice;
	
	
	
	@PostMapping("/createToll")
	public Tolls CreateAdmin(@Valid @RequestBody Tolls toll)
	{
		return tollservice.addToll(toll);
	}
	
	@PutMapping("/upadteToll/{id}")
	public Tolls updateAdmin(@Valid @RequestBody Tolls toll,@PathVariable("id")Long id)
	{
		return tollservice.updateToll(toll, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public Tolls DeleteAdmin(@PathVariable("id")Long id)
	{
		return tollservice.deleteToll(id);
		
	}
  
}
