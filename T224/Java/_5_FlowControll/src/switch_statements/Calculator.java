package switch_statements;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in); 
		System.out.print("Enter First number :");
		int n1 = scanner.nextInt();
		System.out.print("Enter Second number :");
		int n2 = scanner.nextInt();
		System.out.print("Select Operator +,-,*,/ :");
		String operator = scanner.next();
		
		switch (operator) 
		{
			case "+": 
				System.out.println("Addition is: "+(n1+n2));
				break;
			case "-": 
				System.out.println("Substraction is: "+(n1-n2));
				break;
			case "*": 
				System.out.println("Multiplication is: "+(n1*n2));
				break;
			case "/": 
				System.out.println("Division is: "+(n1/n2));
				break;
			default:
				System.out.println("Select correct operator");
		}
		
}

}
