package java_arrays;

public class EvenInArray {

	public static void main(String[] args) 
	{
		//display even numbers from given array
		int[] numbers = {3,2,7,9,4,6};
		for(int number:numbers)
		{
			if(number%2==0)
			{
				System.out.println(number);
			}
		}
		
		

	}

}
