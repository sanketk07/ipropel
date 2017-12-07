package com.sanket.ipropel.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sanket.ipropel.beans.Company;
import com.sanket.ipropel.beans.Job;
import com.sanket.ipropel.exception.UserException;

public class CompanyDAO extends DAO {

	public List<Company> fetchCompanyList() throws Exception {
		try {
			Transaction transaction = getSession().beginTransaction();
			Session session = getSession();

			Query q = null;
			List<Company> companies = null;
			q = session.createQuery("from Company");
			companies = q.list();
			commit();

			/*
			 * for(Company c : companies) { System.out.println("title:"+
			 * c.getCompanyName()); }
			 */
			close();
			return companies;
		} catch (HibernateException e) {
			rollback();
			// throw new MovieException("Could not find movie", e);
			e.printStackTrace();
			return null;
		}

	}

	public boolean saveCompany(Company company) throws UserException {

		boolean companyFlag = false;
		try {
			begin();
			System.out.println("Inside try in saveCompany - CompanyDAO");

			if (company != null) {
				getSession().save(company);
				companyFlag = true;
				commit();
			} else {

				companyFlag = false;
			}
			close();
		} catch (HibernateException e) {
			System.out.println("Inside catch in create user - UserDAO");
			companyFlag = false;
			rollback();
			throw new UserException("Exception while saving User data: " + e.getMessage());
		}
		return companyFlag;
	}

	public Company fetchCompanyFromCompanyName(String companyName) {

		try {
			Transaction transaction = getSession().beginTransaction();
			Company company = new Company();

			Query query = getSession().createQuery("from Company where companyName = :cn");
			query.setString("cn", companyName);

			company = (Company) query.uniqueResult();

			System.out.println("company from company name - CompanyDAO: " + company);

			close();
			return company;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}

}
