package java_arrays;

import java.util.Arrays;

public class _1Basics {

	public static void main(String[] args) 
	{
		//array creation
		int[] prices = new int[2];
		
		//getting array length
		System.out.println(prices.length); //2
		
		//adding elements in array : by using index, starts from zero
		prices[0] = 499; //here 0 is index/position
		prices[1] = 199;
		//try to add element in invalid index
		//prices[2] = 459; //ArrayIndexOutOfBoundsException
		
		
		//displaying array
		System.out.println(prices); //[I@4617c264
		System.out.println(Arrays.toString(prices));
		
		
		//accessing array elements : by using index/for loop
		System.out.println(prices[0]);
		System.out.println(prices[1]);
		//System.out.println(prices[2]);//ArrayIndexOutOfBoundsException
		
		System.out.println("--- accessing array elemets using simple for loop ----");
		for(int index=0; index<prices.length; index++)
		{
			System.out.println(prices[index]);
		}
		
		System.out.println("--- accessing array elemets using  enhanced for loop ----");
		for(int price:prices)
		{
			System.out.println(price);
		}
		
	}

}











