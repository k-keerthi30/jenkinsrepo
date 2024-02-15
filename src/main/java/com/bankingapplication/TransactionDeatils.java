package com.bankingapplication;

import java.util.Date;

public class TransactionDeatils {

	// id,date,amount,category,userid,parties

	private Integer transactionId;
	private String transactionDate;
	private Integer recipentPhoneNumber;
	private double transactionAmount;
	private String transactionCategory;
	private String transactionBetween;
	

	public TransactionDeatils() {
		// TODO Auto-generated constructor stub
	}


	public TransactionDeatils(String transactionDate, Integer recipentPhoneNumber,
			double transactionAmount, String transactionCategory, String transactionBetween) {
		super();
		
		this.transactionDate = transactionDate;
		this.recipentPhoneNumber = recipentPhoneNumber;
		this.transactionAmount = transactionAmount;
		this.transactionCategory = transactionCategory;
		this.transactionBetween = transactionBetween;
	}


	public Integer getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}


	public String getTransactionDate() {
		return transactionDate;
	}


	public void setTransactionDate() {
		this.transactionDate = transactionDate;
	}


	public Integer getRecipentPhoneNumber() {
		return recipentPhoneNumber;
	}


	public void setRecipentPhoneNumber(Integer recipentPhoneNumber) {
		this.recipentPhoneNumber = recipentPhoneNumber;
	}


	public double getTransactionAmount() {
		return transactionAmount;
	}


	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}


	public String getTransactionCategory() {
		return transactionCategory;
	}


	public void setTransactionCategory(String transactionCategory) {
		this.transactionCategory = transactionCategory;
	}


	public String getTransactionBetween() {
		return transactionBetween;
	}


	public void setTransactionBetween(String transactionBetween) {
		this.transactionBetween = transactionBetween;
	}


	@Override
	public String toString() {
		return "TransactionDeatils [transactionId=" + transactionId + ", transactionDate=" + transactionDate
				+ ", recipentPhoneNumber=" + recipentPhoneNumber + ", transactionAmount=" + transactionAmount
				+ ", transactionCategory=" + transactionCategory + ", transactionBetween=" + transactionBetween + "]";
	}
	
	
}
