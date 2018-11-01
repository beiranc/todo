package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Tasks;
import Util.ConnectionUtil;

public class TasksDao {
	ConnectionUtil connectionUtil = new ConnectionUtil();
	
	//����һ��tasks
	public int addTasks(Tasks tasks) throws Exception {
		Connection connection = connectionUtil.getconn();
		String sql = "INSERT INTO tasks(tasksId,title,contents,priority,createTime,deadline,is_del,todolistId) VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, tasks.getTasksId()); //tasksId
		pStatement.setString(2, tasks.getTitle()); //title
		pStatement.setString(3, tasks.getContents()); //contents
		pStatement.setInt(4, tasks.getPriority()); //priority
		pStatement.setString(5, tasks.getCreateTime()); //createTime
		pStatement.setString(6, tasks.getDeadline()); //deadline
		pStatement.setInt(7, 0); //is_del 0Ϊ���� 1Ϊɾ��
		pStatement.setString(8, tasks.getTodolistId()); //todolistId
		
		//result����0���ʾ�������ݳɹ�
		int result = pStatement.executeUpdate();
		return result;
	}
	
	//ɾ��һ��tasks
	public int deleteTasksById(String tasksId) throws Exception {
		Connection connection = connectionUtil.getconn();
		String sql = "UPDATE tasks SET is_del=1 WHERE tasksId=?";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, tasksId);
		
		//result����0���ʾɾ���ɹ�
		int result = pStatement.executeUpdate();
		return result;
	}
	
	//�޸�һ��tasks
	public int updateTasksById(Tasks tasks) throws Exception {
		Connection connection = connectionUtil.getconn();
		String sql = "UPDATE tasks SET title=? , contents=? , isFinished=? , priority=? , deadline=? ,todolistId=?";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, tasks.getTitle());
		pStatement.setString(2, tasks.getContents());
		pStatement.setBoolean(3, tasks.isFinished());
		pStatement.setInt(4, tasks.getPriority());
		pStatement.setString(5, tasks.getDeadline());
		pStatement.setString(6, tasks.getTodolistId());
		
		//result����0��ʾ�޸ĳɹ�
		int result = pStatement.executeUpdate();
		return result;
	}
	
	//��ѯһ��tasks
	public Tasks getTasks(String tasksId) throws Exception {
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
	
	//��ȡ���е�tasks
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
}