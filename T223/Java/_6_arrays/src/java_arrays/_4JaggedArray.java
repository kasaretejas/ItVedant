package java_arrays;

import java.util.Arrays;

public class _4JaggedArray {

	public static void main(String[] args) 
	{
		int prices[][] = new int[2][];
		
		prices[0] = new int[3];
		prices[1] = new int[5];
		
		prices[0][0] = 95;
		prices[0][1] = 85;
		prices[0][2] = 75;
		
		prices[1][0] = 65;
		prices[1][1] = 55;
		prices[1][2] = 45;
		prices[1][3] = 35;
		prices[1][4] = 25;
		
		for(int[] internalArray:prices)
		{
			System.out.println(Arrays.toString(internalArray));
			for(int price: internalArray)
			{
				System.out.println(price);
			}
		}

	}

}
