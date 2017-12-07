package com.sanket.ipropel.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import com.sanket.ipropel.beans.Job;
import com.sanket.ipropel.beans.JobSeeker;
import com.sanket.ipropel.exception.UserException;

public class JobDAO extends DAO {

	public boolean createJob(Job job) throws UserException {

		boolean jobCreationFlag = false;
		try {

			System.out.println("Inside try in createJob - JobDAO");
			begin();

			if (job != null) {
				getSession().save(job);
				jobCreationFlag = true;
				commit();
			} else {

				jobCreationFlag = false;
			}
			close();
		} catch (HibernateException e) {
			System.out.println("Inside catch in create job - JobDAO");
			jobCreationFlag = false;
			rollback();
			throw new UserException("Exception while creating job listing: " + e.getMessage());
		}
		return jobCreationFlag;
	}

	public List<Job> fetchAvailableJObs() throws Exception {
		try {
			begin();
			Session session = getSession();

			Query q = null;
			List<Job> jobs = null;
			q = session.createQuery("from Job");
			jobs = q.list();
			commit();

			close();
			return jobs;
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
			return null;
		}

	}

	public Job fetchJobFromId(String jobId) throws Exception {
		try {
			begin();
			Session session = getSession();

			Query q = null;
			Job job;
			q = session.createQuery("from Job where jobId = :jId");
			q.setString("jId", jobId);
			job = (Job) q.uniqueResult();
			commit();

			close();
			return job;
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
			return null;
		}

	}
	
	public boolean applyForAvailableJobs(JobSeeker jobSeeker, int jobId) throws Exception {
		
		boolean isJobApplicationSuccessful = false;
		try {
			begin();
			Session session = getSession();

			Query q = null;
			Job job = null;
			q = session.createQuery("from Job where jobId = :jId");
			q.setInteger("jId", jobId);
			job = (Job) q.uniqueResult();
			
			job.addJobSeekers(jobSeeker);
			System.out.println("job.getApplicantList().size(): "+job.getApplicantList().size());
			if(job.getApplicantList().size()>=1){
				isJobApplicationSuccessful = true;
			}
			commit();

			close();
			return isJobApplicationSuccessful;
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
			return false;
		}

	}
	
	public ArrayList<JobSeeker> fetchJobApplicants(int jobId) throws Exception {
		
		ArrayList<JobSeeker> jobSeekers = null;
		
		try {
			begin();
			Session session = getSession();
			
			Query q = null;
			q = session.createQuery("select jobSeekersList from Job where jobId = :jobId"); 
			q.setInteger("jobId", jobId);
			jobSeekers = (ArrayList<JobSeeker>) q.list();
			
			System.out.println("Job Applicants for Job: "+ jobId);
			System.out.println("---------------------");
			
			for(JobSeeker j : jobSeekers){
				System.out.println("Applicant name: "+ j.getFirstName() + " "+ j.getLastName());
			}
			
			commit();

			close();
			return jobSeekers;
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
			return null;
		}

	}



}
