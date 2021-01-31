package com.bece.wifi.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bece.wifi.api.dto.UserDTO;
import com.bece.wifi.api.entities.User;
import com.bece.wifi.api.exceptions.EmailAlreadyRegisteredRequestException;
import com.bece.wifi.api.repositories.UserRepository;
import com.bece.wifi.api.utils.BCryptUtil;

@Service
public class CreateUserService {

	@Autowired
	private UserRepository userRepository;
	
	public User execute(UserDTO userDTO) {
		String name = userDTO.getName();
		String email = userDTO.getEmail();
		String password = userDTO.getPassword();
		
		Boolean userExists = this.userRepository.existsByEmail(email);
		
		if (userExists) {
			throw new EmailAlreadyRegisteredRequestException("Email já cadastrado");
		}
		
		String hashedPassword = BCryptUtil.hash(password);
		
		User user = new User(name, email, hashedPassword);
		
		return this.userRepository.save(user);
	}
}
