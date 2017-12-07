package com.sanket.ipropel.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sanket.ipropel.beans.Company;
import com.sanket.ipropel.beans.JobSeeker;
import com.sanket.ipropel.beans.Message;
import com.sanket.ipropel.beans.Recruiter;
import com.sanket.ipropel.dao.CompanyDAO;
import com.sanket.ipropel.dao.MessageDAO;
import com.sanket.ipropel.dao.UserDAO;
import com.sanket.ipropel.utility.UserUtility;

@Controller
public class AdminController {

	@Autowired
	UserDAO userDao;

	@Autowired
	CompanyDAO companyDao;
	
	@Autowired
	MessageDAO messageDao;
	
	@Autowired
	UserUtility utility;

	@RequestMapping(value = "/viewDashboardAdmin.htm", method = RequestMethod.GET)
	public ModelAndView viewDashboard(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session != null){
			try {

				return new ModelAndView("dashboardAdmin");

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", "errorMessage", "No page to display");
			}
		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}
	}

	@RequestMapping(value = "/addCompany.htm", method = RequestMethod.GET)
	public ModelAndView addCompany(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session != null){
			try {

				return new ModelAndView("addCompany");

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", "errorMessage", "No page to display");
			}
		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}
		

	}

	@RequestMapping(value = "/createNewCompany.htm", method = RequestMethod.POST)
	public ModelAndView createNewCompany(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		if(session != null){
			boolean companyFlag = false;
			try {
				String companyName = request.getParameter("companyName");
				String companyIndustry = request.getParameter("companyIndustry");
				String companyDescription = request.getParameter("companyDescription");

				System.out.println("Form values - create company --> " + companyName + companyIndustry + companyDescription);

				Company company = new Company(companyName, companyIndustry, companyDescription);
				companyFlag = companyDao.saveCompany(company);

				if (companyFlag) {
					return new ModelAndView("dashboardAdmin");
				} else {
					return new ModelAndView("error", "errorMessage", "No page to display");
				}

			} catch (Exception e) {
				e.printStackTrace();
				companyFlag = false;
				return new ModelAndView("error", "errorMessage", "No page to display");
			}

		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}
		
	}

	@RequestMapping(value = "/viewJobSeekers.htm", method = RequestMethod.GET)
	public ModelAndView viewJobSeekers(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session != null){
			try {

				Map<String, Object> model = new HashMap<String, Object>();
				
				ArrayList<JobSeeker> activeJobSeekersList = userDao.fetchActiveJobSeekers();
				ArrayList<JobSeeker> inactiveJobSeekersList = userDao.fetchInactiveJobSeekers();
				
				for (JobSeeker js : activeJobSeekersList) {
					System.out.println("Name: " + js.getFirstName() + js.getLastName());
					System.out.println("Email: " + js.getEmail());

				}
				
				model.put("activeJobSeekersList", activeJobSeekersList);
				model.put("inactiveJobSeekersList", inactiveJobSeekersList);
				
				return new ModelAndView("viewJobSeekersAdmin", "model", model);

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", "errorMessage", "No page to display");
			}
		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}
		
	}

	@RequestMapping(value = "/viewRecruiters.htm", method = RequestMethod.GET)
	public ModelAndView viewRecruiters(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if(session != null){
			try {

				ArrayList<Recruiter> recruitersList = userDao.fetchRecruiters();
				System.out.println("jobSeekersList's size --> " + recruitersList.size());

				for (Recruiter r : recruitersList) {
					System.out.println("Name: " + r.getFirstName() + r.getLastName());
					System.out.println("Email: " + r.getEmail());

				}

				return new ModelAndView("viewRecruitersAdmin", "recruitersList", recruitersList);

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", "errorMessage", "No page to display");
			}
		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}
		
		

	}

	@RequestMapping(value = "/viewCompanies.htm", method = RequestMethod.GET)
	public ModelAndView viewCompanies(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session != null){
			try {

				List<Company> companyList = companyDao.fetchCompanyList();
				System.out.println("companyList's size --> " + companyList.size());

				for (Company c : companyList) {
					System.out.println("Company Name: " + c.getCompanyName());
					System.out.println("ID: " + c.getCompanyId());
					System.out.println("Industry: " + c.getIndustry());
					System.out.println("Company Description: " + c.getCompanyDescription());
					System.out.println("------------------------------------");

				}

				return new ModelAndView("viewCompaniesAdmin", "companyList", companyList);

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", "errorMessage", "No page to display");
			}
		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}
		

	}
	
	
	@RequestMapping(value = "/messageJobSeeker.htm", method = RequestMethod.POST)
	public ModelAndView messageJobSeeker(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session != null){
			try {
				String recipientEmail = request.getParameter("recipientEmail");
				return new ModelAndView("sendMessageAdmin", "recipientEmail", recipientEmail);

			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("error", "errorMessage", "No page to display");
			}
		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}		
	}
	
	//send message for admin
	@RequestMapping(value = "/sendMessageAdmin.htm", method = RequestMethod.GET)
	public ModelAndView messageJobSeekerMenu(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session != null){
			try {
				return new ModelAndView("sendMessageAdmin");

			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("error", "errorMessage", "No page to display");
			}
		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}
	}
	
	@RequestMapping(value = "/viewMessagesAdmin.htm", method = RequestMethod.GET)
	public ModelAndView viewMessagesAdmin(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if(session != null){
			try {
				return new ModelAndView("viewMessagesAdmin");

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", "errorMessage", "No page to display");
			}
		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}
		
	}
	
	@RequestMapping(value = "/sendMessageToUser.htm", method = RequestMethod.POST)
	public ModelAndView sendMessageToUser(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session != null){
			try {
				
				String userEmail = request.getParameter("userEmail");
				String userMessageFromAdmin = request.getParameter("userMessageFromAdmin");
				
				System.out.println("Printing session object in controller---"+ session.getId());
				String senderEmail = utility.getLoggedInUserEmail();
				
				Message message = new Message(senderEmail, userEmail, new Date(), userMessageFromAdmin);
				
				boolean isMessageSent = messageDao.sendMessage(message);
				
				ArrayList<JobSeeker> jobSeekersList = userDao.fetchJobSeekers();
				System.out.println("jobSeekersList's size --> " + jobSeekersList.size());

				for (JobSeeker js : jobSeekersList) {
					System.out.println("Name: " + js.getFirstName() + js.getLastName());
					System.out.println("Email: " + js.getEmail());

				}			
				
				if(isMessageSent){
					return new ModelAndView("viewJobSeekersAdmin", "jobSeekersList", jobSeekersList);
				}else{
					return new ModelAndView("sendMessageAdmin", "messageFlag", false);
				}				

			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("error", "errorMessage", "No page to display");
			}

		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}
	}
	
	//deactivate user account
	@RequestMapping(value = "/deactivateJobSeeker.htm", method = RequestMethod.POST)
	public ModelAndView deactivateJobSeekerAccount(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session != null){
			try {
				
				String jobSeekerEmail = request.getParameter("recipientEmail");
				
				JobSeeker jobSeeker = userDao.fetchJobSeekerFromUserEmail(jobSeekerEmail);
				
				boolean isAccountDisabled = userDao.deactivateJobSeekerAccount(jobSeeker);
				
				Map<String, Object> model = new HashMap<String, Object>();
				
				ArrayList<JobSeeker> activeJobSeekersList = userDao.fetchActiveJobSeekers();
				ArrayList<JobSeeker> inactiveJobSeekersList = userDao.fetchInactiveJobSeekers();
				
				model.put("activeJobSeekersList", activeJobSeekersList);
				model.put("inactiveJobSeekersList", inactiveJobSeekersList);	

				
				if(isAccountDisabled){
					return new ModelAndView("viewJobSeekersAdmin", "model", model);
				}else{
					return new ModelAndView("sendMessageAdmin", "messageFlag", false);
				}				

			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("error", "errorMessage", "No page to display");
			}

		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}		
		
	}
	
	//re-activate user account
	@RequestMapping(value = "/activateJobSeeker.htm", method = RequestMethod.POST)
	public ModelAndView activateJobSeekerAccount(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session != null){
			try {
				
				String jobSeekerEmail = request.getParameter("recipientEmail");
				
				JobSeeker jobSeeker = userDao.fetchJobSeekerFromUserEmail(jobSeekerEmail);
				
				boolean isAccountEnabled = userDao.activateJobSeekerAccount(jobSeeker);
				
				Map<String, Object> model = new HashMap<String, Object>();
				
				ArrayList<JobSeeker> activeJobSeekersList = userDao.fetchActiveJobSeekers();
				ArrayList<JobSeeker> inactiveJobSeekersList = userDao.fetchInactiveJobSeekers();
				
				model.put("activeJobSeekersList", activeJobSeekersList);
				model.put("inactiveJobSeekersList", inactiveJobSeekersList);	
				
				if(isAccountEnabled){
					return new ModelAndView("viewJobSeekersAdmin", "model", model);
				}else{
					return new ModelAndView("sendMessageAdmin", "messageFlag", false);
				}				

			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("error", "errorMessage", "No page to display");
			}
		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}

	}
	

}
