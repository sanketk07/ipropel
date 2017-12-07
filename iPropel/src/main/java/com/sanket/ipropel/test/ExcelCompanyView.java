package com.sanket.ipropel.test;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.sanket.ipropel.beans.Company;

public class ExcelCompanyView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map model, HSSFWorkbook workbook,
		HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		List<Company> companyList = (List<Company>) model.get("companyList");
		//create a wordsheet
		HSSFSheet sheet = workbook.createSheet("Revenue Report");

		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("Company Name");
		

		int rowNum = 1;
		/*for (Map.Entry<String, String> entry : companyList.entrySet()) {
			//create the row data
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(entry.getKey());
			row.createCell(1).setCellValue(entry.getValue());
                }*/
		
		for(Company c : companyList){
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(c.getCompanyName());
		}
	}
}
