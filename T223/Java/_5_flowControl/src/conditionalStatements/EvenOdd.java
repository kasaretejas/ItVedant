package conditionalStatements;

import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number ---->"); //IMP : i wrote print() not println()
		int num = scanner.nextInt();
		//System.out.println(num);
		if(num%2==0)
		{
			System.out.println(num + " is even number");
		}
		else
		{
			System.out.println(num + " is odd number");
		}

	}

}
