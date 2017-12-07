package com.sanket.ipropel.utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sanket.ipropel.beans.User;

public class UserUtility {

	public String getLoggedInUserEmail(){
		
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		System.out.println("Printing session object from ServletRequestAttributes---"+ session.getId());
		
		try{
		User user = (User) session.getAttribute("User");
		System.out.println("Printing user object in utility---"+ user);

		String loggedInUserEmail = user.getEmail(); 
		System.out.println("Printing loggedInUserEmail---"+ loggedInUserEmail);
		
		return loggedInUserEmail;
		}catch(HibernateException e){
			System.out.println("catch in getLoggedInUserEmail");
			e.printStackTrace();
			return null;
		}
		
		
	}
}
