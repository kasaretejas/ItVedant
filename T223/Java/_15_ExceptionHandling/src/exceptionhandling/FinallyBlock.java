package exceptionhandling;

import java.util.InputMismatchException;

public class FinallyBlock {

	public static void main(String[] args) 
	{
		// finally executes : when there is no exception
		int a=10;
		int b=2;
		try 
		{
			System.out.println(a/b);
		}
		catch(ArithmeticException e)
		{
			System.out.println("cant divide by zero");
		}
		finally
		{
			System.out.println("executing finally block");
		}
		
		// finally executes : when there is exception, but handled
		int c=10;
		int d=0;
		try 
		{
			System.out.println(c/d);
		}
		catch(ArithmeticException e)
		{
			System.out.println("cant divide by zero");
		}
		finally
		{
			System.out.println("executing finally block");
		}
		
		// finally executes : when there is exception, but not handled
		int p=10;
		int q=0;
		try 
		{
			System.out.println(p/q);
		}
		catch(InputMismatchException e)
		{
			System.out.println("enter number only");
		}
		finally
		{
			System.out.println("executing finally block");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
