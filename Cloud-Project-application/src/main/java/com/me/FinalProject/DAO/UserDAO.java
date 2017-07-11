package com.me.FinalProject.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.me.FinalProject.pojo.User;

public class UserDAO extends DAO{
	
	public UserDAO(){
	}
	UserDAO userDAO;
	
	
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public User getCredentialsValidated(String username,String password) throws Exception{
		try{
			begin();
			Query q = getSession().createQuery("from User where userID = :userID and password = :password and blockStatus ='N'");
			q.setString("userID", username);
			q.setString("password", password);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		}catch(HibernateException e){
			rollback();
			throw new Exception("Cannot find the user with userID" + username,e);
		}
	}
}
