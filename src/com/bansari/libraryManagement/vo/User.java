package com.bansari.libraryManagement.vo;

public class User {

	private int userId;
	private String userName;
	private String password;
	private boolean admin;
	private String emailId;
	private Long phone;
	
	public User() {
		super();
	}

	public User(int userId, String userName, boolean admin, String emailId, Long phone) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.admin = admin;
		this.emailId = emailId;
		this.phone = phone;
	}

	public User(int userId) {
		this.userId=userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}
	
	
}
