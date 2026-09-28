package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;


public class DatabaseOperations 
{
	static void addEmployee() throws SQLException 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter employee id -->");
		int id = scanner.nextInt();
		System.out.println("Enter employee name -->");
		String name = scanner.next();
		System.out.println("Enter employee salary -->");
		float salary = scanner.nextFloat();
		System.out.println("Enter employee department -->");
		String department = scanner.next();
		
		String insertQuery="insert into employee(id,name,salary,department) values (?,?,?,?);";
		
		Connection connection=DatabaseConnection.connectToDatabase();
		PreparedStatement preparedStatement =connection.prepareStatement(insertQuery);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setFloat(3, salary);
		preparedStatement.setString(4, department);
		
		int noOfRowsAffected=preparedStatement.executeUpdate();
		if(noOfRowsAffected == 0)
		{
			System.out.println("Insertion failed");
		}
		else
		{
			System.out.println("data inserted!!");
		}

	}
	static void viewEmployees() throws SQLException 
	{
		String selectAllEmployeesString = "select * from employee;";
		
		Connection connection=DatabaseConnection.connectToDatabase();
		Statement statement =  connection.createStatement();
		ResultSet resultSet=statement.executeQuery(selectAllEmployeesString);
		
		while(resultSet.next())
		{
			System.out.println(resultSet.getInt(1) + "--->"+
							   resultSet.getString(2) + "--->"+
							   resultSet.getFloat(3) + "--->"+
							   resultSet.getString(4));
		}
		
	}
	static void updateEmployee() throws SQLException 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter employee id to update ---> ");
		int id = scanner.nextInt();
		
		ResultSet resultSet=getEmployeeById(id);
		while(resultSet.next())
		{
			System.out.println("Follwoing employee found!");
			System.out.println(resultSet.getInt(1) + "--->"+
					   resultSet.getString(2) + "--->"+
					   resultSet.getFloat(3) + "--->"+
					   resultSet.getString(4));
		}
		
		System.out.println("Enter new employee name -->");
		String name = scanner.next();
		System.out.println("Enter new employee salary -->");
		float salary = scanner.nextFloat();
		System.out.println("Enter new employee department -->");
		String department = scanner.next();
		
		String query = "update employee set name=?, salary=?, department=? where id=?;";
		
		Connection connection=DatabaseConnection.connectToDatabase();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1, name);
		preparedStatement.setFloat(2, salary);
		preparedStatement.setString(3, department);
		preparedStatement.setInt(4, id);
		
		int noOfRowsAffected=preparedStatement.executeUpdate();
		if(noOfRowsAffected == 0)
		{
			System.out.println("updation failed");
		}
		else
		{
			System.out.println("update successfully");
		}
	}
	static void deleteEmployee() 
	{
		System.out.println("Delete Employee");
	}
	
	static ResultSet getEmployeeById(int id) throws SQLException
	{
		String query=String.format("select * from employee where id=%d;", id);
		
		Connection connection=DatabaseConnection.connectToDatabase();
		Statement statement = connection.createStatement();
		ResultSet resultSet=statement.executeQuery(query);
		return resultSet;
		
	}
}














