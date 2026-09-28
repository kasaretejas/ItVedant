package exceptionhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Basics1 {

	public static void main(String[] args) 
	{
//		exception handled by JVM : always abnormal termination
//		int x=5;
//		int y=2;
//		System.out.println(x/y);
//		System.out.println("done"); //normal termination
		
//		int x=5;
//		int y=0;
//		System.out.println(x/y); 
//		System.out.println("done");
//		Exception in thread "main" java.lang.ArithmeticException: / by zero
//		abnormal termination
		
//---------------------------------------------------------------------------
//		 exception handle by developer
		int a=5;
		int b=0;
		try
		{
			System.out.println(a/b);
		}
		catch(ArithmeticException e)
		{
			System.out.println("do not divide by zero");
		}
		System.out.println("done");

// multiple exceptions at a time
		System.out.println("----mutiple catch------");
		Scanner scanner = new Scanner(System.in);
		
		try
		{
			System.out.println("enter 1st number :");
			int n1=scanner.nextInt();
			System.out.println("enter 2nd number :");
			int n2=scanner.nextInt();

			System.out.println(n1/n2);
		}
		catch(ArithmeticException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("cant divide by zero");
		}
		catch (InputMismatchException e) 
		{
			System.out.println(e.getMessage());
			System.out.println("enter number only");
		}
		
		System.out.println("DONE!");
		

	}

}






