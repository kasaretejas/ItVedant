package stream_api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperations {

	public static void main(String[] args) 
	{
		List<Integer> list1=Arrays.asList(8,5,2,4,9);
		
		list1.stream().filter(n-> n%2==0).forEach(n-> System.out.println(n));
		System.out.println();
		list1.stream().map(n -> n+2).forEach(n -> System.out.println(n));
		System.out.println();
		list1.stream().filter(n->n%2==0).map(n->n*2).forEach(n->System.out.println(n));
		

		List<String> list2=Arrays.asList("8","5","2","4","9");
		List<Integer> intList=list2.stream().map(n-> Integer.parseInt(n)).toList();
		System.out.println();
		
		//flatmap --> [[2,7],[9,3],[4,9]] ---> flatmap ----> 2,7,9,3,4,9
		List<List<Integer>> list3=Arrays.asList(Arrays.asList(2,7),Arrays.asList(9,3),Arrays.asList(4,9));
		System.out.println(list3);
		
		List<Integer> list5=list3.stream().flatMap(list4 -> list4.stream()).toList();
		System.out.println(list5);
		System.out.println();
		
		List<Integer> list6=Arrays.asList(8,5,2,4,9,2,7,1);
		System.out.println(list6);
		List<Integer> list7=list6.stream().distinct().toList();
		System.out.println(list7);
		
		List<Integer> list8=list6.stream().sorted().toList();
		System.out.println(list8);
		
		List<Integer> list9=list6.stream().sorted(Comparator.reverseOrder()).toList();
		System.out.println(list9);
		
		
	}

}
















