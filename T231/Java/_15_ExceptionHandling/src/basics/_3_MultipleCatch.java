package basics;

import java.util.InputMismatchException;
import java.util.Scanner;

public class _3_MultipleCatch {

	public static void main(String[] args) 
	{
		System.out.println("------Code starts----");
		
		Scanner scanner = new Scanner(System.in);	
		try
		{
			System.out.println("Enter first number :");
			int n1 = scanner.nextInt();
			System.out.println("Enter second number :");
			int n2 = scanner.nextInt();
			double result = n1/n2;
			System.out.println("result is :"+result);
		}
		catch(ArithmeticException e)
		{
			System.out.println("can not divide by zero");
			System.out.println(e.getMessage());
		}
		catch(InputMismatchException e)
		{
			System.out.println("Please enter number only");
			System.out.println(e.getMessage());
		}
		
		System.out.println("------Code ends----");
		
		//java.lang.ArithmeticException: / by zero
		//java.util.InputMismatchException

	}

}
