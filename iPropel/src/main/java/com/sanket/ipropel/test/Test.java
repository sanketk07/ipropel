/**
 * 
 */
package com.sanket.ipropel.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.EncryptedPrivateKeyInfo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sanket.ipropel.beans.Admin;
import com.sanket.ipropel.beans.Company;
import com.sanket.ipropel.beans.CompanyFeedback;
import com.sanket.ipropel.beans.File;
import com.sanket.ipropel.beans.Job;
import com.sanket.ipropel.beans.JobSeeker;
import com.sanket.ipropel.beans.Message;
import com.sanket.ipropel.beans.Recruiter;
import com.sanket.ipropel.beans.Skill;
import com.sanket.ipropel.beans.User;
import com.sanket.ipropel.utility.DateUtility;

/**
 * @author sanket
 *
 */
public class Test {

	/**
	 * @param args
	 */
	@SuppressWarnings("null")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();*/

		/*Admin admin = new Admin("Gaurav", "Saxena", "gs", "gs", "gs@gmail.com", "1234567890");
		session.save(admin);

		Company company = new Company("Amazon", "Software", "Leading E-commerce Firm");
		session.save(company);

		JobSeeker js = new JobSeeker("Amit", "Patil", "ap", "ap", "ap@gmail.com", "5467123387", "Database Developer",
				true, new Date());
		session.save(js);

		Skill s = new Skill();
		s.setSkillName("HTML5");
		s.setSkillDescription("Front-End Development");
		s.setSkillProficiency("Intermediate");
		s.addJobSeekers(js);

		session.save(s);

		Recruiter recruiter = new Recruiter("James", "Gosling", "user2", "user2", "user2@gmail.com", "9876543210", "HR",
				true, new Date(), company);

		Job job = new Job("Java Developer", "Need java dev for Financial Services Client", "Boston", 12333.22, null,
				new Date(), new Date(), recruiter);
		job.addRequiredSkillToList(s);

		session.save(job);

		recruiter.addJob(job);
		session.save(recruiter);*/
		
		
		/*Message message = new Message("sk@gmail.com", "rb@gmail.com", new Date(), "Hello. How are you doing?");	
		session.save(message);*/

		/*session.getTransaction().commit();
		session.close();
*/
		/*
		 * 
		 * 
		 * 
		 * User person = new User("Steve", "Balmer", "user1", "user1",
		 * "user1@gmail.com", "1234567890"); session.save(person);
		 * 
		 * Admin admin = new Admin("Rohit", "Bokade", "rb", "rb",
		 * "admin@gmail.com", "1234567890"); session.save(admin);
		 * 
		 * JobSeeker js = new JobSeeker("Sundar", "Pichai", "user5", "user5",
		 * "user5@gmail.com", "5467123387", "Passionate Developer", true, new
		 * Date()); session.save(js);
		 * 
		 * Skill s = new Skill(); s.setSkillName("HTML5");
		 * s.setSkillDescription("Front-End Development");
		 * s.setSkillProficiency("Intermediate"); s.addJobSeekers(js);
		 * 
		 * session.save(s);
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * Recruiter rec = new Recruiter(); rec.setFirstName("mark");
		 * rec.setLastName("johnson"); rec.setCompanyName(company);
		 * rec.setRecruiterDesignation("Head HR");
		 * 
		 * company.addRecruiter(rec);
		 * 
		 * CompanyFeedback feedback = new CompanyFeedback();
		 * feedback.setFeedbackTitle("Good Company");
		 * feedback.setFeedbackDesc("Great hiring process.");
		 * feedback.setFeedbackPostDate(new Date()); feedback.setJobSeeker(js);
		 * feedback.setCompany(company);
		 * 
		 * session.save(company);
		 * 
		 * 
		 * 
		 * Skill skill = new Skill(); skill.setSkillName("Java");
		 * skill.setSkillDescription("Middleware Development");
		 * skill.setSkillProficiency("Advanced"); skill.addJobSeekers(js);
		 * 
		 * session.save(skill);
		 * 
		 * Job job = new Job("Java Developer",
		 * "Need java dev for Financial Services Client", "Boston", 12333.22,
		 * new Date(), new Date(), rec); //how to add in list? like
		 * requiredSkillsList in above case job.addRequiredSkillToList(skill);
		 * 
		 * session.save(job);
		 * 
		 * Recruiter recruiter = new Recruiter("James", "Gosling", "user2",
		 * "user2", "user2@gmail.com", "9876543210", "HR", true, new Date(),
		 * company);
		 * 
		 * recruiter.addJob(job); session.save(recruiter);
		 * 
		 * 
		 * session.getTransaction().commit(); session.close();
		 */
		
		/*Date latestDate = DateUtility.returnIncrementedDate(1); 
		
		long diff = new Date().getTime() - new Date().getTime() ;
		
		//System.out.println("latestDate.getTime() ---"+ latestDate.getTime());
		System.out.println("new Date().getTime() -----"+ new Date().getTime());

		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);
		
		System.out.println("Difference in Hours: "+ diffHours);

		System.out.print(diffDays + " days, ");
		System.out.print(diffHours + " hours, ");
		System.out.print(diffMinutes + " minutes, ");
		System.out.print(diffSeconds + " seconds.");*/
		
		Test test = new Test();
		System.out.println("result: "+test.isNameValid("richa"));

	}
	
	 public boolean isNameValid(String name){
	        boolean flag= false;
	        try{
	              
	           Pattern p = Pattern.compile("^[a-zA-Z\\s]+");
	           
	           Matcher m = p.matcher(name);
	           System.out.println("m.find" + m.matches());
	           
	           
	          /* String expression = "^[a-zA-Z\\s]+"; 
	           return name.matches(expression); */
	           
	            
	        }catch(Exception e)
	        {
	            flag = false;
	            System.out.println(e.getMessage());
	        }
	        return flag;
	    }

}
