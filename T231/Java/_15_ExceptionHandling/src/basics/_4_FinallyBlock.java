package basics;

import java.util.InputMismatchException;

public class _4_FinallyBlock {

	public static void main(String[] args) 
	{
		System.out.println("start");
		try
		{
			System.out.println(13/0); //arithmatic
		}
		catch(InputMismatchException e)
		{
			System.out.println("please enter a number only");
		}
		finally
		{
			System.out.println("I will exceute even in undanled exception");
		}
		System.out.println("end");

	}

}
