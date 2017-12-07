package com.sanket.ipropel.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sanket.ipropel.beans.Company;
import com.sanket.ipropel.beans.Job;
import com.sanket.ipropel.beans.JobSeeker;
import com.sanket.ipropel.beans.Message;
import com.sanket.ipropel.beans.User;
import com.sanket.ipropel.dao.CompanyDAO;
import com.sanket.ipropel.dao.JobDAO;
import com.sanket.ipropel.dao.MessageDAO;
import com.sanket.ipropel.dao.UserDAO;
import com.sanket.ipropel.utility.UserUtility;

@Controller
public class JobSeekerController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private CompanyDAO companyDao;

	@Autowired
	private JobDAO jobDao;
	
	@Autowired
	private MessageDAO messageDao;
	
	@Autowired
	private UserUtility utility;
	
	@Autowired
	private JobSeeker jobSeeker;
	
	@Autowired
	ServletContext servletContext;

	@RequestMapping(value = "/viewAppliedJobs.htm", method = RequestMethod.GET)
	public ModelAndView viewAppliedJobs(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		if(session != null){
			try {
				Object user = session.getAttribute("User");
				User u = (User) user;

				List<Job> appliedJobsList = userDAO.fetchAppliedJobs(u.getId());
				System.out.println("appliedJobsList: ---"+ appliedJobsList);
				for(Job j : appliedJobsList){
					System.out.println(j.getJobTitle());
				}

				if (!(appliedJobsList.isEmpty())) {
					return new ModelAndView("appliedJobs", "appliedJobsList", appliedJobsList);
				} else {
					return new ModelAndView("appliedJobs");
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

	@RequestMapping(value = "/viewAllJobs.htm", method = RequestMethod.GET)
	public ModelAndView viewAllJobs(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(false);
		if(session != null){
			try {

				List<Job> jobsList = jobDao.fetchAvailableJObs();

				for (Job j : jobsList) {
					System.out.println("jobTitle: " + j.getJobTitle());
					System.out.println("jobDescription: " + j.getJobDescription());
					System.out.println("jobLocation: " + j.getJobLocation());
					System.out.println("jobSalary: " + j.getJobSalary());
					System.out.println("jobPostedOn: " + j.getJobPostedOn());
					System.out.println("jobExpiresOn: " + j.getJobExpiresOn());
					System.out.println("--------------------------");
				}

				return new ModelAndView("availableJobs", "jobsList", jobsList);

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", "errorMessage", "No page to display");
			}


		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}
	}

	@RequestMapping(value = "/viewProfile.htm", method = RequestMethod.GET)
	public ModelAndView viewProfile(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if(session != null){
			try {
			
			Map<String, Object> model = new HashMap<String, Object>();
			List<Job> jobsList = jobDao.fetchAvailableJObs();
			
			if(session.getAttribute("User")!=null){
				System.out.println("User object in viewProfile--"+session.getAttribute("User"));
				model.put("user", session.getAttribute("User"));
			}
			
			model.put("jobsList", jobsList);
			return new ModelAndView("viewProfile", "model", model);

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", "errorMessage", "No page to display");
			}

		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}
	}

	@RequestMapping(value = "/editProfile.htm", method = RequestMethod.GET)
	public ModelAndView editProfile(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(false);
		if(session != null){
			try {

				return new ModelAndView("editProfile");

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", "errorMessage", "No page to display");
			}
		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}
		
		
	}

	@RequestMapping(value = "/updateSeekerProfile.htm", method = RequestMethod.GET)
	public ModelAndView updateProfile(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session != null){
			try {

				return new ModelAndView("actionSuccessful");

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", "errorMessage", "No page to display");
			}
		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}
		
	}

	@RequestMapping(value = "/viewDashboard.htm", method = RequestMethod.GET)
	public ModelAndView viewDashboard(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session != null){
			try {
				return new ModelAndView("dashboard");

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", "errorMessage", "No page to display");
			}

		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}
	}

	/*@RequestMapping(value = "/uploadResumePage.htm", method = RequestMethod.GET)
	public ModelAndView redirectToUploadResumePage(HttpServletRequest request, HttpServletResponse response) {
		try {

			return new ModelAndView("uploadResumePage");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "No page to display");
		}

	}*/

	@RequestMapping(value = "/uploadResume.htm", method = RequestMethod.GET)
	public ModelAndView uploadResume(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session != null){
			try {

				return new ModelAndView("actionSuccessful");

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", "errorMessage", "No page to display");
			}
		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}

	}

	@RequestMapping(value = "/generateResumePage.htm", method = RequestMethod.GET)
	public ModelAndView redirectToGenerateResumePage(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session != null){
			try {

				return new ModelAndView("generateResumePage");

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", "errorMessage", "No page to display");
			}
		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}
		
	}

	@RequestMapping(value = "/generateResume.htm", method = RequestMethod.POST)
	public ModelAndView generateResume(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session != null){
			try {

				return new ModelAndView("actionSuccessful");

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", "errorMessage", "No page to display");
			}
		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}
		
	}
	
	@RequestMapping(value = "/viewResume.htm", method = RequestMethod.GET)
	public ModelAndView viewResumePage(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if(session != null){
			try {

				User u = (User) session.getAttribute("User");
				JobSeeker js = userDAO.fetchJobSeekerFromUserId(u.getId());
				System.out.println("File path in controller ---"+ js.getFilenameResume());
				return new ModelAndView("viewResume","resumeLink", js.getFilenameResume());

			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("error", "errorMessage", "No page to display");
			}
		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}

	}
	
	//ResponseBody, produces = "text/plain" and headers = "Accept=*/*" for returning the list of companies to Angular controller
	@RequestMapping(value = "/getCompanies.htm", method = RequestMethod.GET, produces = "text/plain", headers = "Accept=*/*")
	@ResponseBody
	public List<Company> getCompanyList(HttpServletRequest request, HttpServletResponse response) {
		try {
			// CompanyDAO cDAO = new CompanyDAO();
			List<Company> companies = companyDao.fetchCompanyList();

			for (Company c : companies) {
				System.out.println("title:" + c.getCompanyName());

			}
			System.out.println("printing first company name" + companies.get(0).getCompanyName());
			return companies;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	@RequestMapping(value = "/applyJob.htm", method = RequestMethod.POST)
	public ModelAndView applyJob(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session != null){
			try {

				String applliedJobId = request.getParameter("applliedJobId");

				Job job = jobDao.fetchJobFromId(applliedJobId);
				System.out.println("printing fetched job: " + job.getJobDescription());

				Object user = session.getAttribute("User");
				User u = (User) user;
				System.out.println("printing casted user: " + u.getFirstName());

				JobSeeker jobSeeker = userDAO.fetchJobSeekerFromUserId(u.getId());
				
				/*jobSeeker.addJobToAppliedJobsList(job);
				System.out.println("Job Id being added to job seeker list: "+ job.getJobId());
				System.out.println("Job Seeker's jobs: "+ jobSeeker.getAppliedJobsList());

				boolean jobApplied = userDAO.saveJobSeekerDetails(jobSeeker);

				if (jobApplied) {
					System.out.println("Job Applied successfully");
				} else {
					System.out.println("Error in applying for Job");
				}*/
				
				boolean jobApplicationInJobDao = jobDao.applyForAvailableJobs(jobSeeker, job.getJobId());
				System.out.println("jobApplicationInJobDao in controller:"+ jobApplicationInJobDao);

				return new ModelAndView("appliedJobs", "appliedJobsList", jobSeeker.getAppliedJobsList());

			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("error", "errorMessage", "No page to display");
			}
		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}
		
		
	}
	
	@RequestMapping(value = "/viewReceivedMessages.htm", method = RequestMethod.GET)
	public ModelAndView getUserMessages(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session != null){
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
				
				return new ModelAndView("viewMessagesJobSeeker", "messageList", messageList);

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}

		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}
		
	}
	
	@RequestMapping(value = "/sendMessagePage.htm", method = RequestMethod.POST)
	public ModelAndView sendMessagePage(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session != null){
			try {
				String replyEmail = request.getParameter("replyEmail");
				return new ModelAndView("sendMessageJobSeeker", "replyEmail", replyEmail);

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", "errorMessage", "No page to display");
			}
		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}

	}
	
	@RequestMapping(value = "/sendMessagePageMenu.htm", method = RequestMethod.GET)
	public ModelAndView sendMessagePageMenu(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session != null){
			try {
				return new ModelAndView("sendMessageJobSeeker");

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", "errorMessage", "No page to display");
			}
		
		}else{
			System.out.println("Session does not exist!");
			return new ModelAndView("login");
		}
		
	}
	
	@RequestMapping(value = "/sendMessageJobSeeker.htm", method = RequestMethod.POST)
	public ModelAndView sendMessageToUser(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		if(session != null){
			User user = (User) session.getAttribute("User");
			try {
				
				String replyEmail = request.getParameter("replyEmail");
				String userMessageFromJobSeeker = request.getParameter("userMessageFromJobSeeker");
				
				System.out.println("Printing session object in job seeker controller---"+ session.getId());
				String senderEmail = utility.getLoggedInUserEmail();
				
				Message message = new Message(senderEmail, replyEmail, new Date(), userMessageFromJobSeeker);
				
				boolean isMessageSent = messageDao.sendMessage(message);
				
				List<Message> messageList = messageDao.fetchUserMessages(user);

				for (Message m : messageList) {
					System.out.println("title:" + m.getMessageRecipient());
					System.out.println("title:" + m.getMessageSender());
					System.out.println("title:" + m.getMessageReceivedTime());
					System.out.println("title:" + m.getReceivedMessage());
					System.out.println("-----------------------");

				}			
				
				if(isMessageSent){
					return new ModelAndView("viewMessagesJobSeeker", "messageList", messageList);
				}else{
					return new ModelAndView("sendMessageJobSeeker", "messageFlag", false);
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
	
	
	//first you need to set command object using GET request. then
	//access it using POST
	@RequestMapping(value = "/uploadResumePage.htm", method = RequestMethod.GET)
		public String uploadResumeForm(ModelMap model, HttpServletRequest request) {
			
			HttpSession session = request.getSession();
			if(session != null){
				try{
					System.out.println("Navigating to uploadResume");
					// command object
					model.addAttribute("jobSeekerModel", jobSeeker);
					// return form view
					return "uploadResumePage";
					
					
				}catch(Exception e)
				{
					e.printStackTrace();
					
					model.addAttribute("errorMessage", "No page to display");
					return "error";
				}
				
			
			}else{
				System.out.println("Session does not exist!");
				return "login";
			}
			
		}

	//the post method

	@RequestMapping(value = "/uploadResume.htm", method = RequestMethod.POST)
		public String uploadResume(ModelMap model, @ModelAttribute("jobSeekerModel") JobSeeker jobSeekerModel,  BindingResult result, HttpServletRequest request) {
			
			HttpSession session = request.getSession();
			if(session != null){
				try{
					
					String uploadedFileName = jobSeekerModel.getProfileResume().getOriginalFilename();
								
					if (uploadedFileName.trim() != "" || uploadedFileName != null) {
						File directory;
						String check = File.separator; // Checking if system is linux
														// based or windows based by
														// checking seprator used.
						String path = null;
						if (check.equalsIgnoreCase("\\")) {
							path = servletContext.getRealPath("").replace("build\\", ""); // gives real path as Lab9/build/web/
																						  // so we need to replace build in the path
																								}

						if (check.equalsIgnoreCase("/")) {
							path = servletContext.getRealPath("").replace("build/", "");
							path += "/"; // Adding trailing slash for Mac systems.
						}
						
						System.out.println("printing path: "+ path);
						directory = new File(path + "\\" + uploadedFileName);
						boolean temp = directory.exists();
						if (!temp) {
							temp = directory.mkdir();
						}
						if (temp) {
							// We need to transfer to a file
							CommonsMultipartFile photoInMemory = jobSeekerModel.getProfileResume();

							System.out.println("printing photoInMemory size: " + photoInMemory.getSize());
							
							String fileName = photoInMemory.getOriginalFilename();
							// could generate file names as well

							File localFile = new File(directory.getPath(), fileName);

							// move the file from memory to the file

							photoInMemory.transferTo(localFile);
							jobSeekerModel.setFilenameResume(localFile.getPath());
							System.out.println("File is stored at: ---" + localFile.getPath());
							System.out.println("User object from session before calling save user DAO---"+ session.getAttribute("User"));
							
							User userFromSession = (User) session.getAttribute("User");
							System.out.println("userID--"+ userFromSession.getId());
							JobSeeker jobSeekerNew = userDAO.fetchJobSeekerFromUserId(userFromSession.getId());
							jobSeekerNew.setProfileResume(jobSeekerModel.getProfileResume());
							jobSeekerNew.setFilenameResume(localFile.getPath());
							System.out.println("Filename before saving in DAO---"+localFile.getPath());
							
							JobSeeker js = userDAO.saveJobSeekerResume(jobSeekerNew);
							System.out.println("Printing name from object received in controller -->"+ js.getFirstName() + js.getLastName());
							System.out.println("Printing photoName from object received in controller -->"+ js.getProfileResume());
							
							if(js != null){
								System.out.println("Resume uploded successfully!");
								model.addAttribute("addStatus", "Resume uploaded successfully!");	
							}
							

						} else {
							System.out.println("Failed to upload resume.");
							model.addAttribute("addStatus", "Failed to upload resume, Please try again!");
						}
					}

				}catch(Exception e)
				{
					
					System.out.println("error in resume upload");
					model.addAttribute("successFlag", "Failed to upload resume");
					e.printStackTrace();
				}
				return "uploadResumePage";
			
			}else{
				System.out.println("Session does not exist!");
				return "login";
			}
		
			
		}
	
	@RequestMapping(value = "/uploadProfilePicture.htm", method = RequestMethod.GET)
	public String uploadProfilePicturePage(ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(session != null){
			try{
				System.out.println("Navigating to uploadProfilePicture");
				// command object
				model.addAttribute("jobSeekerModel", jobSeeker);
				// return form view
				return "uploadProfilePicturePage";
				
				
			}catch(Exception e)
			{
				e.printStackTrace();
				
				model.addAttribute("errorMessage", "No page to display");
				return "error";
			}
		
		}else{
			System.out.println("Session does not exist!");
			return "login";
		}
		
	}

	@RequestMapping(value = "/uploadProfilePic.htm", method = RequestMethod.POST)
		public ModelAndView uploadPhoto(ModelMap model, @ModelAttribute("jobSeekerModel") JobSeeker jobSeekerModel,  BindingResult result, HttpServletRequest request) {
			
			HttpSession session = request.getSession();
			if(session != null){
				try{
					
					String uploadedFileName = jobSeekerModel.getProfilePhoto().getOriginalFilename();
								
					if (uploadedFileName.trim() != "" || uploadedFileName != null) {
						File directory;
						String check = File.separator; // Checking if system is linux
														// based or windows based by
														// checking seprator used.
						String path = null;
						if (check.equalsIgnoreCase("\\")) {
							path = servletContext.getRealPath("").replace("build\\", ""); // gives real path as Lab9/build/web/
																						  // so we need to replace build in the path
						}

						if (check.equalsIgnoreCase("/")) {
							path = servletContext.getRealPath("").replace("build/", "");
							path += "/"; // Adding trailing slash for Mac systems.
						}
						
						System.out.println("printing path: "+ path);
						directory = new File(path + "\\" + uploadedFileName);
						boolean temp = directory.exists();
						if (!temp) {
							temp = directory.mkdir();
						}
						if (temp) {
							// We need to transfer to a file
							CommonsMultipartFile photoInMemory = jobSeekerModel.getProfilePhoto();

							System.out.println("printing photoInMemory size: " + photoInMemory.getSize());
							
							String fileName = photoInMemory.getOriginalFilename();
							// could generate file names as well

							File localFile = new File(directory.getPath(), fileName);

							// move the file from memory to the file

							photoInMemory.transferTo(localFile);
							jobSeekerModel.setFilenamePhoto(localFile.getPath());
							System.out.println("File is stored at: ---" + localFile.getPath());
							System.out.println("User object from session before calling save user DAO---"+ session.getAttribute("User"));
							
							User userFromSession = (User) session.getAttribute("User");
							System.out.println("userID--"+ userFromSession.getId());
							JobSeeker jobSeekerNew = userDAO.fetchJobSeekerFromUserId(userFromSession.getId());
							jobSeekerNew.setProfilePhoto(jobSeekerModel.getProfilePhoto());
							jobSeekerNew.setFilenamePhoto(localFile.getPath());
							System.out.println("Filename before saving in DAO---"+localFile.getPath());
							
							JobSeeker js = userDAO.saveJobSeekerProfilePicture(jobSeekerNew);
							System.out.println("Printing name from object received in controller -->"+ js.getFirstName() + js.getLastName());
							System.out.println("Printing photoName from object received in controller -->"+ js.getProfilePhoto());
							
							if(js != null){
								System.out.println("Photo uploded successfully!");
								JobSeeker tempUser = (JobSeeker)session.getAttribute("User");
								tempUser.setFilenamePhoto(localFile.getPath());
								session.setAttribute("User", tempUser);
								model.addAttribute("profilePicPath", localFile.getPath());
							}

						} else {
							System.out.println("Failed to upload picture.");
							model.addAttribute("addStatus", "Failed to upload picture, Please try again!");
						}
					}

				}catch(Exception e)
				{
					
					System.out.println("error in photo upload");
					model.addAttribute("successFlag", "Failed to upload picture");
					e.printStackTrace();
				}
				return new ModelAndView("dashboard", "model",model); 

			
			}else{
				System.out.println("Session does not exist!");
				return new ModelAndView("login");
			}
		}

}
