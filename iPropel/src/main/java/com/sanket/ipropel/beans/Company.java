package com.sanket.ipropel.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY")
public class Company {
	
	@Id
	@GeneratedValue
	@Column(name = "COMPANYID")
	private int companyId;
	
	@Column(name = "COMPANYNAME")
	private String companyName;
	
	@Column(name = "INDUSTRY")
	private String industry;
	
	@Column(name = "COMPANYDESC")
	private String companyDescription;
	
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CompanyFeedback> feedbackList = new ArrayList<CompanyFeedback>();
	
	@OneToMany(mappedBy = "companyName", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Recruiter> recruiterList = new ArrayList<Recruiter>();
	
	/**
	 * Default Constructor
	 */
	public Company() {
	}	

	/**
	 * @param companyName
	 * @param industry
	 * @param companyDescription
	 * @param feedbackList
	 * @param recruiterList
	 */
	public Company(String companyName, String industry, String companyDescription
			//, List<CompanyFeedback> feedbackList,
			//List<Recruiter> recruiterList
			
			) {
		this.companyName = companyName;
		this.industry = industry;
		this.companyDescription = companyDescription;
		//this.feedbackList = feedbackList;
		//this.recruiterList = recruiterList;
	}



	/**
	 * @return the companyId
	 */
	public int getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the industry
	 */
	public String getIndustry() {
		return industry;
	}

	/**
	 * @param industry the industry to set
	 */
	public void setIndustry(String industry) {
		this.industry = industry;
	}

	/**
	 * @return the companyDescription
	 */
	public String getCompanyDescription() {
		return companyDescription;
	}

	/**
	 * @param companyDescription the companyDescription to set
	 */
	public void setCompanyDescription(String companyDescription) {
		this.companyDescription = companyDescription;
	}

	/**
	 * @return the feedbackList
	 */
	public List<CompanyFeedback> getFeedbackList() {
		return feedbackList;
	}

	/**
	 * @param feedbackList the feedbackList to set
	 */
	public void setFeedbackList(ArrayList<CompanyFeedback> feedbackList) {
		this.feedbackList = feedbackList;
	}

	/**
	 * @return the recruiterList
	 */
	public List<Recruiter> getRecruiterList() {
		return recruiterList;
	}

	/**
	 * @param recruiterList the recruiterList to set
	 */
	public void setRecruiterList(ArrayList<Recruiter> recruiterList) {
		this.recruiterList = recruiterList;
	}	
	
	public void addRecruiter(Recruiter recruiter){
		recruiterList.add(recruiter);
		recruiter.setCompanyName(this);
	}
	
	public void removeRecruiter(Recruiter recruiter){
		recruiterList.remove(recruiter);
		recruiter.setCompanyName(null);
	}
	
	public void addFeedback(CompanyFeedback feedback){
		feedbackList.add(feedback);
		feedback.setCompany(this);
	}
	
	public void removeFeedback(CompanyFeedback feedback){
		feedbackList.remove(feedback);
		feedback.setCompany(null);
	}

}
