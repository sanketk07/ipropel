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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sanket.ipropel.beans.Company;
import com.sanket.ipropel.beans.Job;
import com.sanket.ipropel.beans.JobSeeker;
import com.sanket.ipropel.beans.Message;
import com.sanket.ipropel.beans.Recruiter;
import com.sanket.ipropel.beans.Skill;
import com.sanket.ipropel.beans.User;
import com.sanket.ipropel.dao.CompanyDAO;
import com.sanket.ipropel.dao.JobDAO;
import com.sanket.ipropel.dao.MessageDAO;
import com.sanket.ipropel.dao.SkillDAO;
import com.sanket.ipropel.dao.UserDAO;
import com.sanket.ipropel.utility.StringUtilities;
import com.sanket.ipropel.utility.UserUtility;

@Controller
/*@SessionAttributes({"jobsList","messageList"})*/
public class LoginController {

	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;

	@Autowired
	CompanyDAO companyDao;
	
	@Autowired
	MessageDAO messageDao;
	
	@Autowired
	UserUtility utility;
	
	@Autowired
	JobDAO jobDao;
	
	@Autowired
	SkillDAO skillDao;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response) {

		try {
			System.out.println("Inside displayLogin");
			userDao.loadNewData();
			return new ModelAndView("login");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}

	}

	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public ModelAndView authenticateUser(HttpServletRequest request, HttpServletResponse response, Model m) {
		try {
			System.out.println("Inside login submit");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			//testing fetch jobseeker by skill
			List<JobSeeker> jList = userDao.fetchJobSeekersBySkill("Java");
			System.out.println("printing job seeker list size: "+jList.size());	
			
			
			
			Map<String, Object> model = new HashMap<String, Object>();
			
			User user = userDao.authenticateUser(username, password);
			if (user != null) {
				HttpSession session = request.getSession();
				System.out.println("User exists - Checking instance");
				session.setAttribute("User", user);
				
				List<Message> messageList = messageDao.fetchUserMessages(user);
				for(Message msg : messageList){
					System.out.println("Message Time: "+ msg.getMessageReceivedTime());
				}
				session.setAttribute("messageList", messageList);

				if (user instanceof JobSeeker) {
					
					List<Job> jobsList = jobDao.fetchAvailableJObs();

					System.out.println("User - JobSeeker");
					session.setAttribute("Role", "JobSeeker");
					session.setAttribute("jobsList", jobsList);					
					
					User u = (User)session.getAttribute("User");
					JobSeeker js = userDao.fetchJobSeekerFromUserId(u.getId());
					
					boolean accountStatus = userDao.isUserAccountActive(js);
					if(accountStatus){
					
						//set last login
						userDao.setLastLoginTime(u);				
						
						model.put("user", session.getAttribute("User"));
						model.put("jobsList", session.getAttribute("jobsList"));
						model.put("messageList", session.getAttribute("messageList"));
						model.put("jobSeekerPhoto", js.getFilenamePhoto());
						session.setAttribute("jobSeekerPhoto", js.getFilenamePhoto());
						
						//return new ModelAndView("dashboard", "model", model);
						return new ModelAndView("dashboard", "model", model);
					}else{
						return new ModelAndView("login", "loginError", "Your Account has been suspended. Please contact the admin for re-activation!");
					}
					
				} else if (user instanceof Recruiter) {

					System.out.println("User - Recruiter");
					
					User u = (User)session.getAttribute("User");
					userDao.setLastLoginTimeRec(u);	
					
					session.setAttribute("Role", "Recruiter");
					return new ModelAndView("dashboardRecruiter", "user", session.getAttribute("User"));
				} else {

					System.out.println("User - Neither JobSeeker nor Recruiter, so Admin");
					session.setAttribute("Role", "Admin");
					return new ModelAndView("dashboardAdmin", "user", session.getAttribute("User"));
				}

			}

			else {
				System.out.println("no credentials found");
				return new ModelAndView("login", "loginError", "Invalid Credentials! Please try again");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ModelAndView("login", "loginError", "Please try again");
		}

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView redirectToHome(HttpServletRequest request, HttpServletResponse response) {
		try {

			userDao.loadNewData();
			return new ModelAndView("login");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}

	}

	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public ModelAndView logoutUser(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(false);
		if(session != null){
		
			try {
				System.out.println("Session ID before invalidating session: "+ request.getSession().getId());
				System.out.println("/logout.htm called");
				session = request.getSession();
				session.setAttribute("User", null);
				session.invalidate();
				System.out.println("Session ID after invalidating session: "+ request.getSession().getId());
	
				return new ModelAndView("login");
	
			} catch (Exception e) {
	
				System.out.println("Printing error in logout catch: ---" + e.getMessage());
				return new ModelAndView("error", "errorMessage", "No page to display");
			}
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}
		
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView redirectToRegisterPage(HttpServletRequest request, HttpServletResponse response) {
		try {

			List<Company> companiesList = companyDao.fetchCompanyList();			
			
			List<Skill> skillsList = skillDao.fetchSkillList();
			
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("companiesList", companiesList);
			model.put("skillsList", skillsList);
			
			return new ModelAndView("register", "model", model);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}

	}

	@RequestMapping(value = "/register.htm", method = RequestMethod.POST)
	public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response, String abc) {
		boolean isUserRegistered = false;
		boolean companyFlag = false;

		StringUtilities utility = new StringUtilities();

		try {
			System.out.println("In loginUser");
			String userRole = request.getParameter("userRole");

			if ((userRole).equalsIgnoreCase("jobseeker")) {
				String firstname = request.getParameter("firstname");
				String username = request.getParameter("username");
				String email = request.getParameter("email");
				String lastname = request.getParameter("lastname");
				String password = request.getParameter("password");
				String phone = request.getParameter("phone");
				String skill1 = request.getParameter("skill1");
				String skill2 = request.getParameter("skill2");
				String skill3 = request.getParameter("skill3");
				String aboutMe = request.getParameter("aboutMe");

				System.out.println(userRole + firstname + lastname + username + password + email + phone + aboutMe
						+ skill1 + skill2 + skill3);
				
				Skill skill_1 = skillDao.fetchSkillFromName(skill1);
				Skill skill_2 = skillDao.fetchSkillFromName(skill2);
				Skill skill_3 = skillDao.fetchSkillFromName(skill3);
				

				JobSeeker jobSeeker = new JobSeeker(firstname, lastname, username, password, email, phone, aboutMe,
						true, new Date());
				
				jobSeeker.addSkill(skill_1);
				jobSeeker.addSkill(skill_2);
				jobSeeker.addSkill(skill_3);				

				isUserRegistered = userDao.registerNewUser(jobSeeker);

			} else if ((userRole).equalsIgnoreCase("recruiter")) {
				String firstname = request.getParameter("firstnameR");
				String username = request.getParameter("usernameR");
				String emailRaw = request.getParameter("emailR");
				String lastname = request.getParameter("lastnameR");
				String password = request.getParameter("passwordR");
				String phone = request.getParameter("phoneR");
				String companyName = request.getParameter("companyName").toLowerCase();

				String email = utility.generateEmail(emailRaw, companyName);
				System.out.println("email after concatenation: " + email);

				// Company company = new Company("Google", "Software", "Leading
				// IT Firm");
				// retrieved company object based on company selection from UI
				Company c = companyDao.fetchCompanyFromCompanyName(companyName);
				System.out.println("company in controller --> " + c);

				// Passed the retrieved company object to recruiter constructor
				Recruiter recruiter = new Recruiter(firstname, lastname, username, password, email, phone, "HR", true,
						new Date());
				recruiter.setCompanyName(c);
				isUserRegistered = userDao.registerNewUser(recruiter);
			}

			if (isUserRegistered) {

				return new ModelAndView("login");
			} else {
				return new ModelAndView("error", "registrationError", "Some error occured. Please try again.");
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}

	}
	
	@RequestMapping(value = "/getMessagesPagination.htm", method = RequestMethod.GET, produces = "text/plain", headers="Accept=application/json")
	@ResponseBody
	public List<Message> getMessageListPagination(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session != null){
			
			try {
				// CompanyDAO cDAO = new CompanyDAO();
				session = request.getSession();
				User u = (User)session.getAttribute("User");
				
				int dataPageNo =Integer.parseInt(request.getParameter("pageNo"));
				System.out.println("dataPageNo--"+ dataPageNo);
				System.out.println("Print Time: "+ new Date());
				
				List<Message> messages = messageDao.fetchUserMessagesPagination(u, dataPageNo);
				session.setAttribute("messageListForPagination", messages);
				System.out.println("messageListForPagination"+ session.getAttribute("messageListForPagination"));

				for (Message m : messages) {
					System.out.println("time:" + m.getMessageReceivedTime() + "-- content: "+ m.getReceivedMessage());

				}
				return messages;

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		
		
		}else{
			System.out.println("Session does not exist!");
			return null;
		}
		
		

	}
	
	@RequestMapping(value = "/getSkills.htm", method = RequestMethod.GET, produces = "text/plain", headers = "Accept=*/*")
	@ResponseBody
	public List<Skill> getSkillsList(HttpServletRequest request, HttpServletResponse response) {
		try {
			// CompanyDAO cDAO = new CompanyDAO();
			List<Skill> skills = skillDao.fetchSkillList();

			for (Skill s : skills) {
				 System.out.println("Skill DAO - Skill Name:"+ s.getSkillName()); 
			}
			return skills;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	
}
