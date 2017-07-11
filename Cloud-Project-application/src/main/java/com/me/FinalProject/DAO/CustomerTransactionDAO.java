package com.me.FinalProject.DAO;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.FinalProject.pojo.AccountDetails;
import com.me.FinalProject.pojo.AddBeneficiary;
import com.me.FinalProject.pojo.BalanceDetails;
import com.me.FinalProject.pojo.TranferDetails;
import com.me.FinalProject.pojo.User;

public class CustomerTransactionDAO extends DAO {
	public CustomerTransactionDAO(){
		
	}
	
	public List<Object[]> getCustomerBalance(User user) throws Exception{
		try{
			begin();
			Query query = getSession().createQuery("select ac.accountType,ac.balance from AccountDetails ac where ac.userId = :userId");
			query.setString("userId", user.getUserID());
			List<Object[]> ac =(List<Object[]>) query.list();
			System.out.println("PASS");
			
			commit();
			System.out.println("You");
			return ac;
		}catch(HibernateException e){
			throw new Exception(e);
		}
	}
	
	public List getCustomerAcNO(String userId) throws Exception{
		try{
			begin();
			Query query = getSession().createQuery(" from AccountDetails ac where ac.userId = :userId");
			query.setString("userId", userId);
			List ac = query.list();
			System.out.println("PASS");
			
			commit();
			System.out.println("You");
			return ac;
		}catch(HibernateException e){
			throw new Exception(e);
		}
	}
	public AddBeneficiary addBeneficary(String userID,long fromAC,long addAccount) {
		try{
		begin();
		AddBeneficiary ad = new AddBeneficiary();
		ad.setFromAccountNo(fromAC);
		ad.setToAccountNo(addAccount);
		ad.setUserID(userID);
		System.out.println("Yo are at DAO");
		getSession().save(ad);
		System.out.println("Yo are at DAO");
		commit();
		return ad;
	} catch (HibernateException e) {
		rollback();
		return null;
	}
		
	}
	public List addBenefica(String userID){
		try{
			begin();
			Query query = getSession().createQuery("from AddBeneficiary where userID = :userID");
			query.setString("userID", userID);
			List list = query.list();
			commit();
			return list;
		}catch(HibernateException e){
			rollback();
			System.out.println(e);
			return null;
		}
	}
	public TranferDetails saveTransfer(long fromAC,long toAc,float amount,String description,String id){
		try{
			begin();
			TranferDetails ts = new TranferDetails();
			//ts.setTranferID(1);
			ts.setDescription(description);
			ts.setFromAccountNo(fromAC);
			ts.setToAccountNo(toAc);
			ts.setTransferredAmount(amount);
			ts.setUserId(id);
			getSession().save(ts);
			commit();
			return ts;
		}catch(HibernateException e){
			rollback();
			System.out.println(e);
			return null;
		}
	}
	public BalanceDetails addtransferDetails(String description,float ad,float am,String id){
		try{
			begin();
			BalanceDetails bd = new BalanceDetails();
			bd.setDescription(description);
			bd.setAmountDeducted(ad);
			bd.setAvailableBalance(am);
			bd.setUserId(id);
			getSession().save(bd);
			commit();
			return bd;
		}catch(HibernateException e){
			rollback();
			System.out.println(e);
			return null;
		}
		
		
	}
}
