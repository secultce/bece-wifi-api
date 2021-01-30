package com.bece.wifi.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "visitors")
public class Visitor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@CreatedDate
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;
	
	@LastModifiedDate
	@Column(name = "updated_at")
	private Date updatedAt;
	
	public Visitor() {
		
	}
	
	public Visitor(String name, String cpf) {
		super();
		this.name = name;
		this.cpf = cpf;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
	private void prePersist() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	private void preUpdate() {
		this.updatedAt = new Date();
	}

	@Override
	public String toString() {
		return "Visitor [id=" + id + ", name=" + name + ", cpf=" + cpf + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}
	
}
