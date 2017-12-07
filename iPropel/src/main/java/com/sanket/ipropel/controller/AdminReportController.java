package com.sanket.ipropel.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.sanket.ipropel.beans.Company;
import com.sanket.ipropel.beans.JobSeeker;
import com.sanket.ipropel.beans.User;
import com.sanket.ipropel.dao.CompanyDAO;
import com.sanket.ipropel.dao.UserDAO;

public class AdminReportController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
		HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		if(session != null){
		String output =	ServletRequestUtils.getStringParameter(request, "output");

		CompanyDAO cDao = new CompanyDAO();
		List<Company> companyList = cDao.fetchCompanyList();
		
		UserDAO uDao = new UserDAO();
		User u = (User)session.getAttribute("User");
		JobSeeker jobSeeker = uDao.fetchJobSeekerFromUserId(u.getId());

		if(output ==null || "".equals(output)){
		    //return normal view
		    return new ModelAndView("dashboardAdmin","companyList",companyList);

		}else if("PDF".equals(output.toUpperCase())){
			return new ModelAndView("PdfCompanySummary","companyList",companyList);

		}else if("PDF_RESUME".equals(output.toUpperCase())){
			return new ModelAndView("pdfResumeView","jobSeeker",jobSeeker);

		}else if("EXCEL".equals(output.toUpperCase())){
			//return excel view
			return new ModelAndView("ExcelCompanySummary","companyList",companyList);

		}else{
		    //return normal view
		    return new ModelAndView("dashboardAdmin","companyList",companyList);

		}
		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}
	}

}
