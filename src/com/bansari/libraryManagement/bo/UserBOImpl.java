package com.bansari.libraryManagement.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bansari.libraryManagement.dao.UserDAO;
import com.bansari.libraryManagement.vo.User;

@Service
public class UserBOImpl implements UserBO {

	@Autowired
	UserDAO userDAO;
	
	public UserBOImpl() {
		super();
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}



	@Override
	public User getLoginUserDetails(String userName, String password) {
		return this.userDAO.getLoginUserDetails(userName, password);
	}

	@Override
	public void addNewUser(User user) {
		this.userDAO.addNewUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return this.userDAO.getAllUsers();
	}

	@Override
	public User getSelectedUsedDetails(int userId) {
		return this.userDAO.getSelectedUsedDetails(userId);
	}

}
