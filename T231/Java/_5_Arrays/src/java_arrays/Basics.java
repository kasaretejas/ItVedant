package java_arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Basics {
	
	public static void main(String[] args) 
	{
		int x = 10;
		int age = 25;
		
		//1. when we already know the elements
		int[] ages={5, 9, 10, 34}; 
		int numbers[]={5, 9, 10, 34};
		int [] ids={5, 9, 10, 34};
		
		System.out.println(ages); //[I@4617c264 
		//[ ==> one dimensional array
		//I ==> int type
		//@4617c264  ==> virtual position in memory
		System.out.println(Arrays.toString(ages)); //[5, 9, 10, 34]
		
		//2. when we know how many elements but we dont know the elements
		int[] marks = new int[3]; //here 3 is length (number of values to be inserted in array)
		marks[0] = 97;
		marks[1] = 45;
		marks[2] = 89;
		//marks[3] = 70; // java.lang.ArrayIndexOutOfBoundsException:
		System.out.println(marks);
		System.out.println(Arrays.toString(marks));
		
		
		//access array elements
		String[] cities = {"thane", "pune", "delhi"};
		//                    0        1      2
		
		//get total elements in array (array length)
		System.out.println(cities.length); //3
		
		//displaying entire array
		System.out.println(Arrays.toString(cities)); //[thane, pune, delhi]
		
		//displaying elemnts at specific index
		System.out.println(cities[0]);  //thane
		System.out.println(cities[2]);  //delhi
		//System.out.println(cities[8]);  //java.lang.ArrayIndexOutOfBoundsException:
		
		//display elements one by one using for loop
		for(int i=0; i<cities.length; i++)
		{
			System.out.println(i);
			System.out.println(cities[i]);
		}
		
		
		//displaying elements using enhanced for loop
		for(String city:cities)
		{
			System.out.println(city);
		}
		
		
		
		System.out.println("------- default values by data types --------");
		byte a[] = new byte[3];
		short b[] = new short[3];
		int c[] = new int[3];
		long d[] = new long[3];
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(d));
		
		float e[] = new float[3];
		double f[] = new double[3];
		System.out.println(Arrays.toString(e));
		System.out.println(Arrays.toString(f));
		
		boolean g[] = new boolean[3];
		char h[] = new char[3];
		System.out.println(Arrays.toString(g));
		System.out.println(Arrays.toString(h));
		
		String i[] = new String[3];
		System.out.println(Arrays.toString(i));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
