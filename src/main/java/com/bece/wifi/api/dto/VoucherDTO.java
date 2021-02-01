package com.bece.wifi.api.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class VoucherDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Nome é obrigatório")
	private String name;
	
	public VoucherDTO() {
		
	}
	
	public VoucherDTO(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
