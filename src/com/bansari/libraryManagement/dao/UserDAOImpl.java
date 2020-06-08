package com.bansari.libraryManagement.dao;

import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.bansari.libraryManagement.vo.User;

@Service
public class UserDAOImpl implements UserDAO {

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

	public UserDAOImpl() {
		super();
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public User getLoginUserDetails(String userName, String password) {

		String selectSqlLogin = "select * from User where userName=" + userName + " and password=" + password + "";

		@SuppressWarnings("unchecked")
		List<User> userDetails = this.jdbcTemplate.query(selectSqlLogin, (rs, rowNum) -> new User(rs.getInt("userId"),
				rs.getString("userName"), rs.getBoolean("admin"), rs.getString("emailId"), rs.getLong("phone")));

		if (userDetails != null && userDetails.size() > 0) {
			return userDetails.get(0);
		}
		return null;
	}

	@Override
	public void addNewUser(User user) {

		String InsertUserSql = "INSERT INTO user (userName, password, emailId, phone, admin) values(?, ?, ?, ?, false)";
		Object[] userObjForSql = new Object[] { user.getUserName(), user.getPassword(), user.getEmailId(),
				user.getPhone() };
		int[] columnDataTypes = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER };

		this.jdbcTemplate.update(InsertUserSql, userObjForSql, columnDataTypes);
	}

	@Override
	public List<User> getAllUsers() {

		String selectSql = "select * from User where admin=0";

		@SuppressWarnings("unchecked")
		List<User> userDetails = this.jdbcTemplate.query(selectSql, (rs, rowNum) -> new User(rs.getInt("userId"),
				rs.getString("userName"), rs.getBoolean("admin"), rs.getString("emailId"), rs.getLong("phone")));

		return userDetails;
	}

	@Override
	public User getSelectedUsedDetails(int userId) {

		String selectSqlLogin = "select * from User where userId='" + userId + "'";

		@SuppressWarnings("unchecked")
		List<User> userDetails = this.jdbcTemplate.query(selectSqlLogin, (rs, rowNum) -> new User(rs.getInt("userId"),
				rs.getString("userName"), rs.getBoolean("admin"), rs.getString("emailId"), rs.getLong("phone")));

		if (userDetails != null) {
			return userDetails.get(0);
		}
		return null;
	}
}
