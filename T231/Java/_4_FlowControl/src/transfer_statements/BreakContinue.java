package transfer_statements;

public class BreakContinue 
{
	public static void main(String[] args) 
	{
		int[] prices = {199, 299, 499, 199, 399, 199, 99};
		//do not buy item worth 199
		for(int price:prices)
		{
			if(price==199)
			{
				continue; //continue for next iteration and skip current one. TOWARDS THE LOOP
			}
			else
			{
				System.out.println(price + " added to cart");
			}
		}
		
		//do not buy any if you find item worth 499
		System.out.println("----------------------------");
		for(int price:prices)
		{
			if(price==499)
			{
				System.out.println("stopping because I got 499");
				break; //stops the loop. OUT OF THE LOOP
			}
			else
			{
				System.out.println(price + " added to cart");
			}
		}
	}
}
