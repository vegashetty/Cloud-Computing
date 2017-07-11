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


@Entity
@Table(name="BalanceDetails")
public class BalanceDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "descriptionId", unique = true, nullable = false)
	int descriptionId;
	@Column(name="amountDeducted")
	float amountDeducted;
	@Column(name="availableBalance")
	float availableBalance;
	@Column(name="OnDate")
	
	private Date orderDate;
	
	@Column(name="description")
	private String description;
	
	@JoinColumn(name="userId")
	private String userId;
	
	
	
	public BalanceDetails(int descriptionId, float amountDeducted, float availableBalance, Date orderDate,String userId,String description) {
		this.descriptionId = descriptionId;
		this.amountDeducted = amountDeducted;
		this.availableBalance = availableBalance;
		this.orderDate = orderDate;
		this.userId = userId;
		
		this.description = description;
	}

	public BalanceDetails() {
		
	}

	public int getDescriptionId() {
		return descriptionId;
	}

	public void setDescriptionId(int descriptionId) {
		this.descriptionId = descriptionId;
	}

	public float getAmountDeducted() {
		return amountDeducted;
	}

	public void setAmountDeducted(float amountDeducted) {
		this.amountDeducted = amountDeducted;
	}

	public float getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(float availableBalance) {
		this.availableBalance = availableBalance;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
