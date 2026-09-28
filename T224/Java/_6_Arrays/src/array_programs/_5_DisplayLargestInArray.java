package array_programs;

public class _5_DisplayLargestInArray {

	public static void main(String[] args) 
	{
		int numbers[]= {2,1,4,3};
		int largest=numbers[0]; //2
		
		for(int number:numbers)
		{
			if(number>largest)
			{
				largest=number;
			}
		}

		System.out.println("largest number is: "+largest);
	}

}
