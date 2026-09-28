package array_programs;

public class _4_SumOfEvenNumbers {

	public static void main(String[] args) 
	{
		int numbers[]= {2,1,4,3};
		int sum=0;
		for(int number:numbers)
		{
			if(number%2==0) sum+=number;
		}
		System.out.println("sum of even numbers is :"+sum);

	}

}
