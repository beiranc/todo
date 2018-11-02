package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Todolist;
import Util.ConnectionUtil;

public class TodolistDao {
	ConnectionUtil connectionUtil = new ConnectionUtil();
	
	//增加一个todolist
	public int addTodolist(Todolist todolist) throws Exception {
		Connection connection = connectionUtil.getconn();
		String sql = "INSERT INTO todolist(todolistId,title,comments,userId,is_del) VALUES(?,?,?,?,?)";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, todolist.getTodolistId());
		pStatement.setString(2, todolist.getTitle());
		pStatement.setString(3, todolist.getComments());
		pStatement.setString(4, todolist.getUserId());
		pStatement.setInt(5, 0);
		
		//result大于0则插入数据成功
		int result = pStatement.executeUpdate();
		return result;
	}
	
	//删除一个todolist
	public int deleteTodolistById(String todolistId) throws Exception {
		Connection connection = connectionUtil.getconn();
		String sql = "UPDATE todolist SET is_del=1 WHERE todolistId=?";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, todolistId);
		
		//result大于0则插入数据成功
		int result = pStatement.executeUpdate();
		return result;
	}
	
	//修改一个todolist
	public int updateTodolist(Todolist todolist) throws Exception {
		Connection connection = connectionUtil.getconn();
		//SQL语句没加userId
		String sql = "UPDATE todolist SET title=? , comments=? WHERE todolistId=?";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, todolist.getTitle());
		pStatement.setString(2, todolist.getComments());
		pStatement.setString(3, todolist.getTodolistId());
		
		//result大于0则插入数据成功
		int result = pStatement.executeUpdate();
		return result;
	}
	
	//查询一个todolist
	public Todolist getTodolistById(String todolistId) throws Exception {
		Connection connection = connectionUtil.getconn();
		String sql = "SELECT * FROM todolist WHERE todolistId=?";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		pStatement.setString(1, todolistId);
		ResultSet resultSet = pStatement.executeQuery();
		Todolist todolist = new Todolist();
		while(resultSet.next()) {
			todolist.setTitle(resultSet.getString("title"));
			todolist.setComments(resultSet.getString("comments"));
			todolist.setUserId(resultSet.getString("userId"));
		}
		return todolist;
	}
	
	//获取所有的todolist
	public List<Todolist> getAllTodolist() throws Exception {
		Connection connection = connectionUtil.getconn();
		String sql = "SELECT * FROM todolist WHERE is_del=0";
		PreparedStatement pStatement = connection.prepareStatement(sql);
		ResultSet resultSet = pStatement.executeQuery();
		List<Todolist> list = new ArrayList();
		while(resultSet.next()) {
			Todolist todolist = new Todolist();
			todolist.setTodolistId(resultSet.getString("todolistId"));
			todolist.setTitle(resultSet.getString("title"));
			todolist.setComments(resultSet.getString("commnets"));
			todolist.setUserId(resultSet.getString("userId"));
			todolist.setIs_del(resultSet.getInt("is_del"));
		}
		return list;
	}
}
