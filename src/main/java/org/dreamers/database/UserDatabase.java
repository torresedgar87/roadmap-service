package org.dreamers.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.dreamers.model.User;

public class UserDatabase 
{
	private Connection connection = null;
	
	public UserDatabase(Connection connection)
	{
		this.connection = connection;
	}
	
	public User getUser(String email) throws Exception
	{
		Statement statement = connection.createStatement();
		User user = null;
		ResultSet result = statement.executeQuery("SELECT * FROM User WHERE email=\"" + email + "\"");
		
		if(result.next())
		{
			user = new User();
			user.setEmail(result.getString("email"));
			user.setPassword(result.getString("password"));
		}
		
		return user;
	}
	
	public void createUser(User user) throws Exception
	{
		if(getUser(user.getEmail()) != null)
		{
			return;
		}
		
		PreparedStatement statement = connection.prepareStatement("INSERT INTO DreamerRoadMap"  + ".User(email, password) VALUES(?, ?)");
		
		statement.setString(1, user.getEmail());
		statement.setString(2, user.getPassword());
		
		statement.executeUpdate();
	}
}
