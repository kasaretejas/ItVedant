package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection 
{
	static Connection connectToDatabase() throws SQLException
	{
		String databaseURL="jdbc:mysql://localhost:3307/jdbc";
		String username="root";
		String passowrd="root";
		
		Connection connection=DriverManager.getConnection(databaseURL, username, passowrd);
		if(connection!=null)
		{
			return connection;
		}
		else
		{
			return connection;
		}
	}
}
