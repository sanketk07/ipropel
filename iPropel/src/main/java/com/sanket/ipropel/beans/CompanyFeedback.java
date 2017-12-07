package com.sanket.ipropel.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY_FEEDBACK")
public class CompanyFeedback {	
	
	@Id
	@GeneratedValue
	@Column(name = "FEEDBACKID")
	private int feedbackId;
	
	@Column(name = "FEEDBACKTITLE")
	private String feedbackTitle;
	
	@Column(name = "FEEDBACKDESC")
	private String feedbackDesc;
	
	@Column(name = "FEEDBACKDATE")
	private Date feedbackPostDate;
	//private int postedBy;
	//private String feedbackFor;
	
	@ManyToOne
	private JobSeeker jobSeeker;
	
	@ManyToOne
	private Company company;
		
	/**
	 * Default Constructor
	 */
	public CompanyFeedback() {
	}

	/**
	 * @param feedbackTitle
	 * @param feedbackDesc
	 * @param feedbackPostDate
	 * @param jobSeeker
	 * @param company
	 */
	public CompanyFeedback(String feedbackTitle, String feedbackDesc, Date feedbackPostDate, JobSeeker jobSeeker,
			Company company) {
		this.feedbackTitle = feedbackTitle;
		this.feedbackDesc = feedbackDesc;
		this.feedbackPostDate = feedbackPostDate;
		this.jobSeeker = jobSeeker;
		this.company = company;
	}


	/**
	 * @return the feedbackId
	 */
	public int getFeedbackId() {
		return feedbackId;
	}

	/**
	 * @param feedbackId the feedbackId to set
	 */
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	/**
	 * @return the feedbackTitle
	 */
	public String getFeedbackTitle() {
		return feedbackTitle;
	}

	/**
	 * @param feedbackTitle the feedbackTitle to set
	 */
	public void setFeedbackTitle(String feedbackTitle) {
		this.feedbackTitle = feedbackTitle;
	}

	/**
	 * @return the feedbackDesc
	 */
	public String getFeedbackDesc() {
		return feedbackDesc;
	}

	/**
	 * @param feedbackDesc the feedbackDesc to set
	 */
	public void setFeedbackDesc(String feedbackDesc) {
		this.feedbackDesc = feedbackDesc;
	}

	/**
	 * @return the feedbackPostDate
	 */
	public Date getFeedbackPostDate() {
		return feedbackPostDate;
	}

	/**
	 * @param feedbackPostDate the feedbackPostDate to set
	 */
	public void setFeedbackPostDate(Date feedbackPostDate) {
		this.feedbackPostDate = feedbackPostDate;
	}

	/**
	 * @return the jobSeeker
	 */
	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	/**
	 * @param jobSeeker the jobSeeker to set
	 */
	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return the postedBy
	 *//*
	public int getPostedBy() {
		return postedBy;
	}

	*//**
	 * @param postedBy the postedBy to set
	 *//*
	public void setPostedBy(int postedBy) {
		this.postedBy = postedBy;
	}*/

	/**
	 * @return the feedbackFor
	 *//*
	public String getFeedbackFor() {
		return feedbackFor;
	}

	*//**
	 * @param feedbackFor the feedbackFor to set
	 *//*
	public void setFeedbackFor(String feedbackFor) {
		this.feedbackFor = feedbackFor;
	}
	*/
	
	
	
}
