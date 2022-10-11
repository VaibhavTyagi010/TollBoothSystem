package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.TollTicket;

public interface TicketRepository extends JpaRepository<TollTicket, Long>{

}
