package array_programs;

import java.util.Arrays;

public class _6_SortArray {

	public static void main(String[] args) 
	{
		int numbers[]= {5,2,1,3};
		System.out.println("before sorting :"+ Arrays.toString(numbers));
		for(int i=0; i<numbers.length; i++)
		{
			for(int j=0; j<numbers.length-1;j++)
			{
				if(numbers[j]>numbers[j+1])
				{
					int temp=numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
		System.out.println("after sorting :"+ Arrays.toString(numbers));

	}

}
