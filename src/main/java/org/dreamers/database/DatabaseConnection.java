package org.dreamers.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.dreamers.model.User;


public class DatabaseConnection {
	
	private Connection db_connection = null;
	
	private String DB_ADDRESS = "jdbc:mysql://localhost:3306/";
	
	private String DB_NAME = "DreamerRoadMap";
	
	private String DB_USER = "newuser";
	
	private String DB_PASSWORD = "password";
	
	public DatabaseConnection()
	{
		
	}
	
	public void open() throws Exception
	{
		if(db_connection == null)
		{
			Class.forName("com.mysql.jdbc.Driver");
			db_connection = DriverManager.getConnection(DB_ADDRESS + DB_NAME + "?user=" 
					+ DB_USER + "&password=" + DB_PASSWORD);
		}
	}
	
	public void close() throws Exception
	{
		if(db_connection != null)
		{
			db_connection.close();
		}
	}
	
	public Connection getConnection()
	{
		return db_connection;
	}
}
