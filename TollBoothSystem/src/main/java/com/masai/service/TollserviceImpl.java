package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.entity.Tolls;
import com.masai.exception.InvalidId;
import com.masai.repository.TollsRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class TollserviceImpl implements Tollservice {

	private TollsRepository tollrepo;
	
	@Override
	public Tolls addToll(Tolls toll) {
		// TODO Auto-generated method stub
		return tollrepo.save(toll);
	}

	@Override
	public Tolls updateToll(Tolls toll, Long id) throws InvalidId {
		// TODO Auto-generated method stub
		Tolls fatchToll =tollrepo.findById(id).orElseThrow(() -> new InvalidId("Toll with ID "+id+" does not exit.."));
		
		fatchToll.setTollName(toll.getTollName());
		return tollrepo.save(fatchToll);
	}

	@Override
	public Tolls deleteToll(Long id) throws InvalidId {
		
		Tolls fatchToll =tollrepo.findById(id).orElseThrow(() -> new InvalidId("Toll with ID "+id+" does not exit.."));
		tollrepo.deleteById(id);
		return fatchToll ;
	}

}
