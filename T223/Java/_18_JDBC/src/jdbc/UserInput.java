package jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInput {

	public static void main(String[] args) throws SQLException 
	{
		//System.out.println(DatabaseConnection.connection());
		Scanner scanner = new Scanner(System.in);
			System.out.println("Select Your Choice :");
			System.out.println("1. View All Employees");
			System.out.println("2. Add new Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. Delete Employee");
			System.out.println("5. Exit");
			System.out.print("-------> ");
			int choice = scanner.nextInt();
			switch (choice) 
			{
				case 1:
					DatabaseOperations.viewEmployees();
					break;
				case 2:
					DatabaseOperations.addEmployee();
					break;
				case 3:
					DatabaseOperations.updateEmployee();
					break;
				case 4:
					DatabaseOperations.deleteEmployee();
					break;
				case 5:
					System.out.println("Thank you for using our application!");
					break;	
				default:
					System.out.println("Enter correct choice");
			}
		

		

	}

}
