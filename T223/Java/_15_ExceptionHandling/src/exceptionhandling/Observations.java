package exceptionhandling;

import java.util.InputMismatchException;

public class Observations {

	public static void main(String[] args) 
	{
		// 1 : code after line on which exception raise, will not executes
		int c=4;
		int d=0;
		try 
		{
			System.out.println("Hello before division");
			System.out.println(c/d);
			System.out.println("Hello after division");
		}
		catch(ArithmeticException e)
		{
			System.out.println("cant divide by zero");
		}
		
		//2. if exception is raised, but not handled, leads to abnormal termination
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
		
		//3. exception raised outside a try block always leads to abnormal termination
		int a=10;
		int b=0;
		try 
		{
			System.out.println(a/b);
		}
		catch(ArithmeticException e)
		{
			System.out.println("can not divide by zero");
			System.out.println(a/b);
		}
		System.out.println("DONE!");
		
		//solution for above problem : nested try-catch
		
		int x=10;
		int y=0;
		try 
		{
			System.out.println(x/y);
		}
		catch(ArithmeticException e)
		{
			System.out.println("can not divide by zero");
			try 
			{
				System.out.println(x/y);
			}
			catch(ArithmeticException ar)
			{
				System.out.println("can not divide by zero");
			}
		}
		System.out.println("DONE!");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
