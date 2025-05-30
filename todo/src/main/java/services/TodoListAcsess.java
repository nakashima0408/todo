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
	
	public List<Todo> getAllTask(){
		List<Todo> list = new ArrayList<>();
		String sql = "SELECT * FROM tasks ORDER BY deadline";

		try(Connection conn = Db.open();
	             PreparedStatement ps = conn.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()){
			
			while (rs.next()) {
                Todo t = new Todo(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDate("deadline"),
                    rs.getString("assignee"),
                    rs.getBoolean("completed")
                );
                list.add(t);
			}
			 for(Todo t : list) {
				 System.out.println(t.getName());// ここを追加
			 }
		}catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
		return list;
			
	}
	
	public Todo getTaskById(int id) {
		String sql = "select * from tasks where id = ?;";
		Todo task = null;

		try (
			Connection con = Db.open();
			PreparedStatement ps = con.prepareStatement(sql);){
			ps.setInt(1, id);
			
			try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    task = new Todo(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("deadline"),
                        rs.getString("assignee"),
                        rs.getBoolean("completed")
                    );
                }
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return task;

	}
	
	public void updateTask(Todo todo) {
        String sql = "UPDATE tasks SET name=?, deadline=?, "
        		+ "assignee=?, completed=? WHERE id=?";	
	
        try (
				Connection con = Db.open();
				PreparedStatement ps = con.prepareStatement(sql);){
        	
        	ps.setString(1, todo.getName());
            ps.setDate(2, todo.getDeadline());
            ps.setString(3, todo.getAssignee());
            ps.setBoolean(4, todo.isCompleted());
            ps.setInt(5, todo.getId());
            ps.executeUpdate();

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
        	
	public void deleteTask(int id) {
        String sql = "DELETE FROM tasks WHERE id=?";
        
        try (
				Connection con = Db.open();
				PreparedStatement ps = con.prepareStatement(sql);){
        	
        	ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
	}   	
	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
