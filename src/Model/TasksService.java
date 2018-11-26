package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.TasksDao;

public class TasksService {
	TasksDao tasksDao = new TasksDao();
	
	public boolean addTasks(Tasks tasks) {
		boolean rusult = false;
		try {
			rusult = tasksDao.addTasks(tasks) > 0;
		} catch (Exception e) {
			System.out.println("AddTasks Service Error ! ");
			e.printStackTrace();
		}
		return rusult;
	}
	
	public boolean deleteTasksById(String tasksId) {
		boolean result = false;
		try {
			result = tasksDao.deleteTasksById(tasksId) > 0;
		} catch (Exception e) {
			System.out.println("DeleteTasks Service Error ! ");
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean updateTasks(Tasks tasks) {
		boolean result = false;
		try {
			result = tasksDao.updateTasks(tasks) > 0;
		} catch (Exception e) {
			System.out.println("UpdateTasks Service Error ! ");
			e.printStackTrace();
		}
		return result;
	}
	
	public Tasks getTasksById(String tasksId) {
		Tasks tasks = new Tasks();
		try {
			tasks = tasksDao.getTasksById(tasksId);
		} catch (Exception e) {
			System.out.println("GetTasks Service Error ! ");
			e.printStackTrace();
		}
		return tasks;
	}
	
	public List<Tasks> getAllTasks() {
		List<Tasks> list = new ArrayList();
		try {
			list = tasksDao.getAllTasks();
		} catch (Exception e) {
			System.out.println("GetAllTasks Service Error ! ");
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Tasks> getAllTasksById(String todolistId) {
		List<Tasks> list = new ArrayList();
		try {
			list = tasksDao.getAllTasksById(todolistId);
		} catch (Exception e) {
			System.out.println("GetAllTasksById Service Error ! ");
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean completeTasks(String tasksId) throws Exception {
		boolean result = false;
		try {
			result = tasksDao.completeTasks(tasksId) > 0;
		} catch (Exception e) {
			System.out.println("CompleteTasks Service Error ! ");
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean resetTasks(String tasksId) throws Exception {
		boolean result = false;
		try {
			result = tasksDao.resetTasks(tasksId) > 0;
		} catch (Exception e) {
			System.out.println("ResetTasks Service Error ! ");
			e.printStackTrace();
		}
		return result;
	}
}
