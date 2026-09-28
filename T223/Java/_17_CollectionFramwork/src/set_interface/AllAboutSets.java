package set_interface;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class AllAboutSets {

	public static void main(String[] args) 
	{
		HashSet<Integer> hashSet = new HashSet<>();
		hashSet.add(30);
		hashSet.add(20);
		hashSet.add(10);
		hashSet.add(40);
		hashSet.add(10);
		System.out.println(hashSet);
		
		hashSet.remove(40);
		System.out.println(hashSet);
		
		LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add(30);
		linkedHashSet.add(20);
		linkedHashSet.add(10);
		linkedHashSet.add(40);
		linkedHashSet.add(10);
		System.out.println(linkedHashSet);
		
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(30);
		treeSet.add(20);
		treeSet.add(10);
		treeSet.add(40);
		treeSet.add(10);
		System.out.println(treeSet);

	}

}
