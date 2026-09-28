package java_arrays;

import java.util.Arrays;

public class _3MultidimensionalArray {

	public static void main(String[] args) 
	{
		int arr[] = new int[2];
		arr[0] = 10;
		arr[1] = 20;
		System.out.println(Arrays.toString(arr));  //[10,20]
		for(int value : arr)
		{
			System.out.println(value);
		}
		
		int multi[][] = new int[2][2];
		multi[0][0] = 25;
		multi[0][1] = 45;
		multi[1][0] = 65;
		multi[1][1] = 85;
		System.out.println(Arrays.toString(multi)); //[[I@4617c264, [I@36baf30c]
		//   [ 
		//     [25, 45],
		//     [65, 85]
		//   ]
		for(int[] value : multi)
		{
			System.out.println(value); //[I@4617c264,  [I@36baf30c
			System.out.println(Arrays.toString(value)); //[25, 45] , [65, 85]
		}
		
		//getting elements from multidimesional array
		for(int[] internalArray : multi)
		{
			for(int value : internalArray)
			{
				System.out.println(value);
			}
		}
		

	}

}
