package com.bece.wifi.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bece.wifi.api.dto.VisitorDTO;
import com.bece.wifi.api.entities.Visitor;
import com.bece.wifi.api.repositories.VisitorRepository;

@Service
public class CreateVisitorService {
	
	@Autowired
	private VisitorRepository visitorRepository;
	
	public void execute(VisitorDTO visitorDTO) {
		// Check how to create a custom method in the repository
	}
}
