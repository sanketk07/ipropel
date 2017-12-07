package com.sanket.ipropel.test;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.sanket.ipropel.beans.Company;

public class PdfCompanyView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map model, Document document,
		PdfWriter writer, HttpServletRequest request,
		HttpServletResponse response) throws Exception {

		Map<String,String> revenueData = (Map<String,String>) model.get("revenueData");
		
		List<Company> companyList = (List<Company>) model.get("companyList");

		Table table = new Table(1);
		table.addCell("Company Name");
		

		/*for (Map.Entry<String, String> entry : revenueData.entrySet()) {
			table.addCell(entry.getKey());
			table.addCell(entry.getValue());}
        */
		
		for(Company c : companyList){
			table.addCell(c.getCompanyName());
		}

		document.add(table);
	}
	
	
	
}
