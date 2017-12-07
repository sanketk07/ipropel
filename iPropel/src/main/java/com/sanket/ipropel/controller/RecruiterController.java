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
import com.sanket.ipropel.utility.DateUtility;
import com.sanket.ipropel.utility.UserUtility;

@Controller
public class RecruiterController {

	@Autowired
	UserDAO userDao;

	@Autowired
	CompanyDAO companyDao;

	@Autowired
	JobDAO jobDao;
	
	@Autowired
	MessageDAO messageDao;
	
	@Autowired
	UserUtility utility;
	
	@Autowired
	SkillDAO skillDao;
	
	@RequestMapping(value = "/viewRecDashboard.htm", method = RequestMethod.GET)
	public ModelAndView viewDashboard(HttpServletRequest request, HttpServletResponse response) {
		try {
			return new ModelAndView("dashboardRecruiter");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}

	}

	@RequestMapping(value = "/redirectToCreateJobPage", method = RequestMethod.GET)
	public ModelAndView redirectToCreateJobPage(HttpServletRequest request, HttpServletResponse response) {
		try {

			return new ModelAndView("createJobListing");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}

	}

	@RequestMapping(value = "/redirectToChooseSkill", method = RequestMethod.GET)
	public ModelAndView redirectToChooseSkill(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			List<Skill> skillsList = skillDao.fetchSkillList();
			return new ModelAndView("chooseSkillToViewApplicants","skillsList", skillsList);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}

	}

	
	@RequestMapping(value = "/createNewJob.htm", method = RequestMethod.POST)
	public ModelAndView createNewJobListing(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		boolean jobCreatedFlag = false;
		try {

			String jobTitle = request.getParameter("jobTitle");
			String jobLocation = request.getParameter("jobLocation");
			Double jobSalary = Double.parseDouble(request.getParameter("jobSalary"));
			String jobCategory = request.getParameter("jobCategory");
			String jobDescription = request.getParameter("jobDescription");

			User user = (User) session.getAttribute("User");
			int userId = user.getId();
			System.out.println("User ID from session in createNewJobListing");

			Recruiter recruiter = userDao.fetchRecruiterFromUserId(userId);
			System.out.println("Recruiter object in createNewJobListing ----> " + recruiter);

			Job job = new Job(jobTitle, jobDescription, jobLocation, jobSalary, jobCategory, new Date(),
					DateUtility.returnIncrementedDate(10), recruiter);

			jobCreatedFlag = jobDao.createJob(job);

			if (jobCreatedFlag) {
				return new ModelAndView("viewCreatedJobs");
			} else {
				return new ModelAndView("error");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}

	}
	
	@RequestMapping(value = "/viewMyCreatedJobs.htm", method = RequestMethod.GET)
	public ModelAndView viewMyCreatedJobs(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("User");
			
			Recruiter recruiter = userDao.fetchRecruiterFromUserId(user.getId());
			
			List<Job> jobsByLoggedInRecruiter = userDao.jobsCreatedByRecruiter(recruiter);
			
			System.out.println("Jobs by recruiter size: "+ jobsByLoggedInRecruiter.size());
			

			return new ModelAndView("viewCreatedJobs", "jobsByLoggedInRecruiter", jobsByLoggedInRecruiter);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}

	}
	
	@RequestMapping(value = "/viewJobSeekersByJobsRecruiter.htm", method = RequestMethod.GET)
	public ModelAndView viewJobSeekersByJobsRecruiter(HttpServletRequest request, HttpServletResponse response) {
		try {

			//Map<String, Object> model = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("User");
			
			Recruiter recruiter = userDao.fetchRecruiterFromUserId(user.getId());
			
			List<Job> jobsByLoggedInRecruiter = userDao.jobsCreatedByRecruiter(recruiter);
			
			/*ArrayList<JobSeeker> activeJobSeekersList = userDao.fetchActiveJobSeekers();*/
			
			
			/*System.out.println("jobSeekersList's size --> " + activeJobSeekersList.size());*/

			for (Job j : jobsByLoggedInRecruiter) {
				System.out.println("Job ID: " + j.getJobId());
				System.out.println("Job Title: " + j.getJobTitle());
				System.out.println("--------------------");

			}
			
			//model.put("jobsByLoggedInRecruiter", jobsByLoggedInRecruiter);
			/*model.put("inactiveJobSeekersList", inactiveJobSeekersList);*/
			
			return new ModelAndView("viewCreatedJobs", "jobsByLoggedInRecruiter", jobsByLoggedInRecruiter);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}

	}
	
	@RequestMapping(value = "/viewJobSeekersBySkillsRecruiter.htm", method = RequestMethod.POST)
	public ModelAndView viewJobSeekersBySkillsRecruiter(HttpServletRequest request, HttpServletResponse response) {
		try {

			Map<String, Object> model = new HashMap<String, Object>();
			
			String skill = request.getParameter("chooseSkillToViewApplicants");
			
			ArrayList<JobSeeker> jobSeekersBySkillList = userDao.fetchJobSeekersBySkill(skill);
			/*ArrayList<JobSeeker> inactiveJobSeekersList = userDao.fetchInactiveJobSeekers();*/
			
			System.out.println("jobSeekersList's size by skills for skill --> " + skill+ "----"+  jobSeekersBySkillList.size());

			for (JobSeeker js : jobSeekersBySkillList) {
				System.out.println("Name: " + js.getFirstName() + js.getLastName());
				System.out.println("Email: " + js.getEmail());

			}
			
			model.put("jobSeekersBySkillList", jobSeekersBySkillList);
			model.put("skillName", skill);
			
			return new ModelAndView("viewApplicantsBySkills", "model", model);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}

	}
	
	@RequestMapping(value = "/viewApplicantsForJob.htm", method = RequestMethod.POST)
	public ModelAndView viewApplicantsForJob(HttpServletRequest request, HttpServletResponse response) {
		try {

			Map<String, Object> model = new HashMap<String, Object>();
			
			int jobId = Integer.parseInt(request.getParameter("jobIdForApplicants"));
						
			ArrayList<JobSeeker> jobSeekersForJob = jobDao.fetchJobApplicants(jobId);
			/*ArrayList<JobSeeker> inactiveJobSeekersList = userDao.fetchInactiveJobSeekers();*/
			
			System.out.println("jobSeekersList's for " + jobId + "size --> " + jobSeekersForJob.size());

			for (JobSeeker js : jobSeekersForJob) {
				System.out.println("Name: " + js.getFirstName() + js.getLastName());
				System.out.println("Email: " + js.getEmail());

			}
			
			model.put("jobSeekersForJob", jobSeekersForJob);
			/*model.put("inactiveJobSeekersList", inactiveJobSeekersList);*/
			
			return new ModelAndView("viewApplicantsByJobs", "model", model);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}

	}
	
	
	
	
	
	@RequestMapping(value = "/sendMessageRecruiter.htm", method = RequestMethod.POST)
	public ModelAndView sendMessageRecruiter(HttpServletRequest request, HttpServletResponse response) {
		try {

			String recipientEmail = request.getParameter("recipientEmail");
			
			return new ModelAndView("sendMessageRecruiter", "recipientEmail", recipientEmail);

		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("error", "errorMessage", "No page to display");
		}

	}
	
	//send message for admin
	@RequestMapping(value = "/sendMessageFromRecruiter.htm", method = RequestMethod.GET)
	public ModelAndView sendMessageFromRecruiter(HttpServletRequest request, HttpServletResponse response) {
		try {

			
			
			return new ModelAndView("sendMessageRecruiter");

		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("error", "errorMessage", "No page to display");
		}

	}
	
	@RequestMapping(value = "/viewMessagesRecruiter.htm", method = RequestMethod.GET)
	public ModelAndView viewMessagesRecruiter(HttpServletRequest request, HttpServletResponse response) {
		try {

			
			return new ModelAndView("viewMessagesRecruiter");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}

	}
	
	@RequestMapping(value = "/messageFromRecruiter.htm", method = RequestMethod.POST)
	public ModelAndView sendMessageToUser(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		try {
			
			String userEmail = request.getParameter("userEmail");
			String userMessageFromRecruiter = request.getParameter("userMessageFromRecruiter");
			
			System.out.println("Printing session object in controller---"+ session.getId());
			//String senderEmail = utility.getLoggedInUserEmail();
			
			User u = (User) session.getAttribute("User");
			String sEmail = u.getEmail();
			
			Message message = new Message(sEmail, userEmail, new Date(), userMessageFromRecruiter);
			
			boolean isMessageSent = messageDao.sendMessage(message);
			
			ArrayList<JobSeeker> activeJobSeekersList = userDao.fetchActiveJobSeekers();
			System.out.println("jobSeekersList's size --> " + activeJobSeekersList.size());

			for (JobSeeker js : activeJobSeekersList) {
				System.out.println("Name: " + js.getFirstName() + js.getLastName());
				System.out.println("Email: " + js.getEmail());

			}	
			
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("activeJobSeekersList", activeJobSeekersList);
			
			if(isMessageSent){
				return new ModelAndView("viewApplicantsByJobs", "model", model);
			}else{
				return new ModelAndView("sendMessageAdmin", "messageFlag", false);
			}				

		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("error", "errorMessage", "No page to display");
		}

	}
	
	@RequestMapping(value = "/viewReceivedMessagesRecruiter.htm", method = RequestMethod.GET)
	public ModelAndView viewReceivedMessagesRecruiter(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("User");
		try {
			List<Message> messageList = messageDao.fetchUserMessages(user);

			for (Message m : messageList) {
				System.out.println("title:" + m.getMessageRecipient());
				System.out.println("title:" + m.getMessageSender());
				System.out.println("title:" + m.getMessageReceivedTime());
				System.out.println("title:" + m.getReceivedMessage());
				System.out.println("-----------------------");

			}
			
			return new ModelAndView("viewMessagesRecruiter", "messageList", messageList);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}
	
	@RequestMapping(value = "/viewFullApplicantProfile.htm", method = RequestMethod.POST)
	public ModelAndView viewFullApplicantProfile(HttpServletRequest request, HttpServletResponse response) {
		
		//HttpSession session = request.getSession();
		//User user = (User) session.getAttribute("User");
		String applicantEmail = request.getParameter("applicantEmail");
		
		try {
			JobSeeker jobSeeker = userDao.fetchJobSeekerFromUserEmail(applicantEmail);
			
			User u = userDao.fetchUserFromJobSeekerEmail(jobSeeker);
			
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("jobSeeker", jobSeeker);
			model.put("user", u);
			/*List<Message> messageList = messageDao.fetchUserMessages(user);

			for (Message m : messageList) {
				System.out.println("title:" + m.getMessageRecipient());
				System.out.println("title:" + m.getMessageSender());
				System.out.println("title:" + m.getMessageReceivedTime());
				System.out.println("title:" + m.getReceivedMessage());
				System.out.println("-----------------------");

			}
*/			
			return new ModelAndView("viewApplicantProfileRecruiter", "model", model);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}
	
	

}
