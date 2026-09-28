package programs;

public class _1_EvenOddInArray 
{
	public static void main(String[] args) 
	{
		//check each number in array for even or odd
		int numbers[] = {3,4,6,7,8,2,13};
		for(int number : numbers)
		{
			if(number%2==0)
			{
				System.out.println(number + " is even");
			}
			else
			{
				System.out.println(number + " is odd");
			}
		}
		
	}
}
