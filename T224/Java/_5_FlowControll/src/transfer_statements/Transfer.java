package transfer_statements;

public class Transfer {

	public static void main(String[] args) 
	{
		//you can buy anything but item worth 199
		//do not buy item worth 199
		int prices[]= {299,99,149,199,399,349,199,249};
		for(int price:prices)
		{
			if(price==199)
			{
				continue; //skip current iteration and go for next towards loop
				//System.out.println("hello"); //unreachable code
			}
			System.out.println(price);
		}
		
		//stop/come out of the loop as soon as you get number 25
		System.out.println("-------break--------");
		int numbers[]= {12,34,56,25,90,25,70};
		for(int number:numbers)
		{
			if(number==25)
			{
				break;//stop execution and go out of the loop
				//System.out.println("hello"); //unreachable code
			}
			System.out.println(number);
		}

	}

}
