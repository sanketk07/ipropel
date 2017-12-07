package com.sanket.ipropel.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.sanket.ipropel.beans.Job;
import com.sanket.ipropel.beans.JobSeeker;
import com.sanket.ipropel.beans.Recruiter;
import com.sanket.ipropel.beans.Skill;
import com.sanket.ipropel.beans.User;
import com.sanket.ipropel.exception.UserException;

public class UserDAO extends DAO {

	public boolean registerNewUser(User user) throws UserException {

		boolean registerUserFlag = false;
		try {

			System.out.println("Inside try in create user - UserDAO");
			begin();

			ArrayList<User> userList = new ArrayList<User>();
			Query query = getSession().createQuery("from User where email = :email or username=:username");
			query.setString("email", user.getEmail());
			query.setString("username", user.getUsername());
			userList = (ArrayList<User>) query.list();

			if (userList.size() == 0) {
				getSession().save(user);
				registerUserFlag = true;
				commit();
			} else {

				registerUserFlag = false;
			}
			close();
		} catch (HibernateException e) {
			System.out.println("Inside catch in create user - UserDAO");
			registerUserFlag = false;
			rollback();
			throw new UserException("Exception while saving User data: " + e.getMessage());
		}
		return registerUserFlag;
	}

	/*
	 * public boolean checkUserAvailability(String email, String username)
	 * throws Exception{ boolean flag = false; try { Transaction transaction =
	 * getSession().beginTransaction();
	 * 
	 * System.out.println("inside check unique user");
	 * 
	 * Query query = getSession().
	 * createQuery("from User where emailId = :email or userName=:username");
	 * 
	 * query.setString("email", email); query.setString("username", username);
	 * 
	 * ArrayList<User> userList = (ArrayList<User>) query.list();
	 * 
	 * if (userList.size() == 0) {
	 * 
	 * //email id and username doesnt exist in db so its a unique user
	 * 
	 * flag = true;
	 * 
	 * } else {
	 * 
	 * flag = false; } transaction.commit(); close(); } catch
	 * (HibernateException e) { flag = false;
	 * System.err.println(e.getMessage()); throw new
	 * Exception("Could not query the database"); } return flag;
	 * 
	 * 
	 * }
	 */

	public User authenticateUser(String username, String password) throws Exception {

		try {
			begin();

			System.out.println("in authenticateUser - UserDAO");

			Query query = getSession().createQuery("from User where username=:uname and password = :pwd");

			query.setString("uname", username);
			query.setString("pwd", password);

			User user = (User) query.uniqueResult();

			commit();
			close();
			return user;
		} catch (HibernateException e) {

			System.err.println(e.getMessage());
			throw new Exception("Could not query the database");
		}

	}

	public ArrayList<JobSeeker> fetchJobSeekers() throws Exception {

		ArrayList<JobSeeker> jobSeekerList = new ArrayList<JobSeeker>();

		try {
			begin();

			System.out.println("in fetchJobSeekers - UserDAO");

			Query query = getSession().createQuery("from JobSeeker");
			jobSeekerList = (ArrayList<JobSeeker>) query.list();

			close();
			return jobSeekerList;

		} catch (HibernateException e) {
			throw new UserException("Exception while retrieving jobseekers: " + e.getMessage());

		}

	}
	
	public ArrayList<JobSeeker> fetchActiveJobSeekers() throws Exception {

		ArrayList<JobSeeker> activeJobSeekerList = new ArrayList<JobSeeker>();
		
		try {
			begin();

			System.out.println("in fetchJobSeekers - UserDAO");

			Query query = getSession().createQuery("from JobSeeker where isJobSeekerActive = :active");
			query.setBoolean("active", true);
			activeJobSeekerList = (ArrayList<JobSeeker>) query.list();
			
			for(JobSeeker jobSeeker : activeJobSeekerList){
				System.out.println("Printing active job seekers in DAO -- "+ jobSeeker.getId());
				System.out.println("----------------------");
			}
			close();
			return activeJobSeekerList;

		} catch (HibernateException e) {
			throw new UserException("Exception while retrieving jobseekers: " + e.getMessage());

		}

	}
	
