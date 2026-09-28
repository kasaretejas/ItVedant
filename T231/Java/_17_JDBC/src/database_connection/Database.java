package database_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database 
{
	 static public Connection connect()
	{
		 final String URL = "jdbc:mysql://localhost:3307/t231_jdbc";
		 final String USERNAME = "root";
		 final String PASSWORD = "root";
		try 
		{ 
			Connection connection=DriverManager.getConnection(URL, USERNAME, PASSWORD); 
			return connection;	
		}
		catch (SQLException e) 
		{ 
			System.out.println("Connection failed!"); 
		}
		return null; 
	}
}
