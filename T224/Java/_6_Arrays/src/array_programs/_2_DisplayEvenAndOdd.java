package array_programs;

public class _2_DisplayEvenAndOdd {

	public static void main(String[] args) 
	{
		int numbers[]= {2,5,7,8};
		for(int number:numbers)
		{
			if(number%2==0) System.out.println(number + " is even");
			else System.out.println(number + " is odd");
		}

	}

}