	public ArrayList<JobSeeker> fetchInactiveJobSeekers() throws Exception {

		ArrayList<JobSeeker> inactiveJobSeekerList = new ArrayList<JobSeeker>();
		
		try {
			begin();

			System.out.println("in fetchJobSeekers - UserDAO");

			Query query = getSession().createQuery("from JobSeeker where isJobSeekerActive = :active");
			query.setBoolean("active", false);
			inactiveJobSeekerList = (ArrayList<JobSeeker>) query.list();
			
			for(JobSeeker jobSeeker : inactiveJobSeekerList){
				System.out.println("Printing inactive job seekers in DAO -- "+ jobSeeker.getId());
				System.out.println("----------------------");
			}
			close();
			return inactiveJobSeekerList;

		} catch (HibernateException e) {
			throw new UserException("Exception while retrieving jobseekers: " + e.getMessage());

		}

	}

	public ArrayList<Recruiter> fetchRecruiters() throws Exception {

		ArrayList<Recruiter> recruiterList = new ArrayList<Recruiter>();

		try {
			begin();

			System.out.println("in fetchRecruiters - UserDAO");

			Query query = getSession().createQuery("from Recruiter");
			recruiterList = (ArrayList<Recruiter>) query.list();

			close();
			return recruiterList;

		} catch (HibernateException e) {
			throw new UserException("Exception while retrieving recruiters: " + e.getMessage());

		}

	}

	/*public boolean saveJobSeekerDetails(JobSeeker jobSeeker) throws Exception {

		boolean isJobSeekerDetailUpdated = false;

		try {

			if (jobSeeker != null) {
				System.out.println("inside dao method saveJobSeekerDetails");

				System.out.println("printing fnme: " + jobSeeker.getFirstName());
				System.out.println("printing arraylist size of applied jobs in jobseeker: "
						+ jobSeeker.getAppliedJobsList().size());

				begin();

				JobSeeker temp = getSession().load(JobSeeker.class, jobSeeker.getId());
				temp.setAppliedJobsList(jobSeeker.getAppliedJobsList());
				getSession().update(temp);
				System.out.println("Size of applied jobs list after saving jobseeker: "+temp.getAppliedJobsList().size());
				isJobSeekerDetailUpdated = true;
				commit();
				close();
			} else {

				isJobSeekerDetailUpdated = false;
			}

		} catch (Exception e) {

			e.printStackTrace();
			isJobSeekerDetailUpdated = false;
		}

		return isJobSeekerDetailUpdated;
	}*/

	public JobSeeker fetchJobSeekerFromUserId(int userId) throws Exception {
		try {
			begin();
			Session session = getSession();

			Query q = null;
			JobSeeker jobSeeker;
			q = session.createQuery("from JobSeeker where id = :userId");
			q.setInteger("userId", userId);
			jobSeeker = (JobSeeker) q.uniqueResult();
			commit();

			close();
			return jobSeeker;
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
			return null;
		}

	}
	
	public JobSeeker fetchJobSeekerFromUserEmail(String userEmail) throws Exception {
		try {
			begin();
			Session session = getSession();

			Query q = null;
			JobSeeker jobSeeker;
			q = session.createQuery("from JobSeeker where email = :ue");
			q.setString("ue", userEmail);
			jobSeeker = (JobSeeker) q.uniqueResult();
			commit();

			close();
			return jobSeeker;
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
			return null;
		}

	}

	public List<Job> fetchAppliedJobs(int userId) throws Exception {
		try {
			begin();
			Session session = getSession();

			Query q = null;
			List<Job> appliedJobsList;
			//q = session.createQuery("from JobSeeker where id = :userId");
			q = session.createQuery("select appliedJobsList from JobSeeker");
			//q.setInteger("userId", userId);
			appliedJobsList = (List<Job>) q.list();
			
			for(Job j : appliedJobsList){
				System.out.println("Applied Jobs Title in UserDao: "+ j.getJobTitle());
			}
			
			commit();

			close();
			return appliedJobsList;
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
			return null;
		}

	}

