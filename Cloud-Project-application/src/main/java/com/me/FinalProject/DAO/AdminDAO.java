package com.me.FinalProject.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.me.FinalProject.pojo.User;

public class AdminDAO extends DAO {

	public AdminDAO() {

	}

	public User saveUser(String firstName, String lastName, String email, String address, int zipCode, String category,
			String userID,String status) throws Exception {
		try {
			begin();
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setAddress(address);
			user.setZipCode(zipCode);
			user.setCategory(category);
			user.setUserID(userID);
			user.setBlockStatus(status);
			user.setPassword("241289");
			getSession().save(user);
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("user cannot be saved", e);
		}

	}
	
	public int updatePassword(String userID,String oldPassword,String newPassword,String securityAns) throws Exception{
		try{
			begin();
			Query query = getSession().createQuery("Update User set password= :password, securityAns= :securityAns where userID= :userID");
			query.setString("password",newPassword);
			query.setString("securityAns", securityAns);
			query.setString("userID",userID );
			
			
			int result = query.executeUpdate();
			commit();
			return result;
		}catch(HibernateException e){
			rollback();
			throw new Exception("Password cannot be updated",e);
		}
	}
	
	public int blockUser(String userID) throws Exception{
		try{
			begin();
			Query query = getSession().createQuery("Update User set blockStatus= 'N' where userID= :userID");
			query.setString("userID", userID);
			int result = query.executeUpdate();
			commit();
			return result;
		}catch(HibernateException e){
			rollback();
			throw new Exception("Cannot Block User, e");
		}
	}
	
	public int forgotPassword(String userID,String newPassword,String securityAns) throws Exception{
		try{
			begin();
			
			Query query = getSession().createQuery("Update User set password= :password where securityAns= :securityAns and userID= :userID");
			query.setString("password",newPassword);
			query.setString("userID",userID );
			query.setString("securityAns", securityAns);
			
			
			int result = query.executeUpdate();
			commit();
			return result;
		}catch(HibernateException e){
			rollback();
			throw new Exception("Password cannot be updated",e);
		}
	}
	
}
