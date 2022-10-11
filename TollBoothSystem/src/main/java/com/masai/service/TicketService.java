package com.masai.service;

import com.masai.entity.TicketDto;
import com.masai.entity.TollTicket;

public interface TicketService {

	
	public TicketDto createTicket(TollTicket tollticket)throws RuntimeException; 
	
}
