package com.bece.wifi.api.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "vouchers")
public class Voucher {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "visitor_id")
	private Visitor visitorId = null;
	
	@Column(unique = true)
	private String voucher;
	
	@Column(columnDefinition = "boolean default true")
	private Boolean active;
	
	@CreatedDate
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;
	
	@LastModifiedDate
	@Column(name = "updated_at")
	private Date updatedAt;
	
	public Voucher() {
		
	}
	
	public Voucher(String voucher) {
		this.voucher = voucher;
	}
	
	
}
