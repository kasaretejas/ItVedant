package stream_api;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TerminalOperation {

	public static void main(String[] args) 
	{
		List<Integer> list1=List.of(2,5,7,1,4,8,4);
		
		list1.stream().forEach(n->System.out.println(n));
		
		System.out.println();
		
		list1.stream().map(n->n+1).forEach(n->System.out.println(n));
		
		System.out.println();
		
		List<Integer> list2=list1.stream().filter(n->n%2==0).toList();
		System.out.println(list2);
		
		System.out.println();
		
		Set<Integer> set1=list1.stream().filter(n->n%2==0).collect(Collectors.toSet());
		System.out.println(set1);
		
		
		long count=list1.stream().filter(n->n%2==0).count();
		System.out.println(count);
		
		
		int sum=list1.stream().filter(n->n%2==0).reduce(0,(a,b)->a+b);
		System.out.println(sum);

	}

}
