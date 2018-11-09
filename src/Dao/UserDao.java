package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Model.Todolist;
import Model.User;
import Util.ConnectionUtil;

public class UserDao {
	ConnectionUtil connectionUtil = new ConnectionUtil();
	
	//增加一个User
	public int addUser(User user) throws Exception {
		Connection connection = connectionUtil.getconn();
		String sql = "INSERT INTO user(userId,userName,password) VALUES(?,?,?)";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, user.getUserId());
		pStatement.setString(2, user.getUserName());
		pStatement.setString(3, user.getPassword());
		
		//result大于0则写入数据成功
		int result = pStatement.executeUpdate();
		return result;
	}
	
	//通过Id查询User
	public User getUserById(String userId) throws Exception {
		Connection connection = connectionUtil.getconn();
		String sql = "SELECT * FROM user WHERE userId=?";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, userId);
		ResultSet resultSet = pStatement.executeQuery();
		User user = new User();
		while(resultSet.next()) {
			user.setUserName(resultSet.getString("userName"));
			user.setPassword(resultSet.getString("password"));
		}
		return user;
	}
	
	//通过用户名查询User
	public User getUserByName(String userName) throws Exception {
		Connection connection = connectionUtil.getconn();
		String sql = "SELECT * FROM user WHERE userName=?";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, userName);
		ResultSet resultSet = pStatement.executeQuery();
		User user = new User();
		while(resultSet.next()) {
			user.setUserId(resultSet.getString("userId"));
			user.setPassword(resultSet.getString("password"));
		}
		return user;
	}
}
