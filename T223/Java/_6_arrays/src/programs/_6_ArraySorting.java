package programs;

import java.util.Arrays;

public class _6_ArraySorting {

	public static void main(String[] args) 
	{
		int numbers[] = {5,2,9,1}; //numbers.length = 4-1 = 3
		System.out.println(Arrays.toString(numbers));
		for(int i=0; i<numbers.length-1; i++) //0,1,2
		{
			for(int j=0; j<numbers.length-1; j++)
			{
				if(numbers[j]>numbers[j+1]) //numbers[0] = 5, numbers[1] = 2 : 5>2
				{
					int temp = numbers[j] ; //numbers[0] = 5 therefore temp=5
					numbers[j] = numbers[j+1]; //numbers[0] = 2
					numbers[j+1] = temp; //numbers[1] = 5
					System.out.println(Arrays.toString(numbers));	 
				}
			}
		}

	}

}
