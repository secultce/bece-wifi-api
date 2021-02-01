package com.bece.wifi.api.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.bece.wifi.api.dto.VoucherDTO;

public class CSVUtil {
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "name" };
	
	public static boolean hasCSVFormat(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		
		return true;
	}
	
	public static List<VoucherDTO> csvToVouchers(InputStream is) {
		try {

			BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			
			List<VoucherDTO> vouchersDTO = new ArrayList<VoucherDTO>();

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				VoucherDTO tutorial = new VoucherDTO(csvRecord.get("name"));

				vouchersDTO.add(tutorial);
			}

			return vouchersDTO;
	    } catch (IOException e) {
	    	throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	}
}
