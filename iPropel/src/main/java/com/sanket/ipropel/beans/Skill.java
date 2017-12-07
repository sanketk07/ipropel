package com.sanket.ipropel.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SKILL")
public class Skill {
	
	@Id
	@GeneratedValue
	@Column(name = "SKILLID")
	private int skillId;
	
	@Column(name = "SKILLNAME")
	private String skillName;
	
	@Column(name = "SKILLDESC")
	private String skillDescription;
	
	@Column(name = "SKILLPROFICIENCY")
	private String skillProficiency;
	
	@ManyToMany(mappedBy = "skillsHeldList", fetch = FetchType.EAGER)
	private List<JobSeeker> jobSeekerList = new ArrayList<JobSeeker>();
	
	/**
	 * Default Constructor
	 */
	public Skill() {
	}
	/**
	 * @param skillName
	 * @param skillDescription
	 * @param skillProficiency
	 */
	public Skill(String skillName, String skillDescription, String skillProficiency) {
		this.skillName = skillName;
		this.skillDescription = skillDescription;
		this.skillProficiency = skillProficiency;
	//	this.jobSeekerList = jobSeekerList;
	}
	/**
	 * @return the skillId
	 */
	public int getSkillId() {
		return skillId;
	}
	/**
	 * @param skillId the skillId to set
	 */
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	/**
	 * @return the skillName
	 */
	public String getSkillName() {
		return skillName;
	}
	/**
	 * @param skillName the skillName to set
	 */
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	/**
	 * @return the skillDescription
	 */
	public String getSkillDescription() {
		return skillDescription;
	}
	/**
	 * @param skillDescription the skillDescription to set
	 */
	public void setSkillDescription(String skillDescription) {
		this.skillDescription = skillDescription;
	}
	/**
	 * @return the skillProficiency
	 */
	public String getSkillProficiency() {
		return skillProficiency;
	}
	/**
	 * @param skillProficiency the skillProficiency to set
	 */
	public void setSkillProficiency(String skillProficiency) {
		this.skillProficiency = skillProficiency;
	}
	/**
	 * @return the jobSeekerList
	 */
	public List<JobSeeker> getJobSeekerList() {
		return jobSeekerList;
	}
	/**
	 * @param jobSeekerList the jobSeekerList to set
	 */
	public void setJobSeekerList(List<JobSeeker> jobSeekerList) {
		this.jobSeekerList = jobSeekerList;
	}
	
	//jobSeekerList
		public void addJobSeekers(JobSeeker js){
			jobSeekerList.add(js);
			
		}
		
		public void removeJobSeeker(JobSeeker js){
			jobSeekerList.remove(js);
		}

}
