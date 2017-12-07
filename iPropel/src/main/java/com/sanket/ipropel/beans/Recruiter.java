package com.sanket.ipropel.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
//import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "RECRUITER")
@PrimaryKeyJoinColumn(name = "USERID")
public class Recruiter extends User{
		
	@Column(name = "DESIGNATION")
	private String recruiterDesignation;
	
	@Column(name = "ACTIVE_STATUS")
	private boolean isRecruiterActive;
	
	@Column(name = "LAST_LOGIN")
	private Date lastLogin;
	
	@ManyToOne
	private Company companyName;
	
	@OneToMany(mappedBy = "recruiterName", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Job> jobsPosted = new ArrayList<Job>();
	
	/**
	 * Default Constructor
	 */
	public Recruiter() {
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param password
	 * @param email
	 * @param phoneNo
	 * @param recruiterDesignation
	 * @param isRecruiterActive
	 * @param companyName
	 * @param jobsPosted
	 */
	public Recruiter(String firstName, String lastName, String username, String password, String email, String phoneNo,
			String recruiterDesignation, boolean isRecruiterActive, Date lastLogin
			//,Company companyName
			//, List<Job> jobsPosted
			
			) {
		super(firstName, lastName, username, password, email, phoneNo);
		this.recruiterDesignation = recruiterDesignation;
		this.isRecruiterActive = isRecruiterActive;
		//this.companyName = companyName;
		//this.jobsPosted = jobsPosted;
	}

	/**
	 * @return the recruiterDesignation
	 */
	public String getRecruiterDesignation() {
		return recruiterDesignation;
	}

	/**
	 * @param recruiterDesignation the recruiterDesignation to set
	 */
	public void setRecruiterDesignation(String recruiterDesignation) {
		this.recruiterDesignation = recruiterDesignation;
	}

	/**
	 * @return the isRecruiterActive
	 */
	public boolean isRecruiterActive() {
		return isRecruiterActive;
	}

	/**
	 * @param isRecruiterActive the isRecruiterActive to set
	 */
	public void setRecruiterActive(boolean isRecruiterActive) {
		this.isRecruiterActive = isRecruiterActive;
	}

	/**
	 * @return the companyName
	 */
	public Company getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(Company companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the jobsPosted
	 */
	public List<Job> getJobsPosted() {
		return jobsPosted;
	}

	/**
	 * @param jobsPosted the jobsPosted to set
	 */
	public void setJobsPosted(ArrayList<Job> jobsPosted) {
		this.jobsPosted = jobsPosted;
	}
		
	/**
	 * @return the lastLogin
	 */
	public Date getLastLogin() {
		return lastLogin;
	}

	/**
	 * @param lastLogin the lastLogin to set
	 */
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * @param jobsPosted the jobsPosted to set
	 */
	public void setJobsPosted(List<Job> jobsPosted) {
		this.jobsPosted = jobsPosted;
	}
	
	public void addJob(Job job) {
		jobsPosted.add(job);
		job.setRecruiterName(this);
    }

    public void removeJob(Job job) {
       jobsPosted.remove(job);
       job.setRecruiterName(null);
    }

	

}
