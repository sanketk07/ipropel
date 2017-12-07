package com.sanket.ipropel.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
//import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name = "JOBSEEKER")
@PrimaryKeyJoinColumn(name = "USERID")
public class JobSeeker extends User{
	
	@Column(name = "DESCRIPTION")
	private String jobSeekerDesc;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Skill> skillsHeldList = new ArrayList<Skill>();
	
//	private File fileResume;
//	private File fileProfilePic;
	
	@Column(name = "ACTIVE_STATUS")
	private boolean isJobSeekerActive;
	
	@Column(name = "LAST_LOGIN")
	private Date lastLogin;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "jobSeekersList")
	private List<Job> appliedJobsList = new ArrayList<Job>();
	
	@OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL)
	private List<CompanyFeedback> feedbackList = new ArrayList<CompanyFeedback>();
	
	@Transient
	private CommonsMultipartFile profilePhoto;  
	
	@Column(name = "filenamePhoto")
	private String filenamePhoto;    
	
	@Transient
	private CommonsMultipartFile profileResume;  
	
	@Column(name = "filenameResume")
	private String filenameResume;   
	
	/**
	 * Default Constructor
	 */
	public JobSeeker() {
	}
	/**
	 * @param firstName
	 * @param lastName
	 * @param username
	 * @param password
	 * @param email
	 * @param phoneNo
	 * @param jobSeekerDesc
	 * @param skillsHeldList
	 * @param fileResume
	 * @param fileProfilePic
	 * @param isJobSeekerActive
	 * @param appliedJobsList
	 * @param feedbackList
	 */
	public JobSeeker(String firstName, String lastName, String username, String password, String email, String phoneNo,
			String jobSeekerDesc,
			// ArrayList<Skill> skillsHeldList, 
			//File fileResume, File fileProfilePic,
			boolean isJobSeekerActive, Date lastLogin
			//, ArrayList<Job> appliedJobsList, ArrayList<CompanyFeedback> feedbackList
			
			) {
		super(firstName, lastName, username, password, email, phoneNo);
		this.jobSeekerDesc = jobSeekerDesc;
		//this.skillsHeldList = skillsHeldList;
		//this.fileResume = fileResume;
		//this.fileProfilePic = fileProfilePic;
		this.isJobSeekerActive = isJobSeekerActive;
		//this.appliedJobsList = appliedJobsList;
		//this.feedbackList = feedbackList;
	}
	public void addFeedback(CompanyFeedback feedback){
		feedbackList.add(feedback);
		feedback.setJobSeeker(this);
	}
	
	public void deleteFeedback(CompanyFeedback feedback){
		feedbackList.remove(feedback);
		feedback.setJobSeeker(null);
	}
	
	public void addSkill(Skill skill){
		skillsHeldList.add(skill);
		skill.getJobSeekerList().add(this);
	}
	
	public void deleteSkill(Skill skill){
		skillsHeldList.remove(skill);
		skill.getJobSeekerList().remove(this);
	}
	
	public void addJobToAppliedJobsList(Job job){
		appliedJobsList.add(job);
	}
	
	public void removeJobFromAppliedJobsList(Job job){
		appliedJobsList.remove(job);
	}
	
	
	//getters
	public String getJobSeekerDesc() {
		return jobSeekerDesc;
	}
	public List<Skill> getSkillsHeldList() {
		return skillsHeldList;
	}
	public boolean isJobSeekerActive() {
		return isJobSeekerActive;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public List<Job> getAppliedJobsList() {
		return appliedJobsList;
	}
	public List<CompanyFeedback> getFeedbackList() {
		return feedbackList;
	}
	public CommonsMultipartFile getProfileResume() {
		return profileResume;
	}
	public String getFilenameResume() {
		return filenameResume;
	}
	public CommonsMultipartFile getProfilePhoto() {
		return profilePhoto;
	}
	public String getFilenamePhoto() {
		return filenamePhoto;
	}
	
	//setters
	public void setJobSeekerDesc(String jobSeekerDesc) {
		this.jobSeekerDesc = jobSeekerDesc;
	}
	public void setSkillsHeldList(List<Skill> skillsHeldList) {
		this.skillsHeldList = skillsHeldList;
	}
	public void setJobSeekerActive(boolean isJobSeekerActive) {
		this.isJobSeekerActive = isJobSeekerActive;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public void setAppliedJobsList(List<Job> appliedJobsList) {
		this.appliedJobsList = appliedJobsList;
	}
	public void setFeedbackList(List<CompanyFeedback> feedbackList) {
		this.feedbackList = feedbackList;
	}
	public void setProfileResume(CommonsMultipartFile profileResume) {
		this.profileResume = profileResume;
	}
	public void setFilenameResume(String filenameResume) {
		this.filenameResume = filenameResume;
	}

	public void setProfilePhoto(CommonsMultipartFile profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
	public void setFilenamePhoto(String filenamePhoto) {
		this.filenamePhoto = filenamePhoto;
	}	
	
	
	
}
