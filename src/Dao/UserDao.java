package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
