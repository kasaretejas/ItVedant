package list_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayListLinkedList {

	public static void main(String[] args) 
	{
		//heterogenous arrylist
		ArrayList arrayList = new ArrayList();
		arrayList.add(12);
		arrayList.add("hello");
		System.out.println(arrayList);
		
		//arraylist
		//ArrayList<WrapperClass> arraylist_name = new ArrayList<>();
		//<> ----> generics 
		ArrayList<Integer> marks = new ArrayList<>();
		
		//adding elements
		//marks.add("hii");
		marks.add(12);
		marks.add(7);
		marks.add(12);
		System.out.println(marks);
		marks.add(0,50);
		System.out.println(marks);
		//marks.addAll(otherCollection); ---> add other collection (set/queue/list) into this list 
		//marks.addAll(1,otherCollection);
		
		//creating list from array
		List<Integer> list1=Arrays.asList(10,30,43,87,99);
		System.out.println(list1);
		
		//reading values from list
		System.out.println(list1.get(0));
		//System.out.println(list1.get(35));
		System.out.println(list1.size());
		System.out.println(list1.isEmpty());
		
		//update
		System.out.println(marks);
		marks.add(0,25);
		System.out.println(marks);
		marks.set(0, 35);
		System.out.println(marks);
		
		//remove
		marks.remove(0);
		System.out.println(marks);
		//marks.removeAll(nameOfOtherCollection);
		//marks.clear();
		
		//searching
		System.out.println(marks.indexOf(12));
		System.out.println(marks.lastIndexOf(12));
		System.out.println(marks.contains(50));
		
		//sorting
		marks.sort(null);
		System.out.println(marks);
		marks.sort(Comparator.reverseOrder());
		System.out.println(marks);
		
		
		

	}

}
