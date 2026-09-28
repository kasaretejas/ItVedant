package loopingStatements;

import java.util.Scanner;

public class WhileLoop {

	public static void main(String[] args) 
	{
		//while(condition) {}
		//print 1 to 5 numbers using while loop
		System.out.println("---- 1 to 5 numbers -----");
		int i=1;
		while(i<=5)
		{
			System.out.println(i);
			i++;
		}
		
		//password guessing code
		System.out.println("---- password guessing code ----");
		String actualPassword = "1234";
		String enteredPassword = "";
		Scanner scanner = new Scanner(System.in);
		
		//while(!actualPassword.equals(enteredPassword))
		while(true)
		{
			System.out.print("Enter Your Password ---->");
			enteredPassword = scanner.next();
			if(actualPassword.equals(enteredPassword))
			{
				System.out.println("Welcome!");
				break;
			}
		}

	}

}













