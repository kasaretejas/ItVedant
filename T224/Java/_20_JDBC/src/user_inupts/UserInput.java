package user_inupts;

import java.sql.SQLException;
import java.util.Scanner;

import database_operations.DatabaseOperations;

public class UserInput 
{
	public static void main(String[] args) throws SQLException 
	{
		Scanner scanner = new Scanner(System.in);
		int choice=0;
		String doYouWantToContinue="";
		do
		{
			System.out.println("--------- Welcome to EMS ---------");
			System.out.println("--------- select your choice ---------");
			System.out.println("1. Get All Employees \n2. Get Employee By Id");
			System.out.println("3. Add Employee      \n4. Update Employee");
			System.out.println("5. Delete Employee   \n6. Exit");
			System.out.print("-->");
			choice = scanner.nextInt();
			
			
			switch (choice) 
			{
				case 1: 
					DatabaseOperations.getAllEmployees();
					break;
				case 2: 
					DatabaseOperations.getEmployeeById();
					break;
				case 3: 
					DatabaseOperations.addEmployee();
					break;
				case 4: 
					DatabaseOperations.updateEmployee();
					break;
				case 5: 
					DatabaseOperations.deleteEmployee();
					break;
				case 6: 
					System.out.println("--------- Thank you for using our app ---------");
					System.exit(0);
				default:
					System.out.println("Please select correct choice");;
			}
			
			System.out.print("Do you want to continue (y/n) --->");
			doYouWantToContinue = scanner.next();
			if(doYouWantToContinue.equals("n")) 
				{
					System.out.println("--------- Thank you for using our app ---------");
				};
		}
		while(doYouWantToContinue.equals("y"));
	}
}
