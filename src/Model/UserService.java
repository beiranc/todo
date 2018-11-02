package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Dao.UserDao;

public class UserService {
	UserDao userDao = new UserDao();
	
	public boolean addUser(User user) {
		boolean result = false;
		try {
			result = userDao.addUser(user) > 0;
		} catch (Exception e) {
			System.out.println("AddUser Service Error ! ");
			e.printStackTrace();
		}
		return result;
	}
	
	public User getUserById(String userId) {
		User user = new User();
		try {
			user = userDao.getUserById(userId);
		} catch (Exception e) {
			System.out.println("GetUser Service Error ! ");
			e.printStackTrace();
		}
		return user;
	}
}
