package looping_statements;

import java.util.Scanner;

public class WhileLoopNumberGuessing {

	public static void main(String[] args) 
	{
		int actualNumber =45;
		int guessedNumber = 0;
		Scanner scanner  = new Scanner(System.in);
		while(true)
		{
			System.out.print("Guess a number --->");
			guessedNumber = scanner.nextInt();
			if(guessedNumber==actualNumber)
			{
				System.out.println("You Won!!!");
				break;
			}
		}

	}

}
