package stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateSteram {

	public static void main(String[] args) 
	{
		//stream from list
		List<Integer> list=Arrays.asList(10,3,6,9,2);
		Stream<Integer> streamFromList=list.stream();
		streamFromList.forEach(n-> System.out.println(n));
		
		
		//stream from set
		Set<Integer> set=Set.of(10,3,6,9,2);
		Stream<Integer> streamFromSet=set.stream();
		
		//stream from array of primitive data type
		int[] arr = {10,3,6,9,2};
		IntStream streamFromArr=Arrays.stream(arr);
		
		//stream from array of object
		String[] objectArr = {"hello", "bye","java"};
		Stream<String> streamFromStringArr=Arrays.stream(objectArr);
		
		//direct stream
		Stream<Integer> directStream=Stream.of(10,3,6,9,2);
		

	}

}
