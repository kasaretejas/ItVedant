package conditionalStatements;

import java.util.Scanner;

public class LargestAmongThreeNumbers {

	public static void main(String[] args) 
	{
		// take input 3 numbers and check for largest
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter first number --->");
		int n1 = scanner.nextInt();
		System.out.print("Enter second number --->");
		int n2 = scanner.nextInt();
		System.out.print("Enter third number --->");
		int n3 = scanner.nextInt();
		
		if(n1>n2 && n1>n3)
		{
			System.out.println(n1 +" is largers");
		}
		else if(n2>n1 && n2>n3)
		{
			System.out.println(n2 +" is largers");
		}
		else
		{
			System.out.println(n3 +" is largers");
		}

	}

}
