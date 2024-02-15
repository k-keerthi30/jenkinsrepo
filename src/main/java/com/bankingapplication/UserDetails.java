package com.bankingapplication;

public class UserDetails {
 
	private Integer userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private Integer userPhoneNumber;
	private double userBalance;
	
	
	public UserDetails() {
		// TODO Auto-generated constructor stub
	}


	public UserDetails(String userName, String userEmail, String userPassword, Integer userPhoneNumber,
			double userBalance) {
		super();
		
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhoneNumber = userPhoneNumber;
		this.userBalance = userBalance;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public Integer getUserPhoneNumber() {
		return userPhoneNumber;
	}


	public void setUserPhoneNumber(Integer userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}


	public double getUserBalance() {
		return userBalance;
	}


	public void setUserBalance(double userBalance) {
		this.userBalance = userBalance;
	}


	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userPassword=" + userPassword + ", userPhoneNumber=" + userPhoneNumber + ", userBalance="
				+ userBalance + "]";
	}

	
}

