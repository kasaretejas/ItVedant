package database_operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.xdevapi.PreparableStatement;

import database_connection.DatabaseConnection;

public class DatabaseOperations 
{

	public static void getAllEmployees() throws SQLException
	{
		Connection connection=DatabaseConnection.connect();
		String query = "select * from employee;";
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery(query);
		while(resultSet.next())
		{
			System.out.println(resultSet.getInt(1)+":"+resultSet.getString(2));
		}
		
	}
	
	public static void getEmployeeById() throws SQLException
	{
		Connection connection=DatabaseConnection.connect();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Employee Id:");
		int id = scanner.nextInt();
		
		String query = "select * from employee where id="+id+";";
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery(query);
		if(resultSet.isBeforeFirst())
		{
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt(1)+":"+resultSet.getString(2));
			}
		}
		else
		{
			System.out.println("Employee with id "+id+ " does not exists!");
		}
		
	}
	
	public static void addEmployee() throws SQLException
	{
		Connection connection=DatabaseConnection.connect();
		
		Scanner scanner = new Scanner(System.in);
		
		String query="insert into employee(id,name,age,salary,department) values (?,?,?,?,?);";
		
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		System.out.println("Enter employee Id :");
		int id=scanner.nextInt();
		preparedStatement.setInt(1, id);
		
		System.out.println("Enter employee Name :");
		preparedStatement.setString(2, scanner.next());
		
		System.out.println("Enter employee Age :");
		preparedStatement.setInt(3, scanner.nextInt());
		
		System.out.println("Enter employee Salary :");
		preparedStatement.setDouble(4, scanner.nextDouble());
		
		System.out.println("Enter employee Department :");
		preparedStatement.setString(5, scanner.next());
		
		int rowCount=preparedStatement.executeUpdate();
		if(rowCount>0)
		{
			System.out.println("Employee Added!");
		}
	}
	
	public static void updateEmployee() throws SQLException
	{
		Connection connection=DatabaseConnection.connect();
		System.out.println("updateEmployee");
	}
	
	public static void deleteEmployee() throws SQLException
	{
		Connection connection=DatabaseConnection.connect();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Employee Id:");
		int id = scanner.nextInt();
		
		String query = "delete from employee where id=?";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		int noOfRowsAffected=preparedStatement.executeUpdate();
		if(noOfRowsAffected>0)
		{
			System.out.println("Employee deleted");
		}
		else
		{
			System.out.println("Employee with id "+id+ " does not exists!");
		}	
	}
}
