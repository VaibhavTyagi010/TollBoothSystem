package com.masai.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.TicketDto;
import com.masai.entity.TollTicket;
import com.masai.service.TicketService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class TicketController {

	private TicketService ticketService;
	
	@PostMapping("/createTicket")
	public TicketDto CreateAdmin(@Valid @RequestBody TollTicket tollTicket)
	{
		return ticketService.createTicket(tollTicket);
	}
	
	
}
