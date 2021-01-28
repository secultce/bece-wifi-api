package com.bece.wifi.api.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.bece.wifi.api.entities.Visitor;

public class VisitorDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Nome obrigatório")
	private String name;
	
	@NotEmpty(message = "CPF obrigatório")
	@CPF(message = "CPF inválido")
	private String cpf;
	
	public VisitorDTO() {
		
	}
	
	public VisitorDTO(Visitor visitor) {
		this.id = visitor.getId();
		this.name = visitor.getName();
		this.cpf = visitor.getCpf();
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
