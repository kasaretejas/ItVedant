package array_programs;

public class _3_SumOfArray {

	public static void main(String[] args) 
	{
		int numbers[]= {2,1,5,3};
		int sum=0;
		for(int number:numbers)
		{
			sum = sum+number; //sum+=number;
		}
		System.out.println("sum of array is :"+sum);

	}

}
