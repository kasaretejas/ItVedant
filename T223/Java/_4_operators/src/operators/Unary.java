package operators;

public class Unary {

	public static void main(String[] args) 
	{
		// there are 4 varients of unary operator
		//1. pre inc ------> ++x  --> first increment then access
		//2. post inc -----> x++  --> first access then increment
		//3. pre dec  -----> --y  --> first decrement then access
		//4. post dec -----> y--  --> first access then decrement
		
		int x = 10;
		System.out.println(x++ + --x); //20
						//  10+10
		int y=7;
		System.out.println(--y + y++ - ++y);
		
		
		

	}

}
