package set_collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class AllSets {

	public static void main(String[] args) 
	{
		HashSet<Integer> hashSet = new HashSet<>();
		hashSet.add(29);
		hashSet.add(73);
		hashSet.add(45);
		hashSet.add(67);
		hashSet.add(45);
		System.out.println(hashSet);
		
		LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add(29);
		linkedHashSet.add(73);
		linkedHashSet.add(45);
		linkedHashSet.add(67);
		linkedHashSet.add(45);
		System.out.println(linkedHashSet);
		
		TreeSet<Integer> treeSet  = new TreeSet<>();
		treeSet.add(29);
		treeSet.add(73);
		treeSet.add(45);
		treeSet.add(67);
		treeSet.add(45);
		System.out.println(treeSet);
		

	}

}
