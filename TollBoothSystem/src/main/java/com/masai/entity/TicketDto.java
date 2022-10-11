package com.masai.entity;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Component
public class TicketDto {
	
	
	private long Ticketnumber;
	private Long tollId;
	private String UserNmae;
	private LocalDateTime dataTime;
	private int charge;
	
}
