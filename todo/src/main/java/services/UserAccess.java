package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import utils.Db;

public class UserAccess {
	
	public User findUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        try (
            Connection con = Db.open();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
           
            
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        
        return null;
    }
	
	public boolean CreateUser(String username, String password) {
	    String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
	    
	    try (
	    	Connection con = Db.open();
	        PreparedStatement ps = con.prepareStatement(sql);
	    ){
	    	ps.setString(1, username);
	    	ps.setString(2, password);
	    	ps.executeUpdate();
	    	return true;
	    	
		} catch (SQLException | NamingException e) {
            e.printStackTrace();
            return false;
		}
	}
}
