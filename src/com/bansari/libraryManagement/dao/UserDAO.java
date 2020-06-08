package com.bansari.libraryManagement.dao;

import java.util.List;

import com.bansari.libraryManagement.vo.User;

public interface UserDAO {

	public User getLoginUserDetails(String userName, String password);

	public void addNewUser(User user);

	public List<User> getAllUsers();

	public User getSelectedUsedDetails(int userId);

}
