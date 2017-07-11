package com.me.FinalProject.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="TransferDetails")

public class TranferDetails{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "transferID", unique = true, nullable = true)
	private long tranferID;
	@Column(name="toAccountNo")
	private long toAccountNo;
	@Column(name="fromAccountNo")
	private long fromAccountNo;
	@Column(name="transferDate")
	@Temporal(TemporalType.DATE)
	private Date tranferDate;
	@Column(name="transferredAmount")
	private float transferredAmount;
	@Column(name="description")
	private String description; 
	@JoinColumn(name="userId")
	private String userId;
	
	
	public TranferDetails(long tranferID, long toAccountNo, long fromAccountNo, Date tranferDate,
			float transferredAmount,String description,String userId) {
		this.tranferID = tranferID;
		this.toAccountNo = toAccountNo;
		this.fromAccountNo = fromAccountNo;
		this.tranferDate = tranferDate;
		this.transferredAmount = transferredAmount;
		this.description = description;
		
		this.userId = userId;
	}

	public TranferDetails(){
		
	}
	
	public long getTranferID() {
		return tranferID;
	}

	public void setTranferID(long tranferID) {
		this.tranferID = tranferID;
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

	public Date getTranferDate() {
		return tranferDate;
	}
	public void setTranferDate(Date tranferDate) {
		this.tranferDate = tranferDate;
	}
	public float getTransferredAmount() {
		return transferredAmount;
	}
	public void setTransferredAmount(float transferredAmount) {
		this.transferredAmount = transferredAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
