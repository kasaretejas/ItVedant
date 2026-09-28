package conditionalStatements;

import java.util.Scanner;

public class SquareRectangle {

	public static void main(String[] args) 
	{
		//take l and b as input and check for square or rectangle
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter length --->");
		int length = scanner.nextInt();
		System.out.print("Enter breadth --->");
		int breadth = scanner.nextInt();
		
		if(length == breadth)
		{
			System.out.println("It is square!");
		}
		else
		{
			System.out.println("It is rectangle!");
		}
		

	}

}
