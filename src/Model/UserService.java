package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Dao.UserDao;

public class UserService {
	UserDao userDao = new UserDao();
	
	//增加一个User
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
	
	//通过Id查询User
	public User getUserById(String userId) {
		User user = new User();
		try {
			user = userDao.getUserById(userId);
		} catch (Exception e) {
			System.out.println("GetUserById Service Error ! ");
			e.printStackTrace();
		}
		return user;
	}
	
	//通过用户名查询User
	public User getUserByName(String userName) {
		User user = new User();
		try {
			user = userDao.getUserByName(userName);
		} catch (Exception e) {
			System.out.println("GetUserByName Service Error ! ");
			e.printStackTrace();
		}
		return user;
	}
	
	//通过用户名检查User是否存在
	public boolean checkUserByName(String userName) throws Exception {
		boolean result = false;
		try {
			//true则存在, false则不存在
			result = userDao.checkUserByName(userName) > 0;
		} catch (Exception e) {
			System.out.println("CheckUserByname Service Error ! ");
			e.printStackTrace();
		}
		return result;
	}
}
