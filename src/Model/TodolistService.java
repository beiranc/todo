package Model;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.TODO;

import Dao.TodolistDao;

public class TodolistService {
	TodolistDao todolistDao = new TodolistDao();
	
	public boolean addTodolist(Todolist todolist) {
		boolean result = false;
		try {
			result = todolistDao.addTodolist(todolist) > 0;
		} catch (Exception e) {
			System.out.println("AddTodolist Service Error ! ");
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean deleteTodolistById(String todolistId) {
		boolean result = false;
		try {
			result = todolistDao.deleteTodolistById(todolistId) > 0;
		} catch (Exception e) {
			System.out.println("DeleteTodolist Service Error ! ");
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean updateTodolist(Todolist todolist) {
		boolean result = false;
		try {
			result = todolistDao.updateTodolist(todolist) > 0;
		} catch (Exception e) {
			System.out.println("UpdateTodolist Service Error ! ");
			e.printStackTrace();
		}
		return result;
	}
	
	public Todolist getTodolistById(String todolistId) {
		Todolist todolist = new Todolist();
		try {
			todolist = todolistDao.getTodolistById(todolistId);
		} catch (Exception e) {
			System.out.println("GetTodolist Service Error ! ");
			e.printStackTrace();
		}
		return todolist;
	}
	
	public List<Todolist> getAllTodolist() {
		List<Todolist> list = new ArrayList();
		try {
			list = todolistDao.getAllTodolist();
		} catch (Exception e) {
			System.out.println("GetAllTodolist Service Error ! ");
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Todolist> getAllTodolistById(String userId) {
		List<Todolist> list = new ArrayList(); 
		try {
			list = todolistDao.getAllTodolistById(userId);
		} catch (Exception e) {
			System.out.println("GetAllTodolistById Service Error ! ");
			e.printStackTrace();
		}
		return list;
	}
}
