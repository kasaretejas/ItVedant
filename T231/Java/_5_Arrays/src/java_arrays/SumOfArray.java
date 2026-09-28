package java_arrays;

public class SumOfArray {
	public static void main(String[] args) 
	{
		//find sum of elements present in above array 
		int[] numbers = {3,2,7,9,4,6};
		int sum = 0;
		for(int number:numbers)
		{
			System.out.println(number);
			sum = sum+number; //0+3 = 3
		}
		System.out.println(sum);
		
	}

}
