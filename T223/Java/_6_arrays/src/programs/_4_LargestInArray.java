package programs;

public class _4_LargestInArray {

	public static void main(String[] args) 
	{
		int numbers[] = {3,1,5,2,7,4}; //expected output : 7
		int largest = numbers[0]; //3
		for(int number : numbers)
		{
			if(number>largest) largest = number;
			//3>3
			//1>3
			//5>3  largest = 5
			//2>5
			//7>5  largest = 7
			//4>7
		}
		System.out.println("Largest number is "+largest);
	}

}
