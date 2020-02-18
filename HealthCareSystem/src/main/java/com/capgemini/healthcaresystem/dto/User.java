package com.capgemini.healthcaresystem.dto;

import java.util.List;

public class User {
	private String userId, userPassword, userRole, userName, emailId, contactNo;
	public List<DiagnosticCenter> centerList;
	
	
	public User(String userId, String userPassword, String userRole, String userName, String emailId, String contactNo) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userRole = userRole;
		this.userName = userName;
		this.emailId = emailId;
		this.contactNo = contactNo;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEamilId(String emailId) {
		this.emailId = emailId;
	}
	public List<DiagnosticCenter> getCenterList() {
		return centerList;
	}
	public void setCenterList(List<DiagnosticCenter> centerList) {
		this.centerList = centerList;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	
}
