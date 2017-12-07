package com.sanket.ipropel.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sanket.ipropel.beans.Company;
import com.sanket.ipropel.beans.Skill;

public class SkillDAO extends DAO{
	
	public List<Skill> fetchSkillList() throws Exception {
		try {
			begin();
			Session session = getSession();

			Query q = null;
			List<Skill> skills = null;
			q = session.createQuery("from Skill");
			skills = q.list();
			commit();
			
			for(Skill s : skills) { 
				 System.out.println("Skill DAO - Skill Name:"+ s.getSkillName()); 
			}
			 
			close();
			return skills;
		} catch (HibernateException e) {
			rollback();
			// throw new MovieException("Could not find skill", e);
			e.printStackTrace();
			return null;
		}

	}
	
	public Skill fetchSkillFromName(String skillName) throws Exception {
		try {
			begin();
			Session session = getSession();

			Query q = null;
			Skill skill = null;
			q = session.createQuery("from Skill where skillName = :sn");
			q.setString("sn", skillName);
			skill = (Skill) q.uniqueResult();
			System.out.println("Printing Skill details in DAO---" + skill.getSkillName() + " "+ skill.getSkillDescription());
			commit();			
			
			close();
			return skill;
		} catch (HibernateException e) {
			rollback();
			// throw new MovieException("Could not find skill", e);
			e.printStackTrace();
			return null;
		}

	}


}
