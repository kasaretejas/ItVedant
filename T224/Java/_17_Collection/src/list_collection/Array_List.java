package list_collection;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Array_List {

	//create --> add --> access --> modify --> remove --> search --> utility --> looping
	public static void main(String[] args) 
	{
		//create and add
		//ArrayList<Integer> list = new ArrayList<>();
		LinkedList<Integer> list = new LinkedList<>();
		list.add(10);
		list.add(40);  //add at the end
		list.add(20);  //add at the end
		System.out.println(list);
		
		list.add(1, 50);  //add at index 1
		System.out.println(list);
		
		List<Integer> list2=Arrays.asList(900,100,200); //creating list from array
		System.out.println(list2);
		
		list.addAll(list2); //adding one list into another
		System.out.println(list);
		
		list.addAll(0,list2); //adding one list into another at index 0
		System.out.println(list);
		
		//access
		System.out.println(list.get(0));
		//System.out.println(list.get(17));
		
		System.out.println(list.size());
		
		//modify
		list.set(0, 90);
		System.out.println(list);
		
		//remove
		list.remove(3); //item at index 3 will be removed
		System.out.println(list);
		
		list.remove(Integer.valueOf(50)); //this will remove number 50
		System.out.println(list);
		
		list.removeAll(list2);
		System.out.println(list);
		//list.clear(); //removes all elements
		
		//search
		System.out.println(list.contains(90));
		System.out.println(list.indexOf(90));
		System.out.println(list.lastIndexOf(90));
		
		//utility
		System.out.println(list.isEmpty());
		
		//int[] num=list.toArray(); ERROR
		Object[] nums=list.toArray();
		System.out.println(nums);
		System.out.println(Arrays.toString(nums));
		
		Object clonnedList=list.clone();
		System.out.println(clonnedList);
		
		List<Integer> subList=list.subList(0, 2);
		System.out.println(subList);
		
		//looping/iterating over list
		for(int element:list)
		{
			System.out.println(element);
		}
		
		list.forEach(element -> System.out.println(element));
		
		list.forEach(element -> 
		{
			if(element>30)
			{
				System.out.println(element);
			}
		});
		
		Iterator<Integer> itr=list.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		System.out.println("---- listIterator forward ---");
		ListIterator<Integer> itr_forward=list.listIterator();
		while(itr_forward.hasNext())
		{
			System.out.println(itr_forward.next());
		}
		
		while(itr_forward.hasPrevious())
		{
			System.out.println(itr_forward.previous());
		}
		
		
	}

}
