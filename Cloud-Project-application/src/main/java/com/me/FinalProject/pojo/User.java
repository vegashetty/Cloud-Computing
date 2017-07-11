package com.me.FinalProject.pojo;


import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@PrimaryKeyJoinColumn(name="personId")
public class User extends Person {
	
	
	@Column(name = "userId", unique = true, nullable = true)
	private String userID;
	@Column(name = "password")
	private String password;
	@Column(name = "category")
	private String category;
	
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="user")
	private Set<AccountDetails> accountDetails = new HashSet<AccountDetails>();
	 @Column(name= "block_status")
      private String blockStatus;
	 @Column(name = "securityAns")
	 private String securityAns;
	 @OneToMany
	 private Set<TranferDetails>transferDetails = new HashSet<TranferDetails>();
	 @OneToMany
	 private Set<BalanceDetails>balanceDetails = new HashSet<BalanceDetails>();
	public User() {

	}





	public User( String userID, String password, String category,
			Set<AccountDetails> accountDetails ,String blockStatus,
			String securityAns) {
		
		this.userID = userID;
		this.password = password;
		this.category = category;
	this.accountDetails = accountDetails;
	this.blockStatus = blockStatus;
	this.securityAns = securityAns;
	
	}




	public Set<BalanceDetails> getBalanceDetails() {
		return balanceDetails;
	}





	public void setBalanceDetails(Set<BalanceDetails> balanceDetails) {
		this.balanceDetails = balanceDetails;
	}





	public Set<AccountDetails> getAccountDetails() {
		return accountDetails;
	}





	public void setAccountDetails(Set<AccountDetails> accountDetails) {
		this.accountDetails = accountDetails;
	}





	public Set<TranferDetails> getTransferDetails() {
		return transferDetails;
	}





	public void setTransferDetails(Set<TranferDetails> transferDetails) {
		this.transferDetails = transferDetails;
	}





	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}





	public String getBlockStatus() {
		return blockStatus;
	}





	public void setBlockStatus(String blockStatus) {
		this.blockStatus = blockStatus;
	}





	public String getSecurityAns() {
		return securityAns;
	}





	public void setSecurityAns(String securityAns) {
		this.securityAns = securityAns;
	}


	


	
	
	

}
