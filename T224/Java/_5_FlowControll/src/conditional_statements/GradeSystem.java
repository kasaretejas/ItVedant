package conditional_statements;

import java.util.Scanner;

public class GradeSystem 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your marks ---->");
		double marks = scanner.nextDouble();
		if(marks>=91 && marks<100)
		{
			System.out.println("A Grade");
		}
		else if(marks>=81 && marks<90)
		{
			System.out.println("B Grade");
		}
		else if (marks>=71 && marks<80)
		{
			System.out.println("C Grade");
		}
		else
		{
			System.out.println("Failed");
		}
	}

}
