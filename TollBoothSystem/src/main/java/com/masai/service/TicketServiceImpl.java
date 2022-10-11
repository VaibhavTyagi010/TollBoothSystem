package com.masai.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.masai.entity.TicketDto;
import com.masai.entity.TollTicket;
import com.masai.entity.User;
import com.masai.exception.BalanceNotEnough;
import com.masai.exception.InvalidId;
import com.masai.exception.InvalidVehicle;
import com.masai.repository.TicketRepository;
import com.masai.repository.TollsRepository;
import com.masai.repository.UserRepository;
import com.nimbusds.jose.shaded.json.parser.ParseException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@Service
@AllArgsConstructor
@NoArgsConstructor
public class TicketServiceImpl implements TicketService{
	
	private TicketRepository  ticketRepository;
	private UserRepository    UserRepository;
	private TollsRepository   tollsRepository;
	private TicketDto ticketdto;
	

	@Override
	public TicketDto createTicket(TollTicket tollticket)throws RuntimeException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		tollticket.setDataTime(sdf.format(new Date()));
		
		ticketRepository.save(tollticket);
		
		ticketdto.setTicketnumber(tollticket.getTicketNumber());
		ticketdto.setTollId(tollticket.getTollId());
		long id =tollticket.getUserId();
		User fatchUser =UserRepository.findById(id).orElseThrow(() -> new InvalidId("User with ID "+id+" does not exit.."));
		ticketdto.setUserNmae(fatchUser.getFirstName());
		
		String Vehicle= fatchUser.getVehicle();
		
		Boolean comeBack24Hour=false;
		
		
		
		
		
		ArrayList<TollTicket> tickets= (ArrayList)ticketRepository.findAll();
		for(int i=tickets.size()-2;i>=0;i--)
		{
			if(tickets.get(i).getTollId()==tollticket.getTollId())
			{
				comeBack24Hour=checkDifferenceDatatime(tickets.get(i).getDataTime(),tollticket.getDataTime());
				break;
			}
		}
		
		
		
		
		if(Vehicle.equalsIgnoreCase("car"))
		{
			int amount=100;
			 if(comeBack24Hour)
		        {    int discount=(amount/100)*20;
		        	amount = (amount-discount);
		        }
			if(fatchUser.getWallet()>=amount)
				ticketdto.setCharge(amount);
			else
				throw new BalanceNotEnough("Balance Not Enough");
		}
		else if(Vehicle.equalsIgnoreCase("bike"))
		{
			int amount=80;
			 if(comeBack24Hour)
		        {    int discount=(amount/100)*20;
		        	amount = (amount-discount);
		        }
			if(fatchUser.getWallet()>=amount)
				ticketdto.setCharge(amount);
			else
				throw new BalanceNotEnough("Balance Not Enough");
		}
		else if(Vehicle.equalsIgnoreCase("container"))
		{  int amount=500;
			
		 if(comeBack24Hour)
	        {    int discount=(amount/100)*20;
	        	amount = (amount-discount);
	        }
			if(fatchUser.getWallet()>=amount)
				ticketdto.setCharge(amount);
			else
				throw new BalanceNotEnough("Balance Not Enough");
		
		}
		else if(Vehicle.equalsIgnoreCase("bus"))
		{
			int amount=200;
			  if(comeBack24Hour)
		        {    int discount=(amount/100)*20;
		        	amount = (amount-discount);
		        }
			if(fatchUser.getWallet()>=amount)
				ticketdto.setCharge(amount);
			else
				throw new BalanceNotEnough("Balance Not Enough");
		}
		else
		{
			throw new InvalidVehicle("Invaild Vehicle");
		}
		return ticketdto;
	}

	
	public Boolean checkDifferenceDatatime(String start_date,String end_date)
	{
		  SimpleDateFormat sdf
          = new SimpleDateFormat(
              "dd-MM-yyyy HH:mm:ss");

      
      try {
          Date d1 = sdf.parse(start_date);
          Date d2 = sdf.parse(end_date);

       
          long difference_In_Time
              = d2.getTime() - d1.getTime();

          long difference_In_Days
              = (difference_In_Time
                 / (1000 * 60 * 60 * 24))
                % 365;

          if(difference_In_Days==0)
        	  return true;
          else
        	  return false;
          
      }
      catch (Exception e) {
          e.printStackTrace();
      }
		
		return null;
	}
	
	
}
