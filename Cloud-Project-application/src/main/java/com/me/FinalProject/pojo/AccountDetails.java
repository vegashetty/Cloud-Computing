package com.me.FinalProject.pojo;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="accountDetails")
public class AccountDetails {
	@Id
	@Column(name = "accountNo", unique = true, nullable = false)
	private long accountNo;
	@Column(name="accountType",nullable=false)
	private String accountType;
	@Column(name="balance")
	private float balance;
	@JoinColumn(name="userId")
	private String userId;
	
	
	@ManyToOne
	private User user;
	
	public AccountDetails() {
	}
	public AccountDetails(long accountNo, String accountType, float balance, String userId, User user) {
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.balance = balance;
		this.userId = userId;
		this.user = user;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
