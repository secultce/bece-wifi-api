package com.bece.wifi.api.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bece.wifi.api.dto.VoucherDTO;
import com.bece.wifi.api.entities.Voucher;
import com.bece.wifi.api.repositories.VoucherRepository;
import com.bece.wifi.api.utils.CSVUtil;

@Service
public class UploadVoucher {
	
	@Autowired
	private VoucherRepository voucherRepository;

	public void execute(MultipartFile file) {
		try {
			List<VoucherDTO> vouchersDTO = CSVUtil.csvToVouchers(file.getInputStream());
			
			for (VoucherDTO item: vouchersDTO) {
				Voucher v = new Voucher(item.getName());
				this.voucherRepository.save(v);
			}
			
		} catch (IOException e) {
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}
}
