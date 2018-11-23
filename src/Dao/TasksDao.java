package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Tasks;
import Model.Todolist;
import Util.ConnectionUtil;

public class TasksDao {
	ConnectionUtil connectionUtil = new ConnectionUtil();
	
	//增加一个tasks
	public int addTasks(Tasks tasks) throws Exception {
		Connection connection = connectionUtil.getconn();
		String sql = "INSERT INTO tasks(tasksId,title,contents,isFinished,priority,createTime,deadline,is_del,todolistId) VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, tasks.getTasksId()); //tasksId
		pStatement.setString(2, tasks.getTitle()); //title
		pStatement.setString(3, tasks.getContents()); //contents
		pStatement.setBoolean(4, tasks.isFinished()); //isFinished
		pStatement.setInt(5, tasks.getPriority()); //priority
		pStatement.setString(6, tasks.getCreateTime()); //createTime
		pStatement.setString(7, tasks.getDeadline()); //deadline
		pStatement.setInt(8, 0); //is_del 0为存在 1为删除
		pStatement.setString(9, tasks.getTodolistId()); //todolistId
		
		//result大于0则表示插入数据成功
		int result = pStatement.executeUpdate();
		return result;
	}
	
	//删除一个tasks
	public int deleteTasksById(String tasksId) throws Exception {
		Connection connection = connectionUtil.getconn();
		String sql = "UPDATE tasks SET is_del=1 WHERE tasksId=?";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, tasksId);
		
		//result大于0则表示删除成功
		int result = pStatement.executeUpdate();
		return result;
	}
	
	//修改一个tasks
	public int updateTasks(Tasks tasks) throws Exception {
		Connection connection = connectionUtil.getconn();
		String sql = "UPDATE tasks SET title=? , contents=? , isFinished=? , priority=? , deadline=? ,todolistId=?";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, tasks.getTitle());
		pStatement.setString(2, tasks.getContents());
		pStatement.setBoolean(3, tasks.isFinished());
		pStatement.setInt(4, tasks.getPriority());
		pStatement.setString(5, tasks.getDeadline());
		pStatement.setString(6, tasks.getTodolistId());
		
		//result大于0表示修改成功
		int result = pStatement.executeUpdate();
		return result;
	}
	
	//查询一个tasks
	public Tasks getTasksById(String tasksId) throws Exception {
		Connection connection = connectionUtil.getconn();
		String sql = "SELECT * FROM tasks WHERE tasksId=?";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, tasksId);
		
		ResultSet resultSet = pStatement.executeQuery();
		Tasks tasks = new Tasks();
		while(resultSet.next()) {
			tasks.setTitle(resultSet.getString("title"));
			tasks.setContents(resultSet.getString("contents"));
			tasks.setFinished(resultSet.getBoolean("isFinished"));
			tasks.setPriority(resultSet.getInt("priority"));
			tasks.setCreateTime(resultSet.getString("createTime"));
			tasks.setDeadline(resultSet.getString("deadline"));
			tasks.setIs_del(resultSet.getInt("is_del"));
			tasks.setTodolistId(resultSet.getString("todolistId"));
		}
		return tasks;
	}
	
	//获取所有的tasks
	public List<Tasks> getAllTasks() throws Exception {
		Connection connection = connectionUtil.getconn();
		String sql = "SELECT * FROM tasks WHERE is_del=0";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		ResultSet resultSet = pStatement.executeQuery();
		
		List<Tasks> list = new ArrayList();
		while(resultSet.next()) {
			Tasks tasks = new Tasks();
			tasks.setTasksId(resultSet.getString("tasksId"));
			tasks.setTitle(resultSet.getString("title"));
			tasks.setContents(resultSet.getString("contents"));
			tasks.setFinished(resultSet.getBoolean("isFinished"));
			tasks.setPriority(resultSet.getInt("priority"));
			tasks.setCreateTime(resultSet.getString("createTime"));
			tasks.setDeadline(resultSet.getString("deadline"));
			tasks.setIs_del(resultSet.getInt("is_del"));
			tasks.setTodolistId(resultSet.getString("todolistId"));
			list.add(tasks);
		}
		return list;
	}
	
	//根据TodolistId获取所有的Tasks
	public List<Tasks> getAllTasksById(String todolistId) throws Exception {
		Connection connection = connectionUtil.getconn();
		String sql = "SELECT * FROM tasks WHERE is_del=0 AND todolistId=?";
		//加入UserId进行分User查询
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, todolistId);
		ResultSet resultSet = pStatement.executeQuery();
		List<Tasks> list = new ArrayList();
		while(resultSet.next()) {
			Tasks tasks = new Tasks();
			tasks.setTasksId(resultSet.getString("tasksId"));
			tasks.setTitle(resultSet.getString("title"));
			tasks.setContents(resultSet.getString("contents"));
			tasks.setFinished(resultSet.getBoolean("isFinished"));
			tasks.setPriority(resultSet.getInt("priority"));
			tasks.setCreateTime(resultSet.getString("createTime"));
			tasks.setDeadline(resultSet.getString("deadline"));
			tasks.setIs_del(resultSet.getInt("is_del"));
			tasks.setTodolistId(todolistId);
			list.add(tasks);
		}
		return list;
	}
	
	//将任务设为完成
	public int completeTasks(String tasksId) throws Exception {
		Connection connection = connectionUtil.getconn();
		String sql = "UPDATE tasks SET isFinished=? WHERE tasksId=?";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setBoolean(1, true);
		pStatement.setString(2, tasksId);
		
		//result大于0表示修改成功
		int result = pStatement.executeUpdate();
		return result;
	}
}
