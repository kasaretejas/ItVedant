package advanced_array;

import java.util.Arrays;

public class SingleMultiJagged {

	public static void main(String[] args) 
	{
		// single/one dimensional array
		int x[] = {5,2,7}; //creating 1-D array
		int numbers[]=new int[2]; //creating 1-D array
		System.out.println(numbers); //displaying 1-D array
		System.out.println(Arrays.toString(numbers)); //displaying 1-D array
		numbers[0] = 5; //adding values inside array
		numbers[1] = 8; //adding values inside array
		System.out.println(Arrays.toString(numbers)); //displaying 1-D array
		System.out.println(numbers[0]); //accessing one value from array
		for(int number:numbers) //accessing al values from array
		{
			System.out.println(number);
		}
		
		//multi dimensional array
		int y[][]= {{7,1,4},{3,7,0}}; //creating mulit dimensional array directly
		int values[][]=new int[2][3];
		System.out.println(Arrays.toString(values));
		System.out.println(values[0]);
		System.out.println(values[1]);
		System.out.println(Arrays.toString(values[0]));
		System.out.println(Arrays.toString(values[1]));
		
		values[0][0]=2;
		values[0][1]=3;
		values[0][2]=8;
		values[1][0]=7;
		values[1][1]=9;
		values[1][2]=4;
		
		System.out.println(Arrays.toString(values[0]));
		System.out.println(Arrays.toString(values[1]));
		
		for(int[] internalArray:values)
		{
			for(int value:internalArray)
			{
				System.out.print(value + " ");
			}
			System.out.println();
		}
		
		
		//creating jagged array
		int prices[][] = new int[3][]; //prices is an array consist of 3 internal arrays with no fixed number of columns
		prices[0] = new int[3]; //there will be 3 values in oth arrays
		prices[1] = new int[5]; //there will be 5 values in 1st arrays
		prices[2] = new int[2]; //there will be 2 values in 2nd arrays
		
		prices[0][0]=9;
		prices[0][1]=5;
		prices[0][2]=2;
		
		prices[1][0]=8;
		prices[1][1]=4;
		prices[1][2]=3;
		prices[1][3]=6;
		prices[1][4]=0;
		
		prices[2][0]=7;
		prices[2][1]=1;
		
		System.out.println(Arrays.toString(prices[0]));
		System.out.println(Arrays.toString(prices[1]));
		System.out.println(Arrays.toString(prices[2]));
		
		int z[][]= {{9,1},{8,2,6,0},{3}};
		

	}

}
