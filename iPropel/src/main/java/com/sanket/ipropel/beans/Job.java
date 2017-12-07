package com.sanket.ipropel.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "JOB")
public class Job {

	@Id
	@GeneratedValue
	@Column(name = "JOBID")
	private int jobId;

	@Column(name = "JOBTITLE")
	private String jobTitle;

	@Column(name = "JOBDESCRIPTION")
	private String jobDescription;

	@Column(name = "JOBLOCATION")
	private String jobLocation;

	@Column(name = "JOBSALARY")
	private double jobSalary;

	@Column(name = "JOBCATEGORY")
	private String jobCategory;

	/*@Column(name = "ACTIVE_STATUS")
	private boolean isJobActive;*/
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Skill> requiredSkillsList = new ArrayList<Skill>();

	@Column(name = "POSTEDON")
	private Date jobPostedOn;

	@Column(name = "EXPIRESON")
	private Date jobExpiresOn;
	
	@ManyToOne
	private Recruiter recruiterName;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<JobSeeker> jobSeekersList = new ArrayList<JobSeeker>();

	/**
	 * Default Constructor
	 */
	public Job() {
	}

	/**
	 * @param jobTitle
	 * @param jobDescription
	 * @param jobLocation
	 * @param jobSalary
	 * @param requiredSkillsList
	 * @param jobPostedOn
	 * @param jobExpiresOn
	 * @param recruiterName
	 * @param applicantList
	 */
	public Job(String jobTitle, String jobDescription, String jobLocation, double jobSalary, String jobCategory,
			// ArrayList<Skill> requiredSkillsList,
			Date jobPostedOn, Date jobExpiresOn, Recruiter recruiterName
	// ,ArrayList<JobSeeker> applicantList
	) {
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.jobLocation = jobLocation;
		this.jobSalary = jobSalary;
		this.jobCategory = jobCategory;
		// this.requiredSkillsList = requiredSkillsList;
		this.jobPostedOn = jobPostedOn;
		this.jobExpiresOn = jobExpiresOn;
		this.recruiterName = recruiterName;
		// this.jobSeekersList = applicantList;
	}

	/**
	 * @return the jobId
	 */
	public int getJobId() {
		return jobId;
	}

	/**
	 * @param jobId
	 *            the jobId to set
	 */
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle
	 *            the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * @return the jobDescription
	 */
	public String getJobDescription() {
		return jobDescription;
	}

	/**
	 * @param jobDescription
	 *            the jobDescription to set
	 */
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	/**
	 * @return the jobLocation
	 */
	public String getJobLocation() {
		return jobLocation;
	}

	/**
	 * @param jobLocation
	 *            the jobLocation to set
	 */
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	/**
	 * @return the jobSalary
	 */
	public double getJobSalary() {
		return jobSalary;
	}

	/**
	 * @param jobSalary
	 *            the jobSalary to set
	 */
	public void setJobSalary(double jobSalary) {
		this.jobSalary = jobSalary;
	}

	/**
	 * @return the requiredSkillsList
	 */
	public List<Skill> getRequiredSkillsList() {
		return requiredSkillsList;
	}

	/**
	 * @param requiredSkillsList
	 *            the requiredSkillsList to set
	 */
	public void setRequiredSkillsList(ArrayList<Skill> requiredSkillsList) {
		this.requiredSkillsList = requiredSkillsList;
	}

	/**
	 * @return the jobPostedOn
	 */
	public Date getJobPostedOn() {
		return jobPostedOn;
	}

	/**
	 * @param jobPostedOn
	 *            the jobPostedOn to set
	 */
	public void setJobPostedOn(Date jobPostedOn) {
		this.jobPostedOn = jobPostedOn;
	}

	/**
	 * @return the jobExpiresOn
	 */
	public Date getJobExpiresOn() {
		return jobExpiresOn;
	}

	/**
	 * @param jobExpiresOn
	 *            the jobExpiresOn to set
	 */
	public void setJobExpiresOn(Date jobExpiresOn) {
		this.jobExpiresOn = jobExpiresOn;
	}

	/**
	 * @return the recruiterName
	 */
	public Recruiter getRecruiterName() {
		return recruiterName;
	}

	/**
	 * @param recruiterName
	 *            the recruiterName to set
	 */
	public void setRecruiterName(Recruiter recruiterName) {
		this.recruiterName = recruiterName;
	}

	/**
	 * @return the applicantList
	 */
	public List<JobSeeker> getApplicantList() {
		return jobSeekersList;
	}

	/**
	 * @param applicantList
	 *            the applicantList to set
	 */
	public void setApplicantList(ArrayList<JobSeeker> applicantList) {
		this.jobSeekersList = applicantList;
	}

	public void addJobSeekers(JobSeeker jobSeeker) {
		jobSeekersList.add(jobSeeker);
		jobSeeker.getAppliedJobsList().add(this);
	}

	public void removeJobSeekers(JobSeeker jobSeeker) {
		jobSeekersList.remove(jobSeeker);
		jobSeeker.getAppliedJobsList().remove(this);
	}

	// requiredSkillsList
	public void addRequiredSkillToList(Skill skill) {
		requiredSkillsList.add(skill);

	}

	public void removeRequiredSkillFromList(Skill skill) {
		requiredSkillsList.remove(skill);

	}

	/**
	 * @return the jobCategory
	 */
	public String getJobCategory() {
		return jobCategory;
	}

	/**
	 * @param jobCategory
	 *            the jobCategory to set
	 */
	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}

	/**
	 * @return the jobSeekersList
	 */
	public List<JobSeeker> getJobSeekersList() {
		return jobSeekersList;
	}

	/**
	 * @param jobSeekersList
	 *            the jobSeekersList to set
	 */
	public void setJobSeekersList(List<JobSeeker> jobSeekersList) {
		this.jobSeekersList = jobSeekersList;
	}

	/**
	 * @param requiredSkillsList
	 *            the requiredSkillsList to set
	 */
	public void setRequiredSkillsList(List<Skill> requiredSkillsList) {
		this.requiredSkillsList = requiredSkillsList;
	}

}