	public Recruiter fetchRecruiterFromUserId(int userId) {
		try {
			begin();
			Session session = getSession();

			Query q = null;
			Recruiter recruiter;
			q = session.createQuery("from Recruiter where id = :userId");
			q.setInteger("userId", userId);
			recruiter = (Recruiter) q.uniqueResult();
			commit();

			close();
			return recruiter;
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
			return null;
		}

	}
	
	public JobSeeker saveJobSeekerResume(JobSeeker jobSeeker) throws Exception {

		JobSeeker js = null;
		try {

			if (jobSeeker != null) {
				System.out.println("inside dao - saveJobSeeker--"+jobSeeker.getId());
				System.out.println("fileName in dao---"+jobSeeker.getFilenameResume());
				System.out.println("resume in dao---"+jobSeeker.getProfileResume());
				begin();

				js = getSession().load(JobSeeker.class, jobSeeker.getId());
				js.setProfileResume(jobSeeker.getProfileResume());
				js.setFilenameResume(jobSeeker.getFilenameResume());
				getSession().save(js);
				commit();
				close();
			} else {

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return js;
	}
	
	public JobSeeker saveJobSeekerProfilePicture(JobSeeker jobSeeker) throws Exception {

		JobSeeker js = null;
		try {

			if (jobSeeker != null) {
				System.out.println("inside dao - saveJobSeeker--"+jobSeeker.getId());
				System.out.println("fileName in dao---"+jobSeeker.getFilenamePhoto());
				System.out.println("resume in dao---"+jobSeeker.getProfilePhoto());
				begin();

				js = getSession().load(JobSeeker.class, jobSeeker.getId());
				js.setProfilePhoto(jobSeeker.getProfilePhoto());
				js.setFilenamePhoto(jobSeeker.getFilenamePhoto());
				getSession().save(js);
				commit();
				close();
			} else {

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return js;
	}

	
	public boolean saveSkill(Skill skill) throws Exception {

		boolean skillSaved = false;
		try {
			begin();
			if (skill != null) {
				/*System.out.println("inside dao - saveJobSeeker--"+skill.getId());
				System.out.println("fileName in dao---"+jobSeeker.getFilenamePhoto());
				System.out.println("resume in dao---"+jobSeeker.getProfilePhoto());*/
				

				getSession().save(skill);
				skillSaved = true;
				commit();
				close();
			} else {
				skillSaved = false;
			}

		} catch (Exception e) {
			skillSaved = false;
			rollback();

			e.printStackTrace();
		}

		return skillSaved;
	}
	
	public boolean loadNewData(){
		
		boolean isDataLoaded = false;
		System.out.println("Inside loadNewData");
		
		try{
			
			begin();
			
			Skill s1 = new Skill("HTML", "UI Developer", "Advanced");
			Skill s2 = new Skill("Java", "Middleware Developer", "Intermediate");
			Skill s3 = new Skill("SQL", "Database Developer", "Beginner");
			
			
			Query queryHTML = getSession().createQuery("from Skill where skillName = :sn");
			queryHTML.setString("sn", "HTML");
            ArrayList<Skill> skillList = (ArrayList<Skill>) queryHTML.list();
            
            Query queryJava = getSession().createQuery("from Skill where skillName = :sn");
			queryJava.setString("sn", "Java");
            ArrayList<Skill> skillList2 = (ArrayList<Skill>) queryJava.list();
            
            Query querySQL = getSession().createQuery("from Skill where skillName = :sn");
            querySQL.setString("sn", "SQL");
            ArrayList<Skill> skillList3 = (ArrayList<Skill>) querySQL.list();

            if (skillList.size() == 0) {
                //skill doesnt exist in db. so need to add
            	getSession().save(s1);           	
                
            } else {
                isDataLoaded = true;
            }
            
            if (skillList2.size() == 0) {
                //skill doesnt exist in db. so need to add
            	getSession().save(s2);           	
                
            } else {
                isDataLoaded = true;
            }
            
            if (skillList3.size() == 0) {
                //skill doesnt exist in db. so need to add
            	getSession().save(s3);           	
                
            } else {
                isDataLoaded = true;
            }
            
            commit();
			
			close();
			
		}catch(Exception e){
			isDataLoaded = false;
			rollback();
		}
		
		
		return isDataLoaded;
		
	}
	
	public boolean setLastLoginTime(User user) throws Exception {

		boolean isLastLoginSaved = false;
		JobSeeker jobSeeker = null;
		//Recruiter recruiter = null;
		try {

			if (user != null) {	
				begin();
				Query q = null;
				int userId = user.getId();
				
				
					q = getSession().createQuery("from JobSeeker where id = :userId");
					q.setInteger("userId", userId);
					jobSeeker = (JobSeeker) q.uniqueResult();
					
					jobSeeker = getSession().load(JobSeeker.class, jobSeeker.getId());
					jobSeeker.setLastLogin(new Date());
					getSession().save(jobSeeker);
					isLastLoginSaved = true;
					
					commit();
					close();					
					
									
				
			} else {
				isLastLoginSaved = false;
				System.out.println("UserDAO - Job Seeker Object is null");
			}

		} catch (Exception e) {
			isLastLoginSaved = false;
			e.printStackTrace();
		}

		return isLastLoginSaved;
	}
	
	public boolean setLastLoginTimeRec(User user) throws Exception {

		boolean isLastLoginSaved = false;
		Recruiter recruiter = null;
		try {

			if (user != null) {	
				begin();
				Query q = null;
				int userId = user.getId();
				
				
					q = getSession().createQuery("from Recruiter where id = :userId");
					q.setInteger("userId", userId);
					recruiter = (Recruiter) q.uniqueResult();
					
					recruiter = getSession().load(Recruiter.class, recruiter.getId());
					recruiter.setLastLogin(new Date());
					getSession().save(recruiter);
					isLastLoginSaved = true;
					
					commit();
					close();					
					
									
				
			} else {
				isLastLoginSaved = false;
				System.out.println("UserDAO - Job Seeker Object is null");
			}

		} catch (Exception e) {
			isLastLoginSaved = false;
			e.printStackTrace();
		}

		return isLastLoginSaved;
	}
	
	public boolean deactivateJobSeekerAccount(JobSeeker jobSeeker ){
		
		boolean isAccountDeactivated = false;
		
		try{
			begin();
			Query q = null;
			 if(jobSeeker != null){
				 
				String userEmail=jobSeeker.getEmail();
				 
				q = getSession().createQuery("from JobSeeker where email = :ue");
				q.setString("ue", userEmail);
				jobSeeker = (JobSeeker) q.uniqueResult();
					
				jobSeeker = getSession().load(JobSeeker.class, jobSeeker.getId());
				jobSeeker.setJobSeekerActive(false);
				getSession().save(jobSeeker);
				 
				System.out.println("Status after deactivating jobSeeker account: "+ jobSeeker.isJobSeekerActive());
				isAccountDeactivated = true;

				 commit();
				 close();
			 }else{
				 System.out.println("JobSeeker is null");
			 }
			
		}catch(HibernateException e){
			e.printStackTrace();
			isAccountDeactivated = false;
		}
		
		return isAccountDeactivated;
	}
	
public boolean activateJobSeekerAccount(JobSeeker jobSeeker ){
		
		boolean isAccountActivated = false;
		
		try{
			begin();
			Query q = null;
			 if(jobSeeker != null){
				 
				String userEmail=jobSeeker.getEmail();
				 
				q = getSession().createQuery("from JobSeeker where email = :ue");
				q.setString("ue", userEmail);
				jobSeeker = (JobSeeker) q.uniqueResult();
					
				jobSeeker = getSession().load(JobSeeker.class, jobSeeker.getId());
				jobSeeker.setJobSeekerActive(true);
				getSession().save(jobSeeker);
				 
				System.out.println("Status after activating jobSeeker account: "+ jobSeeker.isJobSeekerActive());
				isAccountActivated = true;

				 commit();
				 close();
			 }else{
				 System.out.println("JobSeeker is null");
			 }
			
		}catch(HibernateException e){
			e.printStackTrace();
			isAccountActivated = false;
		}
		
		return isAccountActivated;
	}
	
	public boolean isUserAccountActive(JobSeeker jobSeeker){
		
		boolean activeAccount = false;
		
		try{	
			
			begin();
			Query q = null;
			
		if(jobSeeker!=null){
		
			int uId = jobSeeker.getId();
			q = getSession().createQuery("select isJobSeekerActive from JobSeeker where id = :uId");
			q.setInteger("uId", uId);
			
			activeAccount = (Boolean) q.uniqueResult();
			System.out.println("Active status in DAO: "+ activeAccount);
			commit();
			 close();
		}
		else{
			
			System.out.println("else case as JOBSEEKER is null");
		}
			
			
		}catch(HibernateException e){
			e.printStackTrace();
			activeAccount = false;
		}
		
		
		return activeAccount;
	}
	
	public ArrayList<JobSeeker> fetchJobSeekersBySkill(String skill) throws Exception {

		ArrayList<JobSeeker> jobSeekerList = null;

		try {
			begin();

			System.out.println("in fetchJobSeekers - UserDAO");
			
			/*Criteria crit = getSession().createCriteria(JobSeeker.class);
			crit.add(Restrictions.eq("skillsHeldList", skill));
			jobSeekerList = (ArrayList<JobSeeker>) crit.list();*/
			/*Query query = getSession().createQuery("select distinct a from JobSeeker a join a.skillsHeldList t where t.name in (:tags)");
			query.setParameterList("skillsHeldList", skillsHeldList);
			jobSeekerList = (ArrayList<JobSeeker>) query.list();*/
			
			Query q = getSession().createQuery("select jobSeekerList from Skill where skillName = :sn");
			q.setString("sn", skill);
			q.setComment("Printing Job Seekers with skill setComment: ");
			jobSeekerList = (ArrayList<JobSeeker>) q.list();
			
			System.out.println("Printing Job Seekers with skill: "+ skill);
			System.out.println("Size of list: "+ jobSeekerList.size());

			for(JobSeeker js : jobSeekerList){
				System.out.println("Job Seeker Id: "+ js.getId());
				System.out.println("--------------");
			}
			
			close();
			return jobSeekerList;

		} catch (HibernateException e) {
			e.printStackTrace();
			throw new UserException("Exception while retrieving jobseekers: " + e.getMessage());

		}

	}
	
	public List<Job> jobsCreatedByRecruiter(Recruiter recruiter){
		
		List<Job> myCreatedJobList = null;
		
		try{
			
			begin();			
			Query q = null;
			
			int recName = recruiter.getId();
			
			if(recruiter!=null){
				
			q = getSession().createQuery("from Job where recruiterName = :rn");
			q.setInteger("rn", recName);
			myCreatedJobList = q.list();
			
			System.out.println("Jobs created by: "+ recName);
			
			for(Job j : myCreatedJobList){
				System.out.println("Job ID's: "+ j.getJobId());
				System.out.println("--------------");
			}
			
			commit();
			 close();
			}
			
			
		}catch(HibernateException e){
			e.printStackTrace();
			return null;
		}
		
		
		
		
		
		
		return myCreatedJobList;
	}
	
public Recruiter jobCreator(Job job){
		
		Recruiter recruiter = null;
		
		try{
			
			begin();			
			Query q = null;
			
			if(job!=null){
			int jobId = job.getJobId();
				
			q = getSession().createQuery("select recruiterName from Job where jobId = :jobId");
			q.setInteger("jobId", jobId);
			recruiter = (Recruiter) q.uniqueResult();
			System.out.println("Recruiter in jobCreator: "+ recruiter.getFirstName());
			commit();
			 close();
			}
			
			
		}catch(HibernateException e){
			e.printStackTrace();
			return null;
		}
		
		return recruiter;
	}
	
	public User fetchUserFromJobSeekerEmail(JobSeeker jobSeeker){
		
		User user=null;
		
		try{
			
			begin();			
			Query q = null;
			
			if(jobSeeker != null){
				int jId = jobSeeker.getId();
				
				q = getSession().createQuery("from User where id = :jId");
				q.setInteger("jId", jId);
				
				user = (User) q.uniqueResult();
			
			}else{
				System.out.println("JobSeeker object received is null");
			}
			
		}catch(HibernateException e){
			e.printStackTrace();
			System.out.println("In catch block - fetchUserFromJobSeekerEmail: "+ e.getMessage());
		}
		
		return user;
	}

}
