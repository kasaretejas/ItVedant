package basics;

import java.util.Arrays;

public class ArrayCreation {

	public static void main(String[] args) 
	{
		// when we know the values
		int numbers[] = {5,10,17,27};
		System.out.println(numbers.length); //4
		System.out.println(numbers); //[I@4617c264
		System.out.println(Arrays.toString(numbers)); //[5, 10, 17, 27]
		
		// when we dont know the values
		int[] x = new int[3];
		int [] y = new int[3];
		int z[] = new int[3];
		
		int values[]=new int[3];
		System.out.println(values.length); //3
		System.out.println(values); //[I@36baf30c
		System.out.println(Arrays.toString(values)); //[0, 0, 0]
		
		values[0]=54;
		values[1]=36;
		values[2]=29;
		System.out.println(Arrays.toString(values));
		
		//values[3]=12; //Exception
		

	}

}











