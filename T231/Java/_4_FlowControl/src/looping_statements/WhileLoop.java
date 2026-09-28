package looping_statements;

import java.util.Scanner;

public class WhileLoop {

	//we use while loop when only start(initialization) is given
	//ex : ask for password until user enters correct password
	//while also can be used when range is given (but technically use for loop only)
	//ex : display 1 to 5 numbers
	
	//initialization always done bofore while loop starts
	//while(condition) { inc/dec done inside body of while loop }
	public static void main(String[] args) 
	{
		//display 1 to 5 numbers using while loop
		int j=1;
		while(j<=5)
		{
			System.out.println(j);
			j++;
		}
		
		//display 91 to 95 numbers using while loop
		int k=91;
		while(k<=95)
		{
			System.out.println(k);
			k++;
		}
		
		//ask for password until we get correct one
		Scanner sc = new Scanner(System.in);
		String actualPassword = "abcd";
		String enteredPassword = "";
		
		while(!(actualPassword.equals(enteredPassword)))
		{
			System.out.println("Enter a password :");
			enteredPassword = sc.next();
			if(actualPassword.equals(enteredPassword))
			{
				System.out.println("Thak you for correct password");
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
