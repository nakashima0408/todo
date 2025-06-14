package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import utils.Db;

public class TodoListAcsess {
	
	public List<Todo> getAllTaskByUser(int userId){//すべてのタスクを取得
		List<Todo> list = new ArrayList<>();
		String sql = "SELECT * FROM tasks WHERE user_id = ? ORDER BY deadline";

		try(Connection conn = Db.open();
	             PreparedStatement ps = conn.prepareStatement(sql)){
			
			 ps.setInt(1, userId);
			 ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
                Todo t = new Todo(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDate("deadline"),
                    rs.getString("assignee"),
                    rs.getBoolean("completed"),
                    rs.getInt("user_id")
                );
                list.add(t);
			}
		}catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
		return list;
			
	}
	
	public Todo getTaskById(int id, int userId) {//ID指定でタスクを取得
		String sql = "select * from tasks where id = ?;";
		Todo task = null;

		try (
			Connection con = Db.open();
			PreparedStatement ps = con.prepareStatement(sql)){
			 	ps.setInt(1, id);
	            ps.setInt(2, userId);
	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                task = new Todo(
	                    rs.getInt("id"),
	                    rs.getString("name"),
	                    rs.getDate("deadline"),
	                    rs.getString("assignee"),
	                    rs.getBoolean("completed"),
	                    rs.getInt("user_id")
	                );
	            }
	        } catch (SQLException | NamingException e) {
	            e.printStackTrace();
	        }
	        return task;
	    }
	
	public void updateTask(Todo todo) {
        String sql = "UPDATE tasks SET name=?, deadline=?, "
        		+ "assignee=?, completed=? WHERE id=? AND user_id=?";	
	
        try (
				Connection con = Db.open();
				PreparedStatement ps = con.prepareStatement(sql);){
        	
        	ps.setString(1, todo.getName());
            ps.setDate(2, new java.sql.Date(todo.getDeadline().getTime()));
            ps.setString(3, todo.getAssignee());
            ps.setBoolean(4, todo.isCompleted());
            ps.setInt(5, todo.getId());
            ps.setInt(6, todo.getUserId());
            ps.executeUpdate();

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
        	
	public void deleteTask(int id, int userId) {
        String sql =  "DELETE FROM tasks WHERE id = ? AND user_id = ?";
        
        try (
				Connection con = Db.open();
				PreparedStatement ps = con.prepareStatement(sql)){
        	
        	ps.setInt(1, id);
            ps.setInt(2, userId);
            ps.executeUpdate();

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
	}   
	
	public void insertTask(Todo todo) {
		String sql = "INSERT INTO tasks(name, deadline, assignee, completed, user_id) VALUES (?, ?, ?, ?, ?)";
		
		try(
			Connection con = Db.open();
			PreparedStatement ps = con.prepareStatement(sql);
			){
			ps.setString(1, todo.getName());
			ps.setDate(2, todo.getDeadline());
			ps.setString(3, todo.getAssignee());
	        ps.setBoolean(4, todo.isCompleted());
	        ps.setInt(5, todo.getUserId());
	        ps.executeUpdate();
		}catch(SQLException | NamingException e) {
			e.printStackTrace();
		}
		
	}
}