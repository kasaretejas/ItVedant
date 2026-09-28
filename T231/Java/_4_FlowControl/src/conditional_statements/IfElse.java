package conditional_statements;

import java.util.Scanner;

public class IfElse {

	public static void main(String[] args) 
	{
		//take a number from user and check for even odd
		//to read user input we take help of java bulit in class - Scanner
		//since Scanner is a class, it has some built in methods to read data according to data type
		//ex : int data -----> nextInt()
		//     float data ---> nextFloat()
		//to ready string data --> next()
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int number  = sc.nextInt();
		
		if(number%2==0)
		{
			System.out.println(number + " is even");
		}
		else
		{
			System.out.println(number + " is odd");
		}

	}

}
