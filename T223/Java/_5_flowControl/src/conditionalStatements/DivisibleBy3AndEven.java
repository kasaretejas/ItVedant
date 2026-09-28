package conditionalStatements;

import java.util.Scanner;

public class DivisibleBy3AndEven {

	public static void main(String[] args) 
	{
		// take input number and check it is Divisible By 3 And also Even
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number ---->");
		int input = scanner.nextInt();
		if(input%3==0)
		{
			if(input%2==0)
			{
				System.out.println(input + " is the correct number");
			}
			else
			{
				System.out.println(input + " is divisible by 3 but not even");
			}
		}
		else
		{
			System.out.println(input + " is not divisible by 3");
		}

	}

}
