package com.masai.entity;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TollTicket {

	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long ticketNumber;
	    
	    @NotNull(message = "{notNull}")
	    private Long tollId;
	    @NotNull(message = "{notNull}")
	    private Long userId;
	    private String dataTime;
}
