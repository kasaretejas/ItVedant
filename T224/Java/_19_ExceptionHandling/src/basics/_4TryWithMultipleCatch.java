package basics;

import java.util.InputMismatchException;
import java.util.Scanner;

public class _4TryWithMultipleCatch {

	public static void main(String[] args) 
	{
		System.out.println("start");
		
		Scanner scanner = new Scanner(System.in);
		
		try
		{
			System.out.println("enter first number:");
			int n1 = scanner.nextInt();
			System.out.println("enter second number:");
			int n2 = scanner.nextInt();
			double result = n1/n2;
			System.out.println(result);
		}
		catch(InputMismatchException e)
		{
			System.out.println("Enter number only");
			System.out.println(e.getMessage());
		}
		catch(ArithmeticException e)
		{
			System.out.println("cant divide any number by zero");
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("end");
		

	}

}
