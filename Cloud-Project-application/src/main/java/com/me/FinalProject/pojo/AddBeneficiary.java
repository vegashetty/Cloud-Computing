package com.me.FinalProject.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AddBeneficiary")
public class AddBeneficiary {
	@Id
	@Column(name="toAccountNo")
	private long toAccountNo;
	@Column(name="fromAccountNo")
	private long fromAccountNo;
	@Column(name="userId")
	private String userID;
	
	
	
	
	
	
	public AddBeneficiary(long toAccountNo, long fromAccountNo,String userID) {
		this.toAccountNo = toAccountNo;
		this.fromAccountNo = fromAccountNo;
		this.userID = userID;
	}




	public AddBeneficiary() {
		
	}




	public String getUserID() {
		return userID;
	}




	public void setUserID(String userID) {
		this.userID = userID;
	}




	public long getToAccountNo() {
		return toAccountNo;
	}




	public void setToAccountNo(long toAccountNo) {
		this.toAccountNo = toAccountNo;
	}




	public long getFromAccountNo() {
		return fromAccountNo;
	}




	public void setFromAccountNo(long fromAccountNo) {
		this.fromAccountNo = fromAccountNo;
	}

	
	
	
	

}
