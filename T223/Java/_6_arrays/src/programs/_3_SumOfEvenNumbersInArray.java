package programs;

public class _3_SumOfEvenNumbersInArray {

	public static void main(String[] args) 
	{
		int numbers[] = {3,5,2,7,4}; //expected output : 6
		int sum=0;
		for(int number:numbers)
		{
			if(number%2==0) sum+=number;
		}
		System.out.println("sum of even numbers is "+sum);

	}

}
