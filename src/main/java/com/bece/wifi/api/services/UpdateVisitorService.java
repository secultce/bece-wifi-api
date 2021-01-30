package com.bece.wifi.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bece.wifi.api.dto.VisitorDTO;
import com.bece.wifi.api.entities.Visitor;
import com.bece.wifi.api.exceptions.CPFAlreadyRegisteredRequestException;
import com.bece.wifi.api.exceptions.NotFoundException;
import com.bece.wifi.api.exceptions.NotFoundRequestException;
import com.bece.wifi.api.repositories.VisitorRepository;

@Service
public class UpdateVisitorService {
	
	@Autowired
	private VisitorRepository visitorRepository;
	
	public Visitor execute(VisitorDTO visitorDTO, Integer id) {
		String name = visitorDTO.getName();
		String cpf = visitorDTO.getCpf();
		
		Visitor visitor = this.visitorRepository.findById(id).orElse(null);
		
		if (visitor == null) {
			throw new NotFoundRequestException("Visitante não encontrado!");
		}
		
		Boolean visistorExists = this.visitorRepository.existsByCpf(cpf);
		
		if (visistorExists && visitor.getCpf() != cpf) {
			throw new CPFAlreadyRegisteredRequestException("CPF já cadastrado");
		}
		
		visitor.setName(name);
		visitor.setCpf(cpf);
		
		return this.visitorRepository.save(visitor);
	}
}
