package database_operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.xdevapi.PreparableStatement;

import database_connection.Database;

public class DatabaseOperations 
{
	public static void main(String[] args) throws SQLException 
	{
		Scanner scanner  = new Scanner(System.in);
		int choice = 0;
		String doYouWantToContinue="";
		do 
		{
			//collecting input from user
			System.out.println("Please select your choice");
			System.out.println("1. Get all Employees");
			System.out.println("2. Add New Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. Exit");
			System.out.print("---->");
			choice = scanner.nextInt();
			switch(choice)
			{
				case 1: 
					getAllEmployees();
					break;
				case 2:
					addNewEmployee();
					break;
				case 3:
					updateExistingEmployee();
					break;
				case 4:
					System.out.println("Thank you for using our application");
					System.exit(0);
				default:
					System.out.println("Please select correct choice");	
			}
			System.out.print("Do you want to continue (y/n) --->");
			doYouWantToContinue = scanner.next();
			if(doYouWantToContinue.equals("n"))
			{
				System.out.println("Thank you for using our application");
			}
		}
		while(doYouWantToContinue.equals("y"));
	}
	
	public  static void getAllEmployees() throws SQLException
	{
		Connection connection=Database.connect();
		String query = "select * from employee;"; 
		Statement statement=connection.createStatement(); //String to SQL convertion
		ResultSet resultSet=statement.executeQuery(query); //SQL query execution
		if(resultSet==null)
		{
			System.out.println("There is no data in the table");
		}
		else
		{
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getFloat(3));
			}
		}
	}
	
	public  static void addNewEmployee() throws SQLException
	{
		String query="insert into employee(name, salary) values(?,?);";
		
		Connection connection=Database.connect();
		PreparedStatement preparedStatement =connection.prepareStatement(query); //String to SQL
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Employee Name --->");
		String name = scanner.next();
		preparedStatement.setString(1, name); //1 is first question mark
		
		System.out.println("Enter Employee Salary --->");
		float salary = scanner.nextFloat();
		preparedStatement.setFloat(2, salary); //2 is second question mark
		
		int noOfRowsAffected=preparedStatement.executeUpdate();
		if(noOfRowsAffected>0)
		{
			System.out.println("New Employee Added");
		}
		else
		{
			System.out.println("Insertion failed");
		}
		
		
	}
	
	public  static void updateExistingEmployee() throws SQLException
	{
		String query="update employee set name=?, salary=? where id=?;";
		
		Connection connection=Database.connect();
		PreparedStatement preparedStatement =connection.prepareStatement(query); //String to SQL
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Employee id to be updated --->");
		int id = scanner.nextInt();
		preparedStatement.setInt(3, id); //3 means third question mark
		
		System.out.println("Enter Employee name --->");
		String name = scanner.next();
		preparedStatement.setString(1, name); //1 means first question mark
		
		System.out.println("Enter Employee Salary --->");
		float salary = scanner.nextFloat();
		preparedStatement.setFloat(2, salary); //2 means second question mark
		
		int noOfRowsAffected=preparedStatement.executeUpdate();
		if(noOfRowsAffected>0)
		{
			System.out.println("Employee Updated!");
		}
		else
		{
			System.out.println("Updatation failed");
		}
		
		
	}
	
}













