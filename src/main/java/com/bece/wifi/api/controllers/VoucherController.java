package com.bece.wifi.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bece.wifi.api.services.UploadVoucher;

@RestController
@RequestMapping(value = "/vouchers")
public class VoucherController {
	
	@Autowired
	private UploadVoucher uploadVoucher;

	@RequestMapping(method = RequestMethod.POST, value = "/upload")
	public String upload(@RequestParam MultipartFile file) {
		this.uploadVoucher.execute(file);
		
		return "VoucherController";
	}
}
