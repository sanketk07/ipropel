package com.sanket.ipropel.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sanket.ipropel.beans.Company;
import com.sanket.ipropel.beans.Message;
import com.sanket.ipropel.beans.User;

public class MessageDAO extends DAO{

	public boolean sendMessage(Message message) throws Exception {
		
		boolean messageSent=false;
		try {
			begin();
			
			if (message != null) {
				getSession().save(message);
				messageSent = true;
				commit();
			} else {

				messageSent = false;
			}
			close();
			return messageSent;
		} catch (HibernateException e) {
			rollback();
			// throw new MovieException("Could not find movie", e);
			e.printStackTrace();
			return false;
		}

	}
	
	public List<Message> fetchUserMessages(User user) throws Exception {
		try {
			begin();
			
			String userEmail = user.getEmail();

			Query q = null;
			List<Message> messages = null;
			q = getSession().createQuery("from Message where messageRecipient = :ue order by messageReceivedTime desc");
			q.setString("ue", userEmail);
			messages = q.list();
			commit();

			close();
			return messages;
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
			return null;
		}

	}
	
	/*int numRecordPerPage = 5;
	int pageNo;

	select id, name, password from student limit numRecordPerPage offset (pageNo-1)* numRecordPerPage;*/
	public List<Message> fetchUserMessagesPagination(User user, int pageNo) throws Exception {
		try {
			begin();
			
			String userEmail = user.getEmail();
			int numRecordPerPage = 5;
			//int pageNo;

			Query q = null;
			List<Message> messages = null;
			q = getSession().createQuery("from Message where messageRecipient = :ue order by messageReceivedTime desc");
			q.setString("ue", userEmail);
			//q.setInteger("offsetValue", );
			q.setFirstResult((pageNo-1)*5);
			q.setMaxResults(5);
			
			messages = q.list();
			commit();

			close();
			return messages;
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
			return null;
		}

	}
	
	
}
