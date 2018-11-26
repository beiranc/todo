package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Dao.UserDao;

public class UserService {
	UserDao userDao = new UserDao();
	
	//����һ��User
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
	
	//ͨ��Id��ѯUser
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
	
	//ͨ���û�����ѯUser
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
	
	//ͨ���û������User�Ƿ����
	public boolean checkUserByName(String userName) throws Exception {
		boolean result = false;
		try {
			//true�����, false�򲻴���
			result = userDao.checkUserByName(userName) > 0;
		} catch (Exception e) {
			System.out.println("CheckUserByname Service Error ! ");
			e.printStackTrace();
		}
		return result;
	}
}
