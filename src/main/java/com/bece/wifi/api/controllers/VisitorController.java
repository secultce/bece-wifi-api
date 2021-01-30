package com.bece.wifi.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bece.wifi.api.dto.VisitorDTO;
import com.bece.wifi.api.entities.Visitor;
import com.bece.wifi.api.repositories.VisitorRepository;
import com.bece.wifi.api.services.CreateVisitorService;
import com.bece.wifi.api.services.UpdateVisitorService;

@RestController
@RequestMapping(value = "/visitors")
public class VisitorController {
	
	@Autowired
	private VisitorRepository visitorRepository;
	
	@Autowired
	private CreateVisitorService createVisitorService;
	
	@Autowired
	private UpdateVisitorService updateVisitorService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Visitor> index() {
		List<Visitor> visitors = this.visitorRepository.findAll();
		
		// List<VisitorDTO> listDto = visitors.stream()
		//  		.map(v -> new VisitorDTO(v)).collect(Collectors.toList());
		
		return visitors;
	}
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST)
	public Visitor store(@Valid @RequestBody VisitorDTO visitorDTO) {
		return this.createVisitorService.execute(visitorDTO);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public Visitor update(@Valid @RequestBody VisitorDTO visitorDTO, @PathVariable Integer id) {
		return this.updateVisitorService.execute(visitorDTO, id);
	}
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable Integer id) {
		this.visitorRepository.deleteById(id);;
	}
 }
