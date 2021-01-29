package com.bece.wifi.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bece.wifi.api.dto.VisitorDTO;
import com.bece.wifi.api.entities.Visitor;
import com.bece.wifi.api.repositories.VisitorRepository;
import com.bece.wifi.api.services.CreateVisitorService;

@RestController
@RequestMapping(value = "/visitors")
public class VisitorController {
	
	@Autowired
	private VisitorRepository visitorRepository;
	
	@Autowired
	private CreateVisitorService createVisitorService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<VisitorDTO>> findAll() {
		List<Visitor> list = this.visitorRepository.findAll();
		
		List<VisitorDTO> listDto = list.stream()
				.map(v -> new VisitorDTO(v)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Visitor> store(@Valid @RequestBody VisitorDTO visitorDTO) {
		
		Visitor visitor = this.createVisitorService.execute(visitorDTO);

		return ResponseEntity.ok().body(visitor);
	}
 }
