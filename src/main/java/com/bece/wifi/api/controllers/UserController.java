package com.bece.wifi.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bece.wifi.api.dto.UserDTO;
import com.bece.wifi.api.entities.User;
import com.bece.wifi.api.services.CreateUserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private CreateUserService createUserService;
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST)
	public User store(@Valid @RequestBody UserDTO userDTO) {
		return this.createUserService.execute(userDTO);
	}
}
