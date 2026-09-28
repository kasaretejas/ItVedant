package stream_api;

import java.util.Arrays;
import java.util.List;

public class Basics {

	public static void main(String[] args) 
	{
		List<Integer> numbers=Arrays.asList(2,5,7,4,6,9);
		
		//find even nos
		for(int number:numbers)
		{
			if(number%2==0)
			{
				System.out.println(number);
			}
		}
		
		System.out.println();
		//find even nos using stream
		numbers.stream().filter(number -> number%2==0).forEach(number-> System.out.println(number));
		
		List<Integer> evenNos=numbers.stream().filter(number -> number%2==0).toList();
		System.out.println(evenNos);
		
		//create stream-----> .stream()
		//intermediate optarion ----> search, sort, filter, map, avg, count etc
		//terminal opration -----> display, store
		

	}

}
