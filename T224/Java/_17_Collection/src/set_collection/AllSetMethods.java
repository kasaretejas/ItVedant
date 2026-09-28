package set_collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class AllSetMethods {

	public static void main(String[] args) 
	{
		List<Integer> list=Arrays.asList(44,11,88,11);
		
		HashSet<Integer> hashset = new HashSet<>();
		hashset.add(40);
		hashset.add(10);
		hashset.add(30);
		hashset.add(10);
		System.out.println(hashset);
		
		hashset.addAll(list);
		System.out.println(hashset);
		
		LinkedHashSet<Integer> linkedset = new LinkedHashSet<>();
		linkedset.add(40);
		linkedset.add(10);
		linkedset.add(30);
		linkedset.add(10);
		System.out.println(linkedset);
		linkedset.addAll(list);
		System.out.println(linkedset);
		
		TreeSet<Integer> treeset = new TreeSet<>();
		treeset.add(40);
		treeset.add(10);
		treeset.add(30);
		treeset.add(10);
		System.out.println(treeset);
		
		treeset.addAll(list);
		System.out.println(treeset);
		
		
		//utility
		System.out.println(treeset.isEmpty());
		System.out.println(treeset.contains(10));
		System.out.println(treeset.size());
		
		//looping/access
		Iterator<Integer> itr=treeset.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		treeset.forEach((n)->{ System.out.println(n);});
		
		for(int item:treeset)
		{
			System.out.println(item);
		}
		
		//remove
		treeset.remove(Integer.valueOf(88));
		System.out.println(treeset);
		
		treeset.clear();
		System.out.println(treeset);

	}

}
