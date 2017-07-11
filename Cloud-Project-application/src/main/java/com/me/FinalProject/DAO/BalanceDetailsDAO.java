package com.me.FinalProject.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.FinalProject.pojo.User;

public class BalanceDetailsDAO extends DAO {
	
	public BalanceDetailsDAO(){
		
	}
	
	public List getBalanceDetails(String userId) throws Exception{
		try{
			begin();
			Query query = getSession().createQuery(" from BalanceDetails bd where bd.userId = :userId ORDER BY orderDate DESC");
			query.setString("userId", userId);
			List bd = query.list();
			System.out.println("PASS");
			
			commit();
			System.out.println("You");
			return bd;
		}catch(HibernateException e){
			throw new Exception(e);
		}
	}

}
