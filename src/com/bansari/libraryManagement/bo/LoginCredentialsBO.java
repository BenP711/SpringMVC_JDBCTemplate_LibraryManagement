package com.bansari.libraryManagement.bo;

import javax.servlet.http.HttpServletRequest;

public interface LoginCredentialsBO {

	public boolean checkLoginUser(HttpServletRequest request);
	
	public void logOut(HttpServletRequest request);
}
