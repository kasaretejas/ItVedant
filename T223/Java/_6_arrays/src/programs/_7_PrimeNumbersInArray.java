package programs;

public class _7_PrimeNumbersInArray {

	public static void main(String[] args) 
	{
		int numbers[]= {7,8,17,15};
		
		for(int number:numbers)
		{
			boolean isPrime = true;
			for(int divideBy=2; divideBy<number; divideBy++)
			{
				if(number%divideBy==0) 
				{
					isPrime = false;
					System.out.println(number + " is not prime number");
					break;
				}	
			}
			if(isPrime) System.out.println(number + " is prime number");
			
		}

	}

}
