package java_arrays;

public class LargestInArray {

	public static void main(String[] args) 
	{
		//find largest number in array
		int[] numbers = {3,2,7,9,4,6};
		//let the number at index zero is largest
		int largest = numbers[0]; //3.....7.....9....
		for(int number : numbers)
		{
			if(number>largest)
			{
				largest=number;
			}	
		}
		System.out.println(largest);
	}

}
