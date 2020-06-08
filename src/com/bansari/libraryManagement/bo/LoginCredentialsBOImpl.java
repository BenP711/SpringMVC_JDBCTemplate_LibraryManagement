package com.bansari.libraryManagement.bo;

import static com.bansari.libraryManagement.constant.UserLoginConstants.LOGIN_USER_NAME_SESSION_ATTR;
import static com.bansari.libraryManagement.constant.UserLoginConstants.PASSWORD_SESSION_ATTR;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class LoginCredentialsBOImpl implements LoginCredentialsBO {

	@Override
	public boolean checkLoginUser(HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute(LOGIN_USER_NAME_SESSION_ATTR);
		String password = (String) request.getSession().getAttribute(PASSWORD_SESSION_ATTR);

		if (userName != null && password != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void logOut(HttpServletRequest request) {
		request.getSession().invalidate();
	}

}
