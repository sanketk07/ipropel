package com.sanket.ipropel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.velocity.context.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sanket.ipropel.beans.Company;
import com.sanket.ipropel.dao.CompanyDAO;

@Controller
public class VelocityController {
	
	@Autowired
	CompanyDAO cDao;

	@RequestMapping(value =  "/velocityView", method = RequestMethod.GET)
	   public String welcomePage(Model model,HttpServletRequest request, HttpServletResponse response) {
	       List<Company> list = null;
		try {
			list = cDao.fetchCompanyList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	       model.addAttribute("companies", list);
	      
	       return "index";
	   }
}
