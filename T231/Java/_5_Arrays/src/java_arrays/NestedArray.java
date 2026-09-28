package java_arrays;

import java.util.Arrays;

public class NestedArray {

	public static void main(String[] args) 
	{
		System.out.println("---1D Array----");
		int[] numbers=new int[3];
		numbers[0]=45;
		numbers[1]=23;
		numbers[2]=96;
		//    [45, 23, 96]
		System.out.println(Arrays.toString(numbers));
		for(int number:numbers)
		{
			System.out.println(number);
		}
		
		System.out.println("----Multi Dimensional Array----");
		int[][] marks = new int[2][3]; //2 rows : 0,1 ...... 3 columns: 0,1,2
		marks[0][0] = 98;
		marks[0][1] = 45;
		marks[0][2] = 82;
		
		marks[1][0] = 12;
		marks[1][1] = 24;
		marks[1][2] = 99;
		//  [ [98, 45, 82], [12, 24, 99] ]
		System.out.println(Arrays.toString(marks[0]));
		System.out.println(Arrays.toString(marks[1]));
		for(int[] nestedMarks:marks)
		{
			System.out.println(Arrays.toString(nestedMarks));
			for(int mark:nestedMarks)
			{
				System.out.println(mark);
			}
		}
		

	}

}
