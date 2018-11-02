package Model;

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
}
