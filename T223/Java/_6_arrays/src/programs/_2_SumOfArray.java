package programs;

public class _2_SumOfArray {

	public static void main(String[] args) 
	{
		//find sum of given numbers in array
		int prices[] = {10,15,5,20};
		int sum=0;
		for(int price:prices)
		{
			System.out.println(price);
			sum+=price;
		}
		System.out.println("Sum of array is "+sum);

	}

}
