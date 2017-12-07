package com.sanket.ipropel.beans;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
//import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ADMIN")
@PrimaryKeyJoinColumn(name = "USERID")
public class Admin extends User{
	
	@Transient
	private ArrayList<Company> companyList;
	
	@Transient
	private ArrayList<JobSeeker> jobSeekerList;
	
	@Transient
	private ArrayList<Recruiter> recruiterList;	
	
	/**
	 * Default Constructor
	 */
	public Admin() {
	}
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param password
	 * @param email
	 * @param phoneNo
	 * @param companyList
	 * @param jobSeekerList
	 * @param recruiterList
	 */
	public Admin(String firstName, String lastName, String username, String password, String email, String phoneNo
			//, ArrayList<Company> companyList, ArrayList<JobSeeker> jobSeekerList, ArrayList<Recruiter> recruiterList
			) {
		super(firstName, lastName, username, password, email, phoneNo);
		//this.companyList = companyList;
		//this.jobSeekerList = jobSeekerList;
		//this.recruiterList = recruiterList;
	}
	/**
	 * @return the companyList
	 */
	public ArrayList<Company> getCompanyList() {
		return companyList;
	}
	/**
	 * @param companyList the companyList to set
	 */
	public void setCompanyList(ArrayList<Company> companyList) {
		this.companyList = companyList;
	}
	/**
	 * @return the jobSeekerList
	 */
	public ArrayList<JobSeeker> getJobSeekerList() {
		return jobSeekerList;
	}
	/**
	 * @param jobSeekerList the jobSeekerList to set
	 */
	public void setJobSeekerList(ArrayList<JobSeeker> jobSeekerList) {
		this.jobSeekerList = jobSeekerList;
	}
	/**
	 * @return the recruiterList
	 */
	public ArrayList<Recruiter> getRecruiterList() {
		return recruiterList;
	}
	/**
	 * @param recruiterList the recruiterList to set
	 */
	public void setRecruiterList(ArrayList<Recruiter> recruiterList) {
		this.recruiterList = recruiterList;
	}	
	
	public void addCompany(Company company){
		companyList.add(company);
	}
	
	public void deleteCompany(Company company){
		companyList.remove(company);
	}	

}
