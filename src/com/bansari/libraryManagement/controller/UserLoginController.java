package com.bansari.libraryManagement.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bansari.libraryManagement.bo.LoginCredentialsBO;
import com.bansari.libraryManagement.bo.UserBO;
import com.bansari.libraryManagement.vo.User;
import static com.bansari.libraryManagement.constant.UserLoginConstants.*;


@Controller
public class UserLoginController {

	@Autowired
	UserBO userBO;
	
	@Autowired
	LoginCredentialsBO loginCredentialsBO;

	public UserLoginController() {
		super();
	}

	

	// Display Home Page (Login page)
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String displayLoginPage(Model model) {

		User user = new User();
		model.addAttribute(USER_OBJ, user);
		return LOGIN_VIEW;
	}

	// Display User Registration Page POST
	@RequestMapping(value = "/signUp", params = "signUp", method = { RequestMethod.POST, RequestMethod.GET })
	public String goToSignUpForm(@ModelAttribute User user, Model model) {

		model.addAttribute(USER_OBJ, user);
		return USER_REGISTRATION_VIEW;
	}

	// Display login page after registration POST
	@RequestMapping(value = "/loginPage", params = "signUp", method = RequestMethod.POST)
	public String addNewUserPOST(@ModelAttribute User user, Model model) {

		this.userBO.addNewUser(user);
		return LOGIN_VIEW;
	}

	// Successful login, display respective home page using POST
	@RequestMapping(value = "/homePage", params = "signIn", method = RequestMethod.POST)
	public String getLoginUserDetails(@RequestParam("userName") String userName,
			@RequestParam("password") String password, Model model, HttpSession session) {

		User loginUser = this.userBO.getLoginUserDetails(userName, password);

		if (loginUser != null) {
			
			session.setAttribute(LOGIN_USER_NAME_SESSION_ATTR, loginUser.getUserName());
			session.setAttribute(PASSWORD_SESSION_ATTR, password);
			
			model.addAttribute(USER_OBJ, loginUser);
			
			if (loginUser.isAdmin())
				return ADMIN_HOME_PAGE_VIEW;
			else
				return CUSTOMER_HOME_PAGE_VIEW;
		} else {
			return LOGIN_VIEW;
		}
	}

	// Successful login, display respective home page using GET
	@RequestMapping(value = "/homePage", method = RequestMethod.GET)
	public String getLoginUserDetails(@ModelAttribute User user, Model model, HttpServletRequest request) {

		boolean loginCheck = this.loginCredentialsBO.checkLoginUser(request);

		if (loginCheck) {
			
			String userName = (String) request.getSession().getAttribute(LOGIN_USER_NAME_SESSION_ATTR);
			String password = (String) request.getSession().getAttribute(PASSWORD_SESSION_ATTR);
			
			User loginUser = this.userBO.getLoginUserDetails(userName, password);
			model.addAttribute(USER_OBJ, loginUser);
			
			if (loginUser != null && loginUser.isAdmin())
				return ADMIN_HOME_PAGE_VIEW;
			else
				return CUSTOMER_HOME_PAGE_VIEW;
		} else {
			return LOGIN_VIEW;
		}
	}

	/*
	 * // Successful login, display respective home page using GET
	 * 
	 * @RequestMapping(value = "/adminHomePage", method = RequestMethod.GET) public
	 * String getLoginAdminDetailsGET(@ModelAttribute User user, Model model,
	 * HttpServletRequest request) {
	 * 
	 * String userName = (String)
	 * request.getSession().getAttribute(LOGIN_USER_NAME_SESSION_ATTR); String
	 * password = (String) request.getSession().getAttribute(passwordSessionAttr);
	 * 
	 * if(userName != null && password != null) { model.addAttribute(userObj, user);
	 * return adminHomePageView; }else { return loginView; }
	 * 
	 * }
	 * 
	 * // Successful login, display respective home page using GET
	 * 
	 * @RequestMapping(value = "/customerHomePage", method = RequestMethod.GET)
	 * public String getLoginUserDetailsGET(@ModelAttribute User user, Model model,
	 * HttpServletRequest request) {
	 * 
	 * String userName = (String)
	 * request.getSession().getAttribute(LOGIN_USER_NAME_SESSION_ATTR); String
	 * password = (String) request.getSession().getAttribute(passwordSessionAttr);
	 * 
	 * if(userName != null && password != null) { model.addAttribute(userObj, user);
	 * return customerHomePageView; }else { return loginView; } }
	 */
	
	public UserBO getUserBO() {
		return userBO;
	}

	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
	}

	public LoginCredentialsBO getLoginCredentialsBO() {
		return loginCredentialsBO;
	}

	public void setLoginCredentialsBO(LoginCredentialsBO loginCredentialsBO) {
		this.loginCredentialsBO = loginCredentialsBO;
	}
}
