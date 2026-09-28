package list_framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayList_LinkedList {

	public static void main(String[] args) 
	{
//		creating a list
//		ArrayList<Integer> test1 = new ArrayList<>();
//		List<Integer> test2 = new ArrayList<>();
//		List<Integer> test3 = new LinkedList<>();
		
		
		List<Integer> list1 = Arrays.asList(11,22,33);
		System.out.println(list1);
		
		
		//ArrayList<Integer> list2 = new ArrayList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		list2.add(10);
		list2.add(20);
		list2.add(30);
		System.out.println(list2);
		
		list2.add(0, 40);
		System.out.println(list2);
		
		list2.addAll(list1);
		System.out.println(list2);
		
		list2.addAll(0,list1);
		System.out.println(list2);
		
		
		list2.remove(0);
		System.out.println(list2);
		
		list2.removeAll(list1);
		System.out.println(list2);

	}

}
