package com.bece.wifi.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bece.wifi.api.dto.VisitorDTO;
import com.bece.wifi.api.entities.Visitor;
import com.bece.wifi.api.exceptions.CPFAlreadyRegisteredRequestException;
import com.bece.wifi.api.repositories.VisitorRepository;

@Service
public class CreateVisitorService {
	
	@Autowired
	private VisitorRepository visitorRepository;
	
	public Visitor execute(VisitorDTO visitorDTO) {
		String name = visitorDTO.getName();
		String cpf = visitorDTO.getCpf();
		
		Boolean visitorExists 
			= this.visitorRepository.existsByCpf(cpf);
		
		if (visitorExists) {
			throw new CPFAlreadyRegisteredRequestException("CPF já cadastrado!");
		}
		
		Visitor visitor = new Visitor(name, cpf);
		
		return this.visitorRepository.save(visitor);
	}
}
