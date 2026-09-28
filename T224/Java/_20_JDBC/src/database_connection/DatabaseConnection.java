package database_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection 
{
	public static Connection connect() throws SQLException
	{
		final String DATABASEURL="jdbc:mysql://localhost:3307/t224_jdbc";
		final String USERNAME="root";
		final String PASSWORD="root";
		
		Connection connection=DriverManager.getConnection(DATABASEURL, USERNAME, PASSWORD);
		return connection;
	}
}





