package com.masai.service;

import com.masai.entity.Tolls;
import com.masai.exception.InvalidId;

public interface Tollservice {

	
	
	public Tolls addToll(Tolls toll);
	public Tolls updateToll(Tolls toll,Long id) throws InvalidId;
	public Tolls deleteToll(Long id) throws InvalidId;
	
}
