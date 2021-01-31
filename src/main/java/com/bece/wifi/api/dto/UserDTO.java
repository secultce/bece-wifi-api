package com.bece.wifi.api.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Nome obrigatório")
	private String name;
	
	@NotEmpty(message = "Email obrigatório")
	@Email(message = "Email inválido")
	private String email;
	
	@NotEmpty(message = "Senha obrigatória")
	@Length(min = 8, max = 16, message = "A senha deve ter entre 8 e 16 caracteres")
	private String password;
	
	public UserDTO() {
		
	}
	
	public UserDTO(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
}
