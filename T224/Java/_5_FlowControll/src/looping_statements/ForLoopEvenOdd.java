package looping_statements;

public class ForLoopEvenOdd {

	public static void main(String[] args) 
	{
		//display even and odd numbers between 1-5
		//RULE : whenever you get one range, try to display that range first
		for(int i=1; i<=5;i++)
		{
			if(i%2==0)
			{
				System.out.println(i + " is even");
			}
			else
			{
				System.out.println(i + " is odd");
			}
		}

	}

}
